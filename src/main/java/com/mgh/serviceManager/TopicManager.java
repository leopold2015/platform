package com.mgh.serviceManager;

import com.mgh.domain.Topic;

import java.util.List;

/**
 * Created by mgh on 2017/4/24.
 */
public interface TopicManager {
    void createTopic(String topic_content);
    List<Topic> showTopicByUser_id(int user_id);
    void deleteTopicByTopic_id(int topic_id);
    List<Topic> showAllTopic(); 
}
