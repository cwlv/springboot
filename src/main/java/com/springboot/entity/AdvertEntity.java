package com.springboot.entity;

import java.io.Serializable;

/**
 * 广告类 实体
 * 10 banner 20 友情链接 30广告
 */
public class AdvertEntity implements Serializable {

    private static final long serialVersionUID = 2716755294395047538L;
    private long advert_id;
    private String advert_type;
    private String advert_name;
    private String advert_img;
    private String advert_url;
    private String advert_status;
    private String advert_order;

    public long getAdvert_id() {
        return advert_id;
    }

    public void setAdvert_id(long advert_id) {
        this.advert_id = advert_id;
    }

    public String getAdvert_type() {
        return advert_type;
    }

    public void setAdvert_type(String advert_type) {
        this.advert_type = advert_type;
    }

    public String getAdvert_name() {
        return advert_name;
    }

    public void setAdvert_name(String advert_name) {
        this.advert_name = advert_name;
    }

    public String getAdvert_img() {
        return advert_img;
    }

    public void setAdvert_img(String advert_img) {
        this.advert_img = advert_img;
    }

    public String getAdvert_url() {
        return advert_url;
    }

    public void setAdvert_url(String advert_url) {
        this.advert_url = advert_url;
    }

    public String getAdvert_status() {
        return advert_status;
    }

    public void setAdvert_status(String advert_status) {
        this.advert_status = advert_status;
    }

    public String getAdvert_order() {
        return advert_order;
    }

    public void setAdvert_order(String advert_order) {
        this.advert_order = advert_order;
    }
}
