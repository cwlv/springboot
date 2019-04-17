package com.springboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间处理 工具类
 */
public class DateUtil {

    public static final String date_format = "yyyy-mm-dd";

    /**
     * 返回字符串日期
     * @param date 日期
     * @param format 格式
     * @return
     */
    public static String getDateStr(Date date,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

}
