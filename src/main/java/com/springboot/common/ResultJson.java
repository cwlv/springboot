package com.springboot.common;

import java.io.Serializable;

public class ResultJson<T> implements Serializable {

    private static final long serialVersionUID = -6647026117241322862L;

    private static final String SUCCESS = "200";
    private static final String FAIL = "300";
    private static final String SUCCESS_MSG = "操作成功";
    //private static final String FAIL_MSG = "操作失败";

    public String code;
    public String msg;
    public T data;

    /**
     * 操作成功
     */
    public ResultJson(){
        this.code = SUCCESS;
        this.msg = SUCCESS_MSG;
    }

    /**
     * 操作成功
     * @param data
     */
    public ResultJson(T data){
        this.code = SUCCESS;
        this.msg = SUCCESS_MSG;
        this.data = data;
    }

    /**
     * 操作失败
     * @param error
     */
    public ResultJson(String error){
        this.code = FAIL;
        this.msg = error;
    }

    /**
     * 失败信息
     * @param e
     */
    public ResultJson(Throwable e){
        this.code = FAIL;
        this.msg = e.getMessage();
    }



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
