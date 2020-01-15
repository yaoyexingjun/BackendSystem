package com.lovo.backend.util;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化日期工具类
 */
@Component
public class FormateDateUtil {

    public static String getNowDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String resultDate = simpleDateFormat.format(date);
        return resultDate;
    }
}
