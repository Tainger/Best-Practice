package com.redission.model;


/**
 * 返回额外信息
 *
 * @author yli11
 * @date 2020-12-24 05:50:09
 */
public class ExtraInfo {


    public ExtraInfo() {

    }

    /**
     * 总条数
     */
    private long totalCount = 0;

    public long getTotalCount() {
        return totalCount;
    }

    public ExtraInfo setTotalCount(long totalCount) {
        this.totalCount = totalCount;
        return this;
    }


}
