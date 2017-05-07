package com.mgh.serviceManager;

import com.mgh.domain.Communicate;

/**
 * Created by mgh on 2017/4/24.
 */
public interface CommunicateManager {
    void insertCommunicate(Communicate communicate);
    void deleteCommunicateByCommunicate_id(int communicate_id);
}
