package com.springboot.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * api授权管理
 */
public class AouthEntity implements Serializable {

    private static final long serialVersionUID = -1;

    private long aouth_id;
    private String api_id;
    private String api_key;
    private Date expires_time;
    private String expires_ip1;
    private String expires_ip2;
    private String expires_ip3;
    private String expires_ip4;
    private String expires_ip5;

    public long getAouth_id() {
        return aouth_id;
    }

    public void setAouth_id(long aouth_id) {
        this.aouth_id = aouth_id;
    }

    public String getApi_id() {
        return api_id;
    }

    public void setApi_id(String api_id) {
        this.api_id = api_id;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public Date getExpires_time() {
        return expires_time;
    }

    public void setExpires_time(Date expires_time) {
        this.expires_time = expires_time;
    }

    public String getExpires_ip1() {
        return expires_ip1;
    }

    public void setExpires_ip1(String expires_ip1) {
        this.expires_ip1 = expires_ip1;
    }

    public String getExpires_ip2() {
        return expires_ip2;
    }

    public void setExpires_ip2(String expires_ip2) {
        this.expires_ip2 = expires_ip2;
    }

    public String getExpires_ip3() {
        return expires_ip3;
    }

    public void setExpires_ip3(String expires_ip3) {
        this.expires_ip3 = expires_ip3;
    }

    public String getExpires_ip4() {
        return expires_ip4;
    }

    public void setExpires_ip4(String expires_ip4) {
        this.expires_ip4 = expires_ip4;
    }

    public String getExpires_ip5() {
        return expires_ip5;
    }

    public void setExpires_ip5(String expires_ip5) {
        this.expires_ip5 = expires_ip5;
    }
}
