package com.springboot.service.impl;


import com.springboot.entity.PermissionEntity;
import com.springboot.entity.UserEntity;
import com.springboot.mapper.PermissionMapper;
import com.springboot.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userRoleMenuService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper userRoleMenuMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<PermissionEntity> listPermission(UserEntity user) {
        return this.userRoleMenuMapper.listPermission(user.getUser_id());
    }

    @Override
    public List<PermissionEntity> userPermission(UserEntity user) {
//        if(redisTemplate.hasKey("permissionList")){
//            return (List<PermissionEntity>)this.redisTemplate.opsForValue().get("permissionList");
//        }

        List<PermissionEntity> listPermission = this.userRoleMenuMapper.listPermission(user.getUser_id());
        for(PermissionEntity perm : listPermission){
            List<PermissionEntity> childPermission = this.userRoleMenuMapper.childPermission(perm.getMenu_id());
            perm.setChildPermission(childPermission);
        }
//        if(listPermission != null && listPermission.size() != 0){
//            this.redisTemplate.opsForValue().set("permissionList",listPermission);
//        }
        return listPermission;



    }
}
