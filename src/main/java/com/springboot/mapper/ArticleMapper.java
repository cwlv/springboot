package com.springboot.mapper;

import com.springboot.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ArticleMapper {

    /**
     * 添加 文章
     * @param entity
     * @return
     */
    public int addArticle(ArticleEntity entity);

    /**
     * 查询 文章列表
     * @param map
     * @return
     */
    public List<ArticleEntity> listArticle(Map<String, Object> map);

    /**
     * 获取文章
     * @param article_id
     * @return
     */
    public ArticleEntity getArticle(long article_id);

    /**
     * 更新文章
     * @param entity
     * @return
     */
    public int updateArticle(ArticleEntity entity);

    /**
     * 删除文章
     * @param article_id
     * @return
     */
    public int delArticle(long article_id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int deleteBatchArticle(@Param("ids") List<String> ids);
}
