package com.mgh.serviceManagerImpl;

import com.mgh.domain.Collection;
import com.mgh.mapper.CollectionMapper;
import com.mgh.serviceManager.CollectionManager;
import com.mgh.util.session.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mgh on 2017/4/24.
 */
@Component
public class CollectionManagerImpl implements CollectionManager {

    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public void insertCollection(int collection_id) {
        Collection collection = new Collection();
        collection.setCommunicateId(collection_id);
        collection.setUserId(SessionUtils.getCurrentUser().getUserId());
        collectionMapper.insertCollection(collection);
    }

    @Override
    public void deleteCollection(int user_id,int communicate_id) {
        collectionMapper.deleteCollectionByUser_id(user_id,communicate_id);
    }
}
