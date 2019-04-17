package com.springboot.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.springboot.entity.UserEntity;
import com.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理 控制层
 */
@Controller
@RequestMapping("/admin/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    @RequestMapping("/list")
    public String list(){
        log.info("用户信息查询");
        return "admin/user/list";
    }

    @RequestMapping("/add")
    public String add(){
        log.info("打开新增页面");
        return "admin/user/add";
    }

    @RequestMapping("/edit")
    public String edit(){
        log.info("打开编辑页面");
        return "admin/user/edit";
    }

    /**
     *
     * @param model
     * @param request
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/table")
    @ResponseBody
    public Map<String,Object> table(Model model, HttpServletRequest request,
                                    @RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
                                    @RequestParam(value="pageSize", required=false, defaultValue="10") int pageSize){
        log.info("用户信息查询------table------");
        String user_name = request.getParameter("user_name");
        log.info("查询条件：user_name：",user_name);
        Map<String,Object> params = new HashMap();
        params.put("user_name",user_name);
        PageHelper.startPage(pageNum,pageSize); //分页设置
        List<UserEntity> list = this.userService.listUser(params);  //用户数据列表
        PageInfo<UserEntity> pager = new PageInfo(list);
        Map<String,Object> rstMap = new HashMap();  //返回数据
        rstMap.put("code",0);
        rstMap.put("msg","");
        rstMap.put("count",pager.getTotal());
        rstMap.put("data",pager.getList());
        return rstMap;
    }

    @PostMapping("/save")
    @ResponseBody
    public Map<String,Object> save(@RequestBody UserEntity user){
        log.info("新增信息：{}",user.toString());
        Map<String,Object> rstMap = new HashMap();  //返回数据
        try {
            this.userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            rstMap.put("code","300");
            rstMap.put("msg","操作失败！请关闭或刷新后重试");
            return rstMap;
        }
        rstMap.put("code","200");
        rstMap.put("msg","操作成功");
        return rstMap;
    }


    @PostMapping("/update")
    @ResponseBody
    public Map<String,Object> update(@RequestBody UserEntity user){
        log.info("更新信息：{}",user.toString());
        Map<String,Object> rstMap = new HashMap();  //返回数据
        try {
            this.userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            rstMap.put("code","300");
            rstMap.put("msg","操作失败！请关闭或刷新后重试");
            return rstMap;
        }
        rstMap.put("code","200");
        rstMap.put("msg","操作成功");
        return rstMap;
    }



    /**
     * 删除信息
     * @param user_id
     * @return
     */
    @RequestMapping("/del")
    @ResponseBody
    public Map<String,Object> del(long user_id){
        log.info("删除数据ID：{}",user_id);
        Map<String,Object> rstMap = new HashMap();  //返回数据
        try {
            this.userService.deleteUser(user_id);
        } catch (Exception e) {
            e.printStackTrace();
            rstMap.put("code","300");
            return rstMap;
        }
        rstMap.put("code","200");
        return rstMap;
    }

    /**
     * 批量删除
     * @param idStr
     * @return
     */
    @RequestMapping("/batchDel")
    @ResponseBody
    public Map<String,Object> batchDel(String idStr){
        Map<String,Object> rstMap = new HashMap();  //返回数据
        log.info("删除数据：{}",idStr);
        String[] ids = idStr.split(",");
        List<String> idList = new ArrayList();
        for(String id : ids){
            if(!StringUtil.isEmpty(id)){
                idList.add(id);
            }
        }
        try {
            System.out.println(this.userService.deleteBatchUser(idList));
        } catch (Exception e) {
            e.printStackTrace();
            rstMap.put("code","300");
            return rstMap;
        }
        rstMap.put("code","200");
        rstMap.put("msg","删除成功");
        return rstMap;
    }

}
