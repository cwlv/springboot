package com.springboot.service.impl;

import com.springboot.entity.UserEntity;
import com.springboot.mapper.UserMapper;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(UserEntity entity) {
//        UserEntity user = (UserEntity) SecurityUtils.getSubject().getPrincipal();
//        entity.setCreate_user(user.getUser_name());
        entity.setCreate_time(new Date());
        this.userMapper.addUser(entity);
    }

    @Override
    public List<UserEntity> listUser(Map<String,Object> map) {
        return this.userMapper.listUser(map);
    }

    @Override
    public UserEntity getUser(long user_id) {
        return this.userMapper.getUser(user_id);
    }

    @Override
    public UserEntity getUserByName(String user_name) {
        return this.userMapper.getUserByName(user_name);
    }

    @Override
    public void updateUser(UserEntity entity) {
        this.userMapper.updateUser(entity);
    }

    @Override
    public void deleteUser(long user_id) {
        this.userMapper.deleteUser(user_id);
    }

    @Override
    public int deleteBatchUser(List<String> ids) {
        return this.userMapper.deleteBatchUser(ids);
    }
}
