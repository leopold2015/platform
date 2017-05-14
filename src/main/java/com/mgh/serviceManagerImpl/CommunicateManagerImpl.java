package com.mgh.serviceManagerImpl;

import com.mgh.domain.Communicate;
import com.mgh.mapper.CommunicateMapper;
import com.mgh.serviceManager.CommunicateManager;
import com.mgh.util.currentTime.CurrentDate;
import com.mgh.util.session.SessionUtils;
import com.mgh.util.store.StoreNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by mgh on 2017/4/24.
 */
@Component
public class CommunicateManagerImpl implements CommunicateManager {

    @Autowired
    private CommunicateMapper communicateMapper;
    @Override
    public void insertCommunicate(String communicate_content) {
        Communicate communicate = new Communicate();
        communicate.setCommunicate_content(communicate_content);
        communicate.setUser_id(SessionUtils.getCurrentUser().getUser_id());
        communicate.setCommunicate_time(CurrentDate.getCurrentDate());
        communicate.setTopic_id(StoreNumber.getNumber());
        communicateMapper.insertCommunicate(communicate);
    }

    @Override
    public void deleteCommunicateByCommunicate_id(int communicate_id) {
        communicateMapper.deleteByPrimaryKey(communicate_id);
    }

    @Override
    public List<Communicate> selectCommunicateByTopic_id(int topic_id) {
        return communicateMapper.selectCommunicateByTopic_id(topic_id);
    }
}
