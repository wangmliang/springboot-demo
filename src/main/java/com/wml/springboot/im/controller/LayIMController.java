package com.wml.springboot.im.controller;

import com.wml.springboot.im.service.ImService;
import com.wml.springboot.util.AESUtil;
import com.wml.springboot.util.FileUtil;
import com.wml.springboot.util.JsonResult;
import com.wml.springboot.util.StaffUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private ImService imService;

    /**
     * im初始化
     * @return
     */
    @GetMapping(value = "/base")
    public JsonResult getBaseData(){
        Map<String, Object> map = new HashMap<>();
        //我的信息
        return JsonResult.success(imService.imInit());
    }

    /**
     * tio 鉴权token
     * @return
     */
    @GetMapping(value = "/token")
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
    @PostMapping(value = "/uploadImg")
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
    @PostMapping(value = "/uploadFile")
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
}
