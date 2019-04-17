package com.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 文章内容 实体
 */
public class ArticleEntity implements Serializable {

    private static final long serialVersionUID = 4851195744315787858L;
    private long article_id;
    private String article_title;
    private String article_text;
    private int article_type;
    private String article_desc;
    private String article_sign;
    private String article_img;
    private String article_url;
    private String article_status;
    private String article_author;
    private String article_from;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date article_time;
    private String article_suggest;
    private long article_cnt;
    private String article_hot;

    public long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(long article_id) {
        this.article_id = article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_text() {
        return article_text;
    }

    public void setArticle_text(String article_text) {
        this.article_text = article_text;
    }

    public int getArticle_type() {
        return article_type;
    }

    public void setArticle_type(int article_type) {
        this.article_type = article_type;
    }

    public String getArticle_desc() {
        return article_desc;
    }

    public void setArticle_desc(String article_desc) {
        this.article_desc = article_desc;
    }

    public String getArticle_sign() {
        return article_sign;
    }

    public void setArticle_sign(String article_sign) {
        this.article_sign = article_sign;
    }

    public String getArticle_img() {
        return article_img;
    }

    public void setArticle_img(String article_img) {
        this.article_img = article_img;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public String getArticle_status() {
        return article_status;
    }

    public void setArticle_status(String article_status) {
        this.article_status = article_status;
    }

    public String getArticle_author() {
        return article_author;
    }

    public void setArticle_author(String article_author) {
        this.article_author = article_author;
    }

    public String getArticle_from() {
        return article_from;
    }

    public void setArticle_from(String article_from) {
        this.article_from = article_from;
    }

    public Date getArticle_time() {
        return article_time;
    }

    public void setArticle_time(Date article_time) {
        this.article_time = article_time;
    }

    public String getArticle_suggest() {
        return article_suggest;
    }

    public void setArticle_suggest(String article_suggest) {
        this.article_suggest = article_suggest;
    }

    public long getArticle_cnt() {
        return article_cnt;
    }

    public void setArticle_cnt(long article_cnt) {
        this.article_cnt = article_cnt;
    }

    public String getArticle_hot() {
        return article_hot;
    }

    public void setArticle_hot(String article_hot) {
        this.article_hot = article_hot;
    }

    @Override
    public String toString() {
        return "ArticleEntity{" +
                "article_title='" + article_title + '\'' +
                ", article_type=" + article_type +
                ", article_sign='" + article_sign + '\'' +
                ", article_status='" + article_status + '\'' +
                ", article_author='" + article_author + '\'' +
                ", article_img='" + article_img + '\'' +
                ", article_text='" + article_text + '\'' +
                '}';
    }
}
