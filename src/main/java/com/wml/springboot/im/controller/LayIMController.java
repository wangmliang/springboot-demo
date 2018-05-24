package com.wml.springboot.im.controller;

import com.wml.springboot.im.service.ImService;
import com.wml.springboot.util.AESUtil;
import com.wml.springboot.util.JsonResult;
import com.wml.springboot.util.StaffUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
}
