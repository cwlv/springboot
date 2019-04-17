package com.springboot.service.impl;

import com.springboot.entity.UserEntity;
import com.springboot.exception.UserNotExistsException;
import com.springboot.exception.UserPasswordNotMatchException;
import com.springboot.mapper.UserMapper;
import com.springboot.service.LoginService;
import com.springboot.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity login(String user_name, String password) throws Exception{
        UserEntity user = this.userMapper.getUserByName(user_name);
        if(StringUtil.isEmpty(user)){
            log.info("用户名不存在：{}",user_name);
           throw new UserNotExistsException();
        }else if(!DigestUtils.md5DigestAsHex((user_name+password).getBytes()).equals(user.getUser_password())){
            log.info("用户名：{}和密码：{}不匹配",user_name,password);
            throw new UserPasswordNotMatchException();
        }
        return user;
    }

}
