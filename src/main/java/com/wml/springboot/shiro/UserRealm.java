package com.wml.springboot.shiro;

import com.wml.springboot.entity.SysPermission;
import com.wml.springboot.entity.SysRole;
import com.wml.springboot.entity.User;
import com.wml.springboot.shiro.AbstractUserRealm;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 * <b>Title：</b>UserRealm.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/4/24 - 14:12<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
@Component
public class UserRealm extends AbstractUserRealm {

    @Override
    public UserRolesAndPermissions doGetGroupAuthorizationInfo(User userInfo) {
        Set<String> userRoles = new HashSet<>();
        Set<String> userPermissions = new HashSet<>();
        //TODO 获取当前用户下拥有的所有角色列表,及权限
        List<SysRole> roleList = userInfo.getRoleList();
        if(null != roleList && !roleList.isEmpty()) {
            roleList.forEach(role -> {
                userRoles.add(role.getRole());
                List<SysPermission> permissionList = role.getPermissions();
                if(null != permissionList && !permissionList.isEmpty()) {
                    permissionList.forEach(permission -> {
                        userPermissions.add(permission.getName());
                    });
                }
            });
        }
        return new UserRolesAndPermissions(userRoles, userPermissions);
    }

    @Override
    public UserRolesAndPermissions doGetRoleAuthorizationInfo(User userInfo) {
        Set<String> userRoles = new HashSet<>();
        Set<String> userPermissions = new HashSet<>();
        //TODO 获取当前用户下拥有的所有角色列表,及权限
        List<SysRole> roleList = userInfo.getRoleList();
        if(null != roleList && !roleList.isEmpty()) {
            roleList.forEach(role -> {
                userRoles.add(role.getRole());
                List<SysPermission> permissionList = role.getPermissions();
                if(null != permissionList && !permissionList.isEmpty()) {
                    permissionList.forEach(permission -> {
                        userPermissions.add(permission.getName());
                    });
                }
            });
        }
        return new UserRolesAndPermissions(userRoles, userPermissions);
    }
}
