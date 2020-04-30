package com.buaa.learnforfun.entity;

public class Group {
    private Integer id;

    private String groupId;

    private String groupName;

    private Integer groupOwnerId;

    private Integer groupOwnerName;

    private String groupIntrod;

    private String courseCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public Integer getGroupOwnerId() {
        return groupOwnerId;
    }

    public void setGroupOwnerId(Integer groupOwnerId) {
        this.groupOwnerId = groupOwnerId;
    }

    public Integer getGroupOwnerName() {
        return groupOwnerName;
    }

    public void setGroupOwnerName(Integer groupOwnerName) {
        this.groupOwnerName = groupOwnerName;
    }

    public String getGroupIntrod() {
        return groupIntrod;
    }

    public void setGroupIntrod(String groupIntrod) {
        this.groupIntrod = groupIntrod == null ? null : groupIntrod.trim();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode == null ? null : courseCode.trim();
    }
}