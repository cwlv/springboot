package com.springboot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/home")
public class HomeController {

    @GetMapping("welcomme")
    public String welcome(){
        return "admin/welcome";
    }
}
