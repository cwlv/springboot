package com.springboot.service;


import com.springboot.entity.UserEntity;

/**
 * 登录 服务层
 */
public interface LoginService {

    /**
     * 用户登录
     * @param user_name
     * @param password
     * @return
     */
    public UserEntity login(String user_name, String password) throws Exception;
}
