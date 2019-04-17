package com.springboot.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.springboot.common.ResultJson;
import com.springboot.entity.PermissionEntity;
import com.springboot.entity.UserEntity;
import com.springboot.service.PermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 权限管理
 */

@RestController
@RequestMapping("/admin/perm")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @PostMapping("/getPermUser")
    public ResultJson getPermUser(){
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        UserEntity user = (UserEntity) subject.getPrincipal();     //获取登录用户信息
        List<PermissionEntity> permList = this.permissionService.userPermission(user);

        Map<String,Object>  data = new HashMap();
        data.put("permList",permList);
        System.out.println(JSONObject.toJSONString(data));
        if(permList.size() == 0){      //没有权限
            return new ResultJson("权限不足，请联系管理员");
        }else{
            return new ResultJson(data);
        }

    }
}
