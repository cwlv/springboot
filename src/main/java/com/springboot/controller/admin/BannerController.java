package com.springboot.controller.admin;

import com.github.pagehelper.PageInfo;
import com.springboot.common.Constants;
import com.springboot.entity.AdvertEntity;
import com.springboot.service.AdvertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/banner")
public class BannerController {

    private static final Logger log = LoggerFactory.getLogger(BannerController.class);
    @Autowired
    private AdvertService advertService;


    @RequestMapping("/list")
    public String list(){
        return "admin/banner/list";
    }
    @RequestMapping("/add")
    public String add(){
        log.info("打开新增页面");
        return "admin/banner/add";
    }
    @RequestMapping("/edit")
    public String edit(){
        log.info("打开编辑页面");
        return "admin/banner/edit";
    }

    @RequestMapping("table")
    @ResponseBody
    public Map<String,Object> table(HttpServletRequest request,
                                    @RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
                                    @RequestParam(value="pageSize", required=false, defaultValue="10") int pageSize){
        log.info("banner信息查询------table------");
        Map<String,Object> params = new HashMap();      //查询条件
        //params.put("article_title",article_title);
        params.put("advert_type", Constants.advert_type_10);
        PageInfo<AdvertEntity> pager = this.advertService.tabletAdvert(pageNum,pageSize,params);
        Map<String,Object> rstMap = new HashMap();  //返回数据
        rstMap.put("code",0);
        rstMap.put("msg","");
        rstMap.put("count",pager.getTotal());
        rstMap.put("data",pager.getList());
        return rstMap;
    }


    @PostMapping("/save")
    @ResponseBody
    public Map<String,Object> save(@RequestBody AdvertEntity banner){
        log.info("新增：{}",banner.toString());
        Map<String,Object> rstMap = new HashMap();  //返回数据
        try {
            this.advertService.addAdvert(banner);
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
}
