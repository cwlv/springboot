package com.springboot.exception;


public class UserNotExistsException extends Exception{

    public UserNotExistsException(){
        super("用户不存在",null);
    }
}
