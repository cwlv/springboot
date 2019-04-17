package com.springboot.mapper;


import com.springboot.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户管理持久层
 */
@Mapper
public interface UserMapper {

    /**
     * 添加新用户
     * @param entity
     */
    public void addUser(UserEntity entity);

    /**
     * 查询用户列表
     * @param map 查询条件
     * @return
     */
    public List<UserEntity> listUser(Map<String, Object> map);

    /**
     * 获取用户信息
     * @param user_id
     * @return
     */
    public UserEntity getUser(long user_id);

    /**
     * 获取用户信息-根据用户名
     * @param user_name 用户名
     * @return
     */
    public UserEntity getUserByName(String user_name);

    /**
     * 更新用户信息
     * @param entity
     */
    public void updateUser(UserEntity entity);

    /**
     * 删除用户信息
     * @param user_id
     */
    public void deleteUser(long user_id);

    /**
     * 批量删除用户
     * @param ids
     */
    public int deleteBatchUser(@Param("ids") List<String> ids);

}
