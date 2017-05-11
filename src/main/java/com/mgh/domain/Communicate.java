package com.mgh.domain;

import java.util.Date;

public class Communicate {
    private Integer communicate_id;

    private Date communicate_time;

    private Integer user_id;

    private Integer topic_id;

    private String communicate_content;

    public Integer getCommunicate_id() {
        return communicate_id;
    }

    public void setCommunicate_id(Integer communicate_id) {
        this.communicate_id = communicate_id;
    }

    public Date getCommunicate_time() {
        return communicate_time;
    }

    public void setCommunicate_time(Date communicate_time) {
        this.communicate_time = communicate_time;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Integer topic_id) {
        this.topic_id = topic_id;
    }

    public String getCommunicate_content() {
        return communicate_content;
    }

    public void setCommunicate_content(String communicate_content) {
        this.communicate_content = communicate_content;
    }
}