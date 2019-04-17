package com.springboot.controller.admin;

import com.springboot.common.ResultJson;
import com.springboot.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/admin")
    public String login(){
        return "admin/login";
    }

    @GetMapping("/admin/index")
    public String index(){
        return "admin/index";
    }

    @GetMapping("/notLogin")
    public String notLogin() {
        return "admin/login";
    }

    @GetMapping("/notRole")
    @ResponseBody
    public ResultJson notRole() {
        return new ResultJson("您没有权限");
    }


    /**
     * 登陆
     */
    @PostMapping("/admin/login")
    @ResponseBody
    public ResultJson login(String username,String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            System.out.println("登录失败：" + e.getMessage());
            return new ResultJson(e);
        }
        return new ResultJson();
    }

}
