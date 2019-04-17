package com.springboot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.entity.ArticleEntity;
import com.springboot.mapper.ArticleMapper;
import com.springboot.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int addArticle(ArticleEntity entity) {
        return this.articleMapper.addArticle(entity);
    }

    @Override
    public PageInfo<ArticleEntity> tabletArticle(int pageNum, int pageSize, Map<String, Object> map) {
        PageHelper.startPage(pageNum,pageSize);     //分页设置
        System.out.println(JSONObject.toJSONString(map));
        List<ArticleEntity> list = this.articleMapper.listArticle(map);
        PageInfo<ArticleEntity> pager = new PageInfo(list);
        return pager;
    }

    @Override
    public ArticleEntity getArticle(long article_id) {
        return this.articleMapper.getArticle(article_id);
    }

    @Override
    public int updateArticle(ArticleEntity entity) {
        return this.articleMapper.updateArticle(entity);
    }

    @Override
    public int delArticle(long article_id) {
        return this.articleMapper.delArticle(article_id);
    }

    @Override
    public int deleteBatchArticle(List<String> ids) {
        return 0;
    }
}
