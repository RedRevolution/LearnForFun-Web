package com.buaa.learnforfun.dto;


/**
 * 用户个人信息类
 */
public class UserDto {
    //tbl_user_info
    private Integer id; //主键
    private String wechatAccountId;
    private Integer userId; //学号或工号
    private String userName;

    //tbl_user_collect
    private String knowledgeShareId; //用户收藏的知识分享ID

    //tbl_user_group
    private String groupId;
    private Boolean isAdministrator;

    //tbl_select_course
    private String courseCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWechatAccountId() {
        return wechatAccountId;
    }

    public void setWechatAccountId(String wechatAccountId) {
        this.wechatAccountId = wechatAccountId;
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
        this.userName = userName;
    }

    public String getKnowledgeShareId() {
        return knowledgeShareId;
    }

    public void setKnowledgeShareId(String knowledgeShareId) {
        this.knowledgeShareId = knowledgeShareId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Boolean getAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(Boolean administrator) {
        isAdministrator = administrator;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
