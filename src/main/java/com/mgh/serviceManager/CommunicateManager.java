package com.mgh.serviceManager;

import com.mgh.domain.Communicate;

import java.util.List;

/**
 * Created by mgh on 2017/4/24.
 */
public interface CommunicateManager {
    void insertCommunicate(Communicate communicate);
    void deleteCommunicateByCommunicate_id(int communicate_id);
    List<Communicate> selectCommunicateByTopic_id(int topic,int user_id);
    List<Communicate> selectCommunicateByUser_id(int topic_id,int user_id);
}
