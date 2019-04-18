package com.springboot.util;

import org.springframework.util.DigestUtils;

/**
 * MD5加密
 */
public class MD5Util {

    /**
     * 字符串加密
     * @param str
     * @return
     */
    public String encrypt(String str){
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }

    /**
     * 字节数组加密
     * @param str
     * @return
     */
    public String encrypt(byte[] str){
        return DigestUtils.md5DigestAsHex(str);
    }
}
