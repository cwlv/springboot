package com.springboot.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户-角色-菜单关系
 */
public class PermissionEntity extends MenuEntity implements Serializable {

    private static final long serialVersionUID = 1251353858828658826L;
    /** 用户id **/
    private long user_id;
    /** 角色id **/
    private long role_id;
    /** 角色类型 **/
    private String role_type;
    /** 子菜单 */
    private List<PermissionEntity> childPermission;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public String getRole_type() {
        return role_type;
    }

    public void setRole_type(String role_type) {
        this.role_type = role_type;
    }

    public List<PermissionEntity> getChildPermission() {
        if(this.childPermission == null){
            this.childPermission = new ArrayList();
        }
        return childPermission;
    }

    public void setChildPermission(List<PermissionEntity> childPermission) {
        this.childPermission = childPermission;
    }
}
