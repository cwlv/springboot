package com.springboot.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * 字符串处理 工具类
 */
public class StringUtil {

    /**
     * 字符串是否空
     * @param value true 空 false 不空
     * @return
     */
    public static boolean isEmpty(String value){
        if(value == null || "".equals(value.trim())){
            return true;
        }
        return false;
    }

    /**
     * 对象是否为空
     * @param obj true 空 false 不空
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }else if (obj instanceof CharSequence) {
            return ((CharSequence) obj).length() == 0;
        }else if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }else if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }else if (obj.getClass().isArray()) {
            return Array.getLength(obj) == 0;
        }
        return false;
    }
}
