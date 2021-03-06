package com.springboot.controller.admin;

import com.github.pagehelper.PageInfo;
import com.springboot.common.ResultJson;
import com.springboot.entity.DictionaryEntity;
import com.springboot.service.DictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/dic")
public class DictionaryController {

    private static final Logger log = LoggerFactory.getLogger(DictionaryController.class);
    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping("/list")
    public String list(){
        return "admin/dic/list";
    }
    @RequestMapping("/add")
    public String add(){
        log.info("打开新增页面");
        return "admin/dic/add";
    }
    @RequestMapping("/edit")
    public String edit(){
        log.info("打开编辑页面");
        return "admin/dic/edit";
    }

    @RequestMapping("table")
    @ResponseBody
    public Map<String,Object> table(HttpServletRequest request,
                                    @RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
                                    @RequestParam(value="pageSize", required=false, defaultValue="10") int pageSize){
        log.info("文章信息查询------table------");
        String article_title = request.getParameter("article_title");
        log.info("查询条件：user_name：",article_title);
        Map<String,Object> params = new HashMap();      //查询条件
        params.put("article_title",article_title);
        PageInfo<DictionaryEntity> pager = this.dictionaryService.tabletDic(pageNum,pageSize,params);

        Map<String,Object> rstMap = new HashMap();  //返回数据
        rstMap.put("code",0);
        rstMap.put("msg","");
        rstMap.put("count",pager.getTotal());
        rstMap.put("data",pager.getList());
        return rstMap;
    }

    @PostMapping("list")
    @ResponseBody
    public ResultJson list(String dic_type){
        Map<String,Object> params = new HashMap();      //查询条件
        params.put("dic_type",dic_type);
        List<DictionaryEntity> list = this.dictionaryService.listDic(params);
        return new ResultJson(list);
    }


    @PostMapping("/save")
    @ResponseBody
    public Map<String,Object> save(@RequestBody DictionaryEntity dic){
        log.info("新增文章：{}",dic.toString());
        Map<String,Object> rstMap = new HashMap();  //返回数据
        try {
            this.dictionaryService.addDic(dic);
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
