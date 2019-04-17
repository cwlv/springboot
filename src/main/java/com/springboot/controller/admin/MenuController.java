package com.springboot.controller.admin;

import com.springboot.entity.MenuEntity;
import com.springboot.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/menu")
public class MenuController {

    private static final Logger log = LoggerFactory.getLogger(MenuController.class);
    @Autowired
    private MenuService menuService;

    @GetMapping("list")
    public String list(){
        return "admin/menu/list";
    }


    @GetMapping("treeTable")
    @ResponseBody
    public Map<String,Object> treeTable(){
        log.info("权限信息查询------table------");
        Map<String,Object> params = new HashMap();
        List<MenuEntity> list = this.menuService.listMenu(params);

        Map<String,Object> rstMap = new HashMap();  //返回数据
        rstMap.put("code",0);
        rstMap.put("msg","");
        rstMap.put("count",list.size());
        rstMap.put("data",list);
        return rstMap;
    }
}
