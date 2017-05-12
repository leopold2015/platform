package com.mgh.mapper;

import com.mgh.domain.Communicate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommunicateMapper {
    void deleteByPrimaryKey(Integer communicateId);

    void insertCommunicate(Communicate record);

    int insertSelective(Communicate record);

    Communicate selectByPrimaryKey(Integer communicateId);

    int updateByPrimaryKeySelective(Communicate record);

    int updateByPrimaryKeyWithBLOBs(Communicate record);

    int updateByPrimaryKey(Communicate record);

    List<Communicate> selectCommunicateByTopic_id(@Param("topic_id") int topic_id,@Param("user_id") int user_id);

    List<Communicate> selectCommunicateByUser_id(@Param("topic_id") int topic_id,@Param("user_id") int user_id);
}