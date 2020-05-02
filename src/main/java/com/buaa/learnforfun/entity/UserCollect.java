package com.buaa.learnforfun.entity;

public class UserCollect {
    private Long id;

    private String userId;

    private String knowledgeShareId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getKnowledgeShareId() {
        return knowledgeShareId;
    }

    public void setKnowledgeShareId(String knowledgeShareId) {
        this.knowledgeShareId = knowledgeShareId == null ? null : knowledgeShareId.trim();
    }
}