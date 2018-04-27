package com.wml.springboot.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * <b>Title：</b>DepartmentController.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/4/27 - 15:26<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
@Controller
@RequestMapping(value = "/auth")
public class DepartmentController {

    @RequestMapping(value = "/department")
    public String page() {
        return "admin/auth/department";
    }
}
