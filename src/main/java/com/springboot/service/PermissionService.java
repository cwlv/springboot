package com.springboot.service;


import com.springboot.entity.PermissionEntity;
import com.springboot.entity.UserEntity;

import java.util.List;

/**
 * 用户-角色-权限 服务层
 */
public interface PermissionService {

    /**
     * 查询用户的权限列表
     * @param user
     * @return
     */
    public List<PermissionEntity> listPermission(UserEntity user);

    /**
     * 用户权限列表-子菜单模式
     * @param user
     * @return
     */
    public List<PermissionEntity> userPermission(UserEntity user);

}
