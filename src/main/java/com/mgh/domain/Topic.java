package com.mgh.domain;

import java.util.Date;

public class Topic {
    private Integer topic_id;

    private String topic_content;

    private Date topic_createtime;

    private Integer user_id;

    private User user;

    public Integer getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Integer topic_id) {
        this.topic_id = topic_id;
    }

    public String getTopic_content() {
        return topic_content;
    }

    public void setTopic_content(String topic_content) {
        this.topic_content = topic_content;
    }

    public Date getTopic_createtime() {
        return topic_createtime;
    }

    public void setTopic_createtime(Date topic_createtime) {
        this.topic_createtime = topic_createtime;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}