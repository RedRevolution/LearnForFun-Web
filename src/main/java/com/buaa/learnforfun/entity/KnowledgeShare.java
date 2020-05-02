package com.buaa.learnforfun.entity;

public class KnowledgeShare {
    private Long id;

    private String knowledgeShareId;

    private String groupId;

    private String userName;

    private String title;

    private String content;

    private Integer likesNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKnowledgeShareId() {
        return knowledgeShareId;
    }

    public void setKnowledgeShareId(String knowledgeShareId) {
        this.knowledgeShareId = knowledgeShareId == null ? null : knowledgeShareId.trim();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getLikesNum() {
        return likesNum;
    }

    public void setLikesNum(Integer likesNum) {
        this.likesNum = likesNum;
    }
}