package com.buaa.learnforfun.dto;



/**
 * Description:
 * User: chengyin
 * Date: 2018-10-22
 */

public class PageDTO {

    private Integer page = 1;

    private Integer limit = 20;

    private String field;

    private String order;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
