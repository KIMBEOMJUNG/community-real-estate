package com.kbj.callbus.api.common.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.kbj.callbus.api.common.dto.LikedParamDto;
import com.kbj.callbus.api.common.entity.LikedEntity;
import com.kbj.callbus.api.common.mapper.LikedMapper;
import com.kbj.callbus.common.util.PageRequest;
import com.kbj.callbus.common.util.PageResponse;
import com.kbj.callbus.common.validation.group.CreateValidationGroup;
import com.kbj.callbus.common.validation.group.ReadValidationGroup;

@Validated
@Service
public class LikedService {

    @Autowired
    private LikedMapper likedMapper;

    @Validated(value = { CreateValidationGroup.class })
    @Transactional
    public Integer createLiked(
            @Valid @NotNull(groups = { CreateValidationGroup.class }) LikedEntity likedEntity) {
                LikedEntity likedDoubleCheck = likedMapper.selectLiked(likedEntity.getBoardId(), likedEntity.getUserId());
                if(likedDoubleCheck != null) {
                    likedMapper.deleteLiked(likedEntity.getBoardId(), likedEntity.getUserId());
                    return 0;
                }
        return likedMapper.insertLiked(likedEntity);
    }

    @Validated(value = { ReadValidationGroup.class })
    @Transactional(readOnly = true)
    public PageResponse<LikedEntity> getBoardList(
            @Valid LikedParamDto likedParamDto,
            PageRequest pageRequest) {
        Integer likedListCount = likedMapper.selectLikedListCount(likedParamDto);
        List<LikedEntity> likedList = likedMapper.selectLikedList(likedParamDto, pageRequest);
        PageResponse<LikedEntity> pageResponse = new PageResponse<>(pageRequest, likedListCount);
        pageResponse.setItems(likedList);
        return pageResponse;
    }

}
