package com.springboot.controller.admin;

import com.github.pagehelper.PageInfo;
import com.springboot.common.ResultJson;
import com.springboot.entity.ArticleEntity;
import com.springboot.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller("adminArticleController")
@RequestMapping("/admin/article")
public class ArticleController {

    private static final Logger log = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    private ArticleService articleService;


    @RequestMapping("/list")
    public String list(){
        return "admin/article/list";
    }
    @RequestMapping("/add")
    public String add(){
        log.info("打开新增页面");
        return "admin/article/add";
    }
    @RequestMapping("/edit")
    public String edit(){
        log.info("打开编辑页面");
        return "admin/article/edit";
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
        PageInfo<ArticleEntity> pager = this.articleService.tabletArticle(pageNum,pageSize,params);
        Map<String,Object> rstMap = new HashMap();  //返回数据
        rstMap.put("code",0);
        rstMap.put("msg","");
        rstMap.put("count",pager.getTotal());
        rstMap.put("data",pager.getList());
        return rstMap;
    }


    @PostMapping("/save")
    @ResponseBody
    public Map<String,Object> save(@RequestBody ArticleEntity article){
        log.info("新增文章：{}",article.toString());
        Map<String,Object> rstMap = new HashMap();  //返回数据
        try {
            this.articleService.addArticle(article);
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
    public ResultJson update(@RequestBody ArticleEntity article){
        log.info("更新文章：{}",article.toString());
        try {
            this.articleService.updateArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultJson("操作失败！请关闭或刷新后重试");
        }
        return new ResultJson();
    }

}
