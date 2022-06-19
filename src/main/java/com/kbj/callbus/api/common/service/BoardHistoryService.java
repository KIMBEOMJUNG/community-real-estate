package com.kbj.callbus.api.common.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.kbj.callbus.api.common.dto.BoardHistoryParamDto;
import com.kbj.callbus.api.common.entity.BoardHistoryEntity;
import com.kbj.callbus.api.common.mapper.BoardHistoryMapper;
import com.kbj.callbus.common.util.PageRequest;
import com.kbj.callbus.common.validation.group.ReadValidationGroup;

@Validated
@Service
public class BoardHistoryService {

    @Autowired
    private BoardHistoryMapper boardHistoryMapper;

    @Validated(value = { ReadValidationGroup.class })
    @Transactional(readOnly = true)
    public List<BoardHistoryEntity> getBoardHistoryList(
            @Valid BoardHistoryParamDto boardHistoryParamDto,
            PageRequest pageRequest) {
        List<BoardHistoryEntity> boardHistoryList = boardHistoryMapper.selectBoardHistoryList(boardHistoryParamDto, pageRequest);
        return boardHistoryList;
    }

}
