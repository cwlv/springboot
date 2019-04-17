package com.springboot.service;


import com.springboot.entity.RoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色管理  服务层接口
 */
public interface RoleService {

    /**
     * 添加角色
     * @param entity
     */
    public void addRole(RoleEntity entity);

    /**
     * 查询角色列表 分页
     * @param entity 查询条件
     * @return
     */
    public List<RoleEntity> listRole(Map<String, Object> params);


    /**
     * 更新角色信息
     * @param entity
     */
    public void updateRole(RoleEntity entity);

    /**
     * 删除角色信息
     * @param role_id
     */
    public void deleteRole(long role_id);

}
