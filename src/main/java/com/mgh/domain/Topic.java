package com.mgh.domain;

import java.util.Date;

public class Topic {
    private Integer topicId;

    private String topicContent;

    private Date topicCreatetime;

    private Integer userId;

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent == null ? null : topicContent.trim();
    }

    public Date getTopicCreatetime() {
        return topicCreatetime;
    }

    public void setTopicCreatetime(Date topicCreatetime) {
        this.topicCreatetime = topicCreatetime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}