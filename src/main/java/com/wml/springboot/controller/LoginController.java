package com.wml.springboot.controller;

import com.wml.springboot.auth.BaseController;
import com.wml.springboot.auth.entity.Department;
import com.wml.springboot.auth.entity.Staff;
import com.wml.springboot.auth.service.DepartmentService;
import com.wml.springboot.auth.service.LoginService;
import com.wml.springboot.auth.service.MenuService;
import com.wml.springboot.auth.service.StaffService;
import com.wml.springboot.auth.tree.MenuTreeNode;
import com.wml.springboot.exception.MyException;
import com.wml.springboot.services.UserService;
import com.wml.springboot.util.RSAUtil;
import com.wml.springboot.util.SigarUtils;
import com.wml.springboot.util.StaffUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * <b>Title：</b>LoginController.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/4/24 - 14:29<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
@Controller
public class LoginController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    public UserService userService;

    @Autowired
    public MenuService menuService;

    @Autowired
    public LoginService loginService;

    @Autowired
    public DepartmentService departmentService;

    @Autowired
    public StaffService staffService;

    @GetMapping(value = "/login.html")
    public String login() {
        return "login/login";
    }

    @PostMapping(value = { "/login.json" })
    @ResponseBody
    public Map<String, Object> login(@Valid Staff user) {
        try {
            // String pwd = RSAUtil.decryptString(user.getPassword());
            this.loginService.login(user.getLoginName(), user.getPassword(), getSession());
            Map<String, Object> result = new HashMap<String, Object>();
            Staff staff = (Staff) getSession().getAttribute("LOGIN_STAFF");
            Department department = null;
            if (null != staff.getDepartmentId()) {
                department = this.departmentService.findDepartment(staff.getDepartmentId());
                result.put("department", department);
            }
            return success("OK");
        } catch(MyException e) {
            logger.error(e.getMessage(), e);
            return fail(e.getMessage());
        }catch(Exception e) {
            logger.error(e.getMessage(), e);
            return fail("登录失败");
        }
    }

    /*@PostMapping("/login")
    public String login(@Valid User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        String loginName = user.getUserName();
        logger.info("准备登陆用户 => {}", loginName);
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, user.getPassword());
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            logger.info("对用户[" + loginName + "]进行登录验证..验证开始");
            currentUser.login(token);
            logger.info("对用户[" + loginName + "]进行登录验证..验证通过");
        } catch (UnknownAccountException uae) {
            logger.info("对用户[" + loginName + "]进行登录验证..验证未通过,未知账户");
            redirectAttributes.addFlashAttribute("message", "未知账户");
        } catch (IncorrectCredentialsException ice) {
            logger.info("对用户[" + loginName + "]进行登录验证..验证未通过,错误的凭证");
            redirectAttributes.addFlashAttribute("message", "密码不正确");
        } catch (LockedAccountException lae) {
            logger.info("对用户[" + loginName + "]进行登录验证..验证未通过,账户已锁定");
            redirectAttributes.addFlashAttribute("message", "账户已锁定");
        } catch (ExcessiveAttemptsException eae) {
            logger.info("对用户[" + loginName + "]进行登录验证..验证未通过,错误次数过多");
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误次数过多");
        } catch (AuthenticationException ae) {
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            logger.info("对用户[" + loginName + "]进行登录验证..验证未通过,堆栈轨迹如下");
            redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
        }

        //验证是否登录成功
        if (currentUser.isAuthenticated()) {
            logger.info("用户[" + loginName + "]登录认证通过(这里可以进行一些认证通过后的一些系统参数初始化操作)");
            return "redirect:/index";
        } else {
            token.clear();
            return "redirect:/login";
        }
        //return "redirect:/index";
    }*/

    @RequestMapping("/logout.html")
    public String logout(RedirectAttributes redirectAttributes) throws Exception {
        //使用权限管理工具进行用户的退出，跳出登录，给出提示信息
        //SecurityUtils.getSubject().logout();
        //redirectAttributes.addFlashAttribute("message", "您已安全退出");
        this.loginService.logout(getSession());
        return "redirect:/login";
    }

    @RequestMapping(value = "/index.html")
    public String index(Model model) throws Exception {
        // 读取菜单列表
        List<MenuTreeNode> menuTree = menuService.buildMenuTree(StaffUtil.getLoginStaff().getLoginName(), getSession().getId(), getRequest().getContextPath());
        model.addAttribute("menuTree", menuTree);
        return "index";
    }

    @RequestMapping("/main.html")
    public String main(Model model) throws Exception {
        model.addAttribute("jvm", SigarUtils.getJvmInfos());
        model.addAttribute("cpu", SigarUtils.getCpuInfos());
        model.addAttribute("memory", SigarUtils.getMemoryInfos());
        model.addAttribute("os", SigarUtils.getOsInfos());
        //model.addAttribute("net", SigarUtils.getNetInfos());
        return "main";
    }

    @RequestMapping("/403.html")
    public String no() {
        return "403";
    }
}