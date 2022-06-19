package com.kbj.callbus.api.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kbj.callbus.api.common.dto.LikedParamDto;
import com.kbj.callbus.api.common.entity.LikedEntity;
import com.kbj.callbus.common.util.PageRequest;

@Repository
@Mapper
public interface LikedMapper {

    public List<LikedEntity> selectLikedList(
            @Param(value = "likedParamDto") LikedParamDto likedParamDto,
            @Param(value = "pageRequest") PageRequest pageRequest);

    public Integer selectLikedListCount(
            @Param(value = "likedParamDto") LikedParamDto likedParamDto);

    public LikedEntity selectLiked(
            @Param(value = "boardId") Long boardId, @Param(value = "userId") Long userId);

    public Integer insertLiked(
            @Param(value = "likedEntity") LikedEntity likedEntity);

    public Integer updateLiked(
            @Param(value = "likedEntity") LikedEntity likedEntity);

    public Integer deleteLiked(
        @Param(value = "boardId") Long boardId, @Param(value = "userId") Long userId);
            
}
