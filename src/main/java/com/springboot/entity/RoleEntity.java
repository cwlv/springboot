package com.springboot.entity;

import java.io.Serializable;
import java.util.Date;

public class RoleEntity implements Serializable {

    private static final long serialVersionUID = 3507835657573212056L;
    /** 主键ID **/
    private long role_id;
    /** 角色类型 **/
    private String role_type;
    /** 角色名称 **/
    private String role_name;
    /** 创建者 **/
    private String create_user;
    /** 创建时间 **/
    private Date create_time;
    /** 更新者 **/
    private String update_user;
    /** 更新时间 **/
    private Date update_time;
    /** 删除者 **/
    private String del_user;
    /** 删除时间 **/
    private Date del_time;
    /** 角色状态 **/
    private String del_flag;      //10 正常 20 停用  30 删除

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

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getCreate_user() {
        return create_user;
    }

    public void setCreate_user(String create_user) {
        this.create_user = create_user;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_user() {
        return update_user;
    }

    public void setUpdate_user(String update_user) {
        this.update_user = update_user;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getDel_user() {
        return del_user;
    }

    public void setDel_user(String del_user) {
        this.del_user = del_user;
    }

    public Date getDel_time() {
        return del_time;
    }

    public void setDel_time(Date del_time) {
        this.del_time = del_time;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "role_type='" + role_type + '\'' +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
