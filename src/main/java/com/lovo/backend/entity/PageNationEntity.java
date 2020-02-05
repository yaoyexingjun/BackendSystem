package com.lovo.backend.entity;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 页面实体
 */
@Component
public class PageNationEntity<T> {
    /**
     * 总记录条数
     */
    public int totalCount;
    /**
     * 数据集合
     */
    private List<T> dataList;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
