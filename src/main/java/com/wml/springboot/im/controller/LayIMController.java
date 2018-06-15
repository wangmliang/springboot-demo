package com.wml.springboot.im.controller;

import com.wml.springboot.auth.entity.Staff;
import com.wml.springboot.im.entity.ImGroup;
import com.wml.springboot.im.service.ImService;
import com.wml.springboot.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springside.modules.web.Servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <pre>
 * <b>Title：</b>LayIMController.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/5/23 - 10:39<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
@RestController
@RequestMapping(value = "/layim")
public class LayIMController {

    private Logger logger = LoggerFactory.getLogger(LayIMController.class);

    @Autowired
    private ImService imService;

    /**
     * im初始化
     * @return
     */
    @GetMapping(value = "/base.json")
    public JsonResult getBaseData(){
        Map<String, Object> map = new HashMap<>();
        //我的信息
        return JsonResult.success(imService.imInit());
    }

    /**
     * tio 鉴权token
     * @return
     */
    @GetMapping(value = "/token.json")
    public JsonResult token() {
        Map<String, Object> map = new HashMap<>();
        try{
            Long userId = StaffUtil.getLoginStaff().getStaffId();
            if (null != StaffUtil.getLoginStaff()) {
                String key = String.format("%d_%d", userId, System.currentTimeMillis());
                String token = AESUtil.encyrpt(key);
                return JsonResult.success(token);
            } else {
                return JsonResult.fail("用户未登录");
            }
        } catch(Exception e) {
            logger.error(e.getMessage(), e);
            return JsonResult.fail("请求错误");
        }
    }

    /**
     * 上传图片
     * @param file
     * @param response
     * @param request
     * @return
     */
    @PostMapping(value = "/uploadImg.json")
    @ResponseBody
    public Map<String, Object> uploadImg(@RequestParam MultipartFile file, HttpServletResponse response, HttpServletRequest request) {
        Long staffId = StaffUtil.getLoginStaffId();
        String path = request.getSession().getServletContext().getRealPath("upload/img/" + staffId + "/");
        String files = FileUtil.savePicture(file, UUID.randomUUID().toString().replaceAll("-", ""), path);
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,String> submap = new HashMap<String,String>();
        if(files.length()>0){
            map.put("code","0");
            map.put("msg", "上传成功");
            submap.put("src", request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath() + "/upload/img/" + staffId + "/" + files + "?" + new Date().getTime());
        }else{
            submap.put("src", "");
            map.put("code","1");
            map.put("msg", "上传过程中出现错误，请重新上传");
        }
        map.put("data",submap);
        return map;
    }

    /**
     * 上传文件
     * @param file
     * @param response
     * @param request
     * @return
     */
    @PostMapping(value = "/uploadFile.json")
    @ResponseBody
    public Map<String, Object> uploadFile(@RequestParam MultipartFile  file, HttpServletResponse response, HttpServletRequest request) {
        Long staffId = StaffUtil.getLoginStaffId();
        String path=request.getSession().getServletContext().getRealPath("upload/file/" + staffId + "/");
        String files = FileUtil.saveFiles(file, UUID.randomUUID().toString().replaceAll("-", ""), path);
        Map<String,Object> map = new HashMap<String,Object>();
        Map<String,String> submap = new HashMap<String,String>();
        if(files.length()>0){
            map.put("code","0");
            map.put("msg", "上传成功");
            submap.put("src", request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath() + "/upload/file/" + staffId + "/" + files + "?" + new Date().getTime());
            submap.put("name", file.getOriginalFilename());
        }else{
            submap.put("src", "");
            map.put("code","1");
            map.put("msg", "上传过程中出现错误，请重新上传");
        }
        map.put("data",submap);
        return map;
    }

    /**
     * 跳转查找页
     * @return
     */
    @RequestMapping(value = "/find.json")
    @ResponseBody
    public LayerPage find(HttpServletRequest request) {
        LayerPage layerPage = new LayerPage<>(null);
        try {
            Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "");
            Integer page = null == searchParams.get("page") ? 1 : Integer.valueOf(searchParams.get("page").toString());
            Integer limit = null == searchParams.get("limit") ? 12 : Integer.valueOf(searchParams.get("limit").toString());
            String type = searchParams.get("type").toString();
            String value = searchParams.get("value").toString();
            if("friend".equals(type)) {
                layerPage = new LayerPage<Staff>(imService.getStaffByIm(value, page, limit));
            } else if("group".equals(type)) {
                layerPage = new LayerPage<ImGroup>(imService.getGroupByIm(value, page, limit));
            } else {
                layerPage.setCode(1);
                layerPage.setMsg("查询类型错误");
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            layerPage.setCode(1);
            layerPage.setMsg("请求错误");
        }
        return layerPage;
    }

    /**
     * 好友申请/入群申请
     * @param uid       接受id
     * @param group     群组id
     * @param remarks   备注
     * @return
     */
    @PostMapping(value = "/apply.json")
    @ResponseBody
    public JsonResult apply(String uid, String group, String remarks) {
        try{
            imService.apply(uid, group, remarks);
            return JsonResult.success();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return JsonResult.fail("申请失败");
        }
    }

    /**
     * 更新消息为已读
     * @return
     */
    @PostMapping(value = "/readMessage.json")
    public JsonResult readMessage() {
        try{
            imService.readMessage();
            return JsonResult.success();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return JsonResult.fail("系统错误");
        }
    }

    /**
     * 根据id获取消息列表
     * @param page
     * @return
     */
    @RequestMapping(value ="/notice/{pageNumber}")
    @ResponseBody
    public LayerPage notice(@PathVariable("page") Integer page) {
        LayerPage layerPage = new LayerPage<>(null);
        try {
            layerPage = new LayerPage(imService.getMessageByuid(page, 20));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            layerPage.setCode(1);
            layerPage.setMsg("请求错误");
        }
        return layerPage;
    }

}
