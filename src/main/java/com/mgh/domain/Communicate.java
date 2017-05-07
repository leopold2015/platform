package com.mgh.domain;

import java.util.Date;

public class Communicate {
    private Integer communicateId;

    private Date communicateTime;

    private Integer userId;

    private Integer topicId;

    private String communicateContent;

    public Integer getCommunicateId() {
        return communicateId;
    }

    public void setCommunicateId(Integer communicateId) {
        this.communicateId = communicateId;
    }

    public Date getCommunicateTime() {
        return communicateTime;
    }

    public void setCommunicateTime(Date communicateTime) {
        this.communicateTime = communicateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getCommunicateContent() {
        return communicateContent;
    }

    public void setCommunicateContent(String communicateContent) {
        this.communicateContent = communicateContent == null ? null : communicateContent.trim();
    }
}