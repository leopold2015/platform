package com.mgh.serviceManager;

import com.mgh.domain.Collection;

/**
 * Created by mgh on 2017/4/24.
 */
public interface CollectionManager {
    void insertCollection(int collection_id);
    void deleteCollection(int user_id,int communicate_id);
}
