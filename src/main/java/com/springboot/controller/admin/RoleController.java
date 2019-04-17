package com.springboot.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.entity.RoleEntity;
import com.springboot.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色管理  控制层
 */

@Controller
@RequestMapping("admin/role")
public class RoleController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    public String list(){
        return "admin/role/list";
    }


    @RequestMapping("/table")
    @ResponseBody
    public Map<String,Object> table(Model model, HttpServletRequest request,
                                    @RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
                                    @RequestParam(value="pageSize", required=false, defaultValue="10") int pageSize){
        log.info("角色列表----table--------");
        String role_name = request.getParameter("role_name");
        String role_type = request.getParameter("role_type");
        log.info("查询条件：role_name：，role_type：",role_name,role_type);
        Map<String,Object> params = new HashMap();  //查询条件
        params.put("role_name",role_name);
        params.put("role_type",role_type);
        PageHelper.startPage(pageNum,pageSize); //分页设置
        List<RoleEntity> list = this.roleService.listRole(params);
        PageInfo<RoleEntity> pager = new PageInfo(list);

        Map<String,Object> rstMap = new HashMap();  //返回数据
        rstMap.put("code",0);
        rstMap.put("msg","");
        rstMap.put("count",pager.getTotal());
        rstMap.put("data",pager.getList());

        return rstMap;
    }
}
