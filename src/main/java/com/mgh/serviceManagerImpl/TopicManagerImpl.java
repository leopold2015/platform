package com.mgh.serviceManagerImpl;

import com.mgh.domain.Topic;
import com.mgh.mapper.TopicMapper;
import com.mgh.serviceManager.TopicManager;
import com.mgh.util.currentTime.CurrentDate;
import com.mgh.util.exception.MessageException;
import com.mgh.util.session.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by mgh on 2017/4/24.
 */
@Component
public class TopicManagerImpl implements TopicManager {
    @Autowired
    private TopicMapper topicMapper;


    @Override
    public void createTopic(String topic_content) {
        Topic topic = new Topic();
        topic.setTopic_content(topic_content);
        topic.setTopic_createtime(CurrentDate.getCurrentDate());
        int user_id = SessionUtils.getCurrentUser().getUser_id();
        topic.setUser_id(user_id);
        topicMapper.insertTopic(topic);
    }

    @Override
    public List<Topic> showTopicByUser_id(int user_id) {
        return topicMapper.selectTopicByUser_id(user_id);
    }

    @Override
    public void deleteTopicByTopic_id(int topic_id) {
        topicMapper.deleteByPrimaryKey(topic_id);
    }

    @Override
    public List<Topic> showAllTopic() {
        return topicMapper.showAllTopic();
    }
}
