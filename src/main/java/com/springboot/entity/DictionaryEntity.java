package com.springboot.entity;

import java.io.Serializable;

/**
 * 字典管理  实体
 */
public class DictionaryEntity implements Serializable {

    private static final long serialVersionUID = -3982199848993748294L;

    private long dic_id;
    private String dic_type;
    private String type_name;
    private String dic_code;
    private String dic_name;
    private String dic_status;

    public long getDic_id() {
        return dic_id;
    }

    public void setDic_id(long dic_id) {
        this.dic_id = dic_id;
    }

    public String getDic_type() {
        return dic_type;
    }

    public void setDic_type(String dic_type) {
        this.dic_type = dic_type;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getDic_code() {
        return dic_code;
    }

    public void setDic_code(String dic_code) {
        this.dic_code = dic_code;
    }

    public String getDic_name() {
        return dic_name;
    }

    public void setDic_name(String dic_name) {
        this.dic_name = dic_name;
    }

    public String getDic_status() {
        return dic_status;
    }

    public void setDic_status(String dic_status) {
        this.dic_status = dic_status;
    }
}
