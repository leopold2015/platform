package com.mgh.mapper;

import com.mgh.domain.Topic;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TopicMapper {
    int deleteByPrimaryKey(Integer topicId);

    void insertTopic(Topic record);

    int insertSelective(Topic record);

    List<Topic> selectTopicByUser_id(int user_id);

    int updateByPrimaryKeySelective(Topic record);

    int updateByPrimaryKey(Topic record);

    List<Topic> showAllTopic();
}