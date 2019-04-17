package com.springboot.controller.api;

import com.springboot.common.Constants;
import com.springboot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 首页
 */

@Controller
public class IndexController {

    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private AdvertService advertService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ConfigService configService;

    @RequestMapping("/")
    public String index(Model model){
        Map<String,Object> params = new HashMap();
        //栏目信息
        params.put("dic_type",Constants.dictionary_type_10);    //栏目
        params.put("dic_status",Constants.dictionary_status_10);  //可用
        model.addAttribute("menuList",this.dictionaryService.listDic(params));

        //资讯信息，最新资讯
        params.put("article_status",Constants.article_status_10);   //已发布
        model.addAttribute("articlePage",this.articleService.tabletArticle(1,6,params));

        //热门
        params.put("article_hot","不为空即可");   //热门
        model.addAttribute("hotPage",this.articleService.tabletArticle(1,6,params));

        //推荐
        params.remove("article_hot");
        params.put("article_suggest",Constants.article_suggest_20); //推荐
        model.addAttribute("suggestPage",this.articleService.tabletArticle(1,6,params));

        //banner信息
        params.put("advert_type", Constants.advert_type_10);      //banner
        params.put("advert_status", Constants.adver_status_10);      //可用
        model.addAttribute("bannerList",this.advertService.listAdvert(params));

        //友情链接
        params.put("advert_type", Constants.advert_type_20);      //banner
        model.addAttribute("linkList",this.advertService.listAdvert(params));

        //网站信息
        model.addAttribute("web_title",this.configService.getConfig("web_title").getConfig_value());
        model.addAttribute("web_key",this.configService.getConfig("web_key").getConfig_value());
        model.addAttribute("web_copyright",this.configService.getConfig("web_copyright").getConfig_value());

        return "html/index";
    }


}
