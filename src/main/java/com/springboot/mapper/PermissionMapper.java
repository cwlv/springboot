package com.springboot.mapper;


import com.springboot.entity.PermissionEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户-角色-权限关系  持久层
 */
@Mapper
public interface PermissionMapper {

    /**
     * 添加用户-角色
     * @param entity
     */
    public void addUserRole(PermissionEntity entity);

    /**
     * 批量添加用户-角色
     */
    public void addUserRoleBatch(List<PermissionEntity> list);

    /**
     * 添加角色-权限
     * @param entity
     */
    public void addRoleMenu(PermissionEntity entity);

    /**
     * 批量添加角色-权限
     * @param list
     */
    public void addRoleMenuBatch(List<PermissionEntity> list);

    /**
     * 删除用户-角色
     * @param user_id
     */
    public void deleteUserRole(long user_id);

    /**
     * 删除角色-权限
     * @param role_id
     */
    public void deleteRoleMenu(long role_id);

    /**
     * 查询用户-权限列表
     * @param user_id
     * @return
     */
    public List<PermissionEntity> listPermission(long user_id);

    /**
     * 查询子菜单
     * @param menu_id 菜单ID
     * @return
     */
    public List<PermissionEntity> childPermission(long menu_id);
}
