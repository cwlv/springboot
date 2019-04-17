package com.springboot.exception;


public class UserPasswordNotMatchException extends Exception {

    public UserPasswordNotMatchException(){
        super("用户名密码不匹配",null);
    }
}
