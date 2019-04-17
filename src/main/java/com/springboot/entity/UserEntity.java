package com.springboot.entity;

import java.io.Serializable;
import java.util.Date;

public class UserEntity implements Serializable {

    private static final long serialVersionUID = -8732260249080956151L;

    /** 主键 **/
    private long user_id;
    /** 用户名 **/
    private String user_name;
    /** 密码 **/
    private String user_password;
    /** 用户昵称 **/
    private String user_nick;
    /** 联系方式 **/
    private String user_phone;
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
    /** 状态 **/
    private String del_flag;      //10 正常 20 停用  30 删除

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_nick() {
        return user_nick;
    }

    public void setUser_nick(String user_nick) {
        this.user_nick = user_nick;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
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
        return "UserEntity{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_nick='" + user_nick + '\'' +
                ", user_phone='" + user_phone + '\'' +
                '}';
    }
}
