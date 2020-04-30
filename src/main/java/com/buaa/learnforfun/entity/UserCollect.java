package com.buaa.learnforfun.entity;

public class UserCollect {
    private Integer id;

    private String knowledgeShareId;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKnowledgeShareId() {
        return knowledgeShareId;
    }

    public void setKnowledgeShareId(String knowledgeShareId) {
        this.knowledgeShareId = knowledgeShareId == null ? null : knowledgeShareId.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}