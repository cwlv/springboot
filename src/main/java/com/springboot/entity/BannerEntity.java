package com.springboot.entity;

import java.io.Serializable;

public class BannerEntity implements Serializable {

    private static final long serialVersionUID = -8529138446422393757L;
    private long banner_id;
    private String banner_title;
    private String banner_img;
    private String banner_url;
    private int banner_order;
    private String banner_status;

    public long getBanner_id() {
        return banner_id;
    }

    public void setBanner_id(long banner_id) {
        this.banner_id = banner_id;
    }

    public String getBanner_title() {
        return banner_title;
    }

    public void setBanner_title(String banner_title) {
        this.banner_title = banner_title;
    }

    public String getBanner_img() {
        return banner_img;
    }

    public void setBanner_img(String banner_img) {
        this.banner_img = banner_img;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }

    public int getBanner_order() {
        return banner_order;
    }

    public void setBanner_order(int banner_order) {
        this.banner_order = banner_order;
    }

    public String getBanner_status() {
        return banner_status;
    }

    public void setBanner_status(String banner_status) {
        this.banner_status = banner_status;
    }

    @Override
    public String toString() {
        return "BannerEntity{" +
                "banner_title='" + banner_title + '\'' +
                ", banner_status='" + banner_status + '\'' +
                '}';
    }
}
