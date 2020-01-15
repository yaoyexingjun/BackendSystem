package com.lovo.backend.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化日期工具类
 */
@Component
public class FormatDateUtil {
    /**
     * 格式化当前日期
     * @return 日期字符串
     */
    public static String getNowDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String resultDate = simpleDateFormat.format(date);
        return resultDate;
    }
}
