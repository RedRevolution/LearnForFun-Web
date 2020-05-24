package com.buaa.learnforfun.dto;

import org.apache.commons.collections.CollectionUtils;

import java.util.List;

public class PageResult<T> {

    //状态码，0表示成功
    private int code = 0;

    //提示信息
    private String msg = "";

    //总数量
    private long count;

    //当前数据
    private List<T> data;

    public PageResult() {
    }

    public PageResult(List<T> data) {
        this.data = data;
        if (CollectionUtils.isNotEmpty(data)) {
            this.count = data.size();
        }
    }

    public PageResult(long count, List<T> data) {
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
