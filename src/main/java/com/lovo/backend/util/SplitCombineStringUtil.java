package com.lovo.backend.util;

import org.springframework.stereotype.Component;

/**
 * 拆分、组合字符串工具类
 */
@Component
public class SplitCombineStringUtil {
    /**
     * 按指定规则拆分字符串
     * @param targetString 目标字符串
     * @param rule 拆分规则
     * @return 结果字符串数组
     */
    public static String[] splitString(String targetString,String rule){
        String[] resultStringArray = targetString.split(rule);
        return resultStringArray;
    }

    /**
     * 按指定规则组合字符串
     * @param targetString 目标字符串
     * @param rule 组合规则
     * @return 结果字符串
     */
    public static String combineString(String[] targetString,String rule){
        String resultString = "";
        for(int i = 0;i < targetString.length; i ++){
            if(i == targetString.length -1){
                resultString += targetString[i];
                break;
            }
            resultString += targetString[i] + rule;
        }
        return resultString;
    }
}
