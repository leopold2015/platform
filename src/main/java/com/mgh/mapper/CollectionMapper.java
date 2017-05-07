package com.mgh.mapper;

import com.mgh.domain.Collection;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface CollectionMapper {
    int deleteByPrimaryKey(Integer collectionId);

    void insertCollection(Collection record);

    int insertSelective(Collection record);

    Collection selectByPrimaryKey(Integer collectionId);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);

    void deleteCollectionByUser_id(@Param("user_id") int user_id,@Param("communicate_id") int communicate_id);
}