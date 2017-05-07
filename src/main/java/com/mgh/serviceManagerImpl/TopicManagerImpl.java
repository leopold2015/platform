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
    public void createTopic(Topic topic) {
        if(topic.getTopicContent() ==null){
            throw new MessageException("话题的内容不能为空！");
        }else {
            topic.setUserId(SessionUtils.getCurrentUser().getUserId());
            topic.setTopicCreatetime(CurrentDate.getCurrentDate());
            topicMapper.insertTopic(topic);
        }
    }

    @Override
    public List<Topic> showTopicByUser_id(int user_id) {
        return topicMapper.selectTopicByUser_id(user_id);
    }

    @Override
    public void deleteTopicByTopic_id(int topic_id) {
        topicMapper.deleteByPrimaryKey(topic_id);
    }
}
