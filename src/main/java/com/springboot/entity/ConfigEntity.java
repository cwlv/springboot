package com.springboot.entity;

import java.io.Serializable;

/**
 * 参数配置 实体
 */
public class ConfigEntity implements Serializable {

    private static final long serialVersionUID = -1018953848772242836L;
    private long config_id;
    private String config_name;
    private String config_key;
    private String config_value;
    private String remark;

    public long getConfig_id() {
        return config_id;
    }

    public void setConfig_id(long config_id) {
        this.config_id = config_id;
    }

    public String getConfig_name() {
        return config_name;
    }

    public void setConfig_name(String config_name) {
        this.config_name = config_name;
    }

    public String getConfig_key() {
        return config_key;
    }

    public void setConfig_key(String config_key) {
        this.config_key = config_key;
    }

    public String getConfig_value() {
        return config_value;
    }

    public void setConfig_value(String config_value) {
        this.config_value = config_value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
