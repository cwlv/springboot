package com.springboot.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.springboot.common.Constants;
import com.springboot.entity.ArticleEntity;
import com.springboot.service.AdvertService;
import com.springboot.service.ArticleService;
import com.springboot.service.ConfigService;
import com.springboot.service.DictionaryService;
import com.springboot.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller("apiArticleController")
@RequestMapping("/article")
public class ArticleController {

    private static final Logger log = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    private ArticleService articleService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private AdvertService advertService;
    @Autowired
    private ConfigService configService;

    @RequestMapping("/list/{article_type}")
    public String list(Model model,@PathVariable String article_type,
                                    @RequestParam(value="pageNum", required=false, defaultValue="1") int pageNum,
                                    @RequestParam(value="pageSize", required=false, defaultValue="10") int pageSize){
        log.info("文章信息查询------list------" + article_type);
        Map<String,Object> params = new HashMap();      //查询条件
        //栏目列表信息
        params.put("dic_type",Constants.dictionary_type_10);    //栏目
        params.put("dic_status",Constants.dictionary_status_10);  //可用
        model.addAttribute("menuList",this.dictionaryService.listDic(params));

        //文章内容
        article_type = article_type.replace(".html","");
        params.put("article_type",article_type);
        params.put("article_status", Constants.article_status_10);  //已发布
        PageInfo<ArticleEntity> pager = this.articleService.tabletArticle(pageNum,pageSize,params);
        model.addAttribute("pager",pager);
        model.addAttribute("article_type",article_type);

        //热门
        params.remove("article_type");
        params.put("article_hot","不为空即可");   //热门
        model.addAttribute("hotPage",this.articleService.tabletArticle(1,6,params));

        //推荐
        params.remove("article_hot");
        params.put("article_suggest",Constants.article_suggest_20); //推荐
        model.addAttribute("suggestPage",this.articleService.tabletArticle(1,6,params));

        //友情链接
        params.put("advert_type", Constants.advert_type_20);      //banner
        model.addAttribute("linkList",this.advertService.listAdvert(params));

        //网站信息
        model.addAttribute("web_title",this.configService.getConfig("web_title").getConfig_value());
        model.addAttribute("web_key",this.configService.getConfig("web_key").getConfig_value());
        model.addAttribute("web_copyright",this.configService.getConfig("web_copyright").getConfig_value());

        return "html/articleList";
    }


    @RequestMapping("/detail/{article_id}")
    public String detail(Model model,@PathVariable String article_id){
        log.info("文章详情：" + article_id);
        long articleId = 1;
        if(!StringUtil.isEmpty(article_id)){
            articleId = Long.valueOf(article_id.replace(".html",""));
        }
        ArticleEntity article = this.articleService.getArticle(articleId);
        model.addAttribute("article",article);

        //阅读数量+1更新操作
        article.setArticle_cnt(article.getArticle_cnt()+1);
        this.articleService.updateArticle(article);

        Map<String,Object> params = new HashMap();      //查询条件
        //栏目列表信息
        params.put("dic_type",Constants.dictionary_type_10);    //栏目
        params.put("dic_status",Constants.dictionary_status_10);  //可用
        model.addAttribute("menuList",this.dictionaryService.listDic(params));
        //热门
        params.remove("article_type");
        params.put("article_hot","不为空即可");   //热门
        model.addAttribute("hotPage",this.articleService.tabletArticle(1,6,params));

        //推荐
        params.remove("article_hot");
        params.put("article_suggest",Constants.article_suggest_20); //推荐
        model.addAttribute("suggestPage",this.articleService.tabletArticle(1,6,params));

        //友情链接
        params.put("advert_type", Constants.advert_type_20);      //banner
        model.addAttribute("linkList",this.advertService.listAdvert(params));

        //网站信息
        model.addAttribute("web_title",article.getArticle_title() + "|" + this.configService.getConfig("web_title").getConfig_value());
        model.addAttribute("web_key",article.getArticle_title() + "|" + this.configService.getConfig("web_key").getConfig_value());
        model.addAttribute("web_copyright",this.configService.getConfig("web_copyright").getConfig_value());

        return "html/article";
    }
}
