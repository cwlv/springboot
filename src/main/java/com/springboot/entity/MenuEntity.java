package com.springboot.entity;

import java.io.Serializable;
import java.util.Date;

public class MenuEntity implements Serializable {

    private static final long serialVersionUID = -4705865020904954311L;
    /** 主键  **/
    private long menu_id;
    /** 菜单名称 **/
    private String menu_name;
    /** 菜单地址 **/
    private String menu_url;
    /** 父级主键 **/
    private long p_id;
    /** 菜单类型 **/
    private String menu_type;  //10 目录 20 菜单  30 按钮
    /** 权限标识 **/
    private String perms;
    /** 图标 **/
    private String icon;
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
    private String del_flag;      //10 正常 20 不可见  30 删除

    public long getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(long menu_id) {
        this.menu_id = menu_id;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }

    public long getP_id() {
        return p_id;
    }

    public void setP_id(long p_id) {
        this.p_id = p_id;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
}
