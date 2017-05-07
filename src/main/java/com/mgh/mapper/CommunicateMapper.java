package com.mgh.mapper;

import com.mgh.domain.Communicate;
import org.springframework.stereotype.Component;

@Component
public interface CommunicateMapper {
    void deleteByPrimaryKey(Integer communicateId);

    void insertCommunicate(Communicate record);

    int insertSelective(Communicate record);

    Communicate selectByPrimaryKey(Integer communicateId);

    int updateByPrimaryKeySelective(Communicate record);

    int updateByPrimaryKeyWithBLOBs(Communicate record);

    int updateByPrimaryKey(Communicate record);
}