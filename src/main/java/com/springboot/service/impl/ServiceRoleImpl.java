package com.springboot.service.impl;

import com.springboot.entity.RoleEntity;
import com.springboot.mapper.RoleMapper;
import com.springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 角色管理 服务层实现
 */
@Service("roleService")
public class ServiceRoleImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public void addRole(RoleEntity entity) {

    }

    @Override
    public List<RoleEntity> listRole(Map<String,Object> params) {
        return this.roleMapper.listRole(params);
    }


    @Override
    public void updateRole(RoleEntity entity) {

    }

    @Override
    public void deleteRole(long role_id) {

    }
}
