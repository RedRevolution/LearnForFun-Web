package com.buaa.learnforfun.entity;

public class Comment {
    private Integer id;

    private String knowledgeShareId;

    private Integer userId;

    private String userName;

    private String content;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}