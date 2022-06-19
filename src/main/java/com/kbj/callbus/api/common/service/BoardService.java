package com.kbj.callbus.api.common.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.kbj.callbus.api.common.dto.BoardParamDto;
import com.kbj.callbus.api.common.entity.BoardEntity;
import com.kbj.callbus.api.common.entity.BoardHistoryEntity;
import com.kbj.callbus.api.common.mapper.BoardHistoryMapper;
import com.kbj.callbus.api.common.mapper.BoardMapper;
import com.kbj.callbus.common.util.PageRequest;
import com.kbj.callbus.common.util.PageResponse;
import com.kbj.callbus.common.validation.group.CreateValidationGroup;
import com.kbj.callbus.common.validation.group.ModifyValidationGroup;
import com.kbj.callbus.common.validation.group.ReadValidationGroup;
import com.kbj.callbus.common.validation.group.RemoveValidationGroup;

@Validated
@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Autowired
    private BoardHistoryMapper boardHistoryMapper;
    
    @Validated(value = { ReadValidationGroup.class })
    @Transactional(readOnly = true)
    public PageResponse<BoardEntity> getBoardList(
            @Valid BoardParamDto boardParamDto,
            PageRequest pageRequest) {
        Integer boardListCount = boardMapper.selectBoardListCount(boardParamDto);
        List<BoardEntity> boardList = boardMapper.selectBoardList(boardParamDto, pageRequest);
        PageResponse<BoardEntity> pageResponse = new PageResponse<>(pageRequest, boardListCount);
        pageResponse.setItems(boardList);
        return pageResponse;
    }

    @Validated(value = { ReadValidationGroup.class })
    @Transactional(readOnly = true)
    public BoardEntity getBoardDetail(
            @Valid @NotNull(groups = { ReadValidationGroup.class }) Long index) {
        return boardMapper.selectBoard(index);
    }

    @Validated(value = { CreateValidationGroup.class })
    @Transactional
    public Integer createBoard(
            @Valid @NotNull(groups = { CreateValidationGroup.class }) BoardEntity boardEntity) {
                Integer result = boardMapper.insertBoard(boardEntity);
                BoardHistoryEntity boardHistoryEntity = BoardHistoryEntity.builder()
                .boardId(boardEntity.getId())
                .detail("글 작성"+"title :"+boardEntity.getTitle()+" context :"+boardEntity.getContext()+" userId :"+boardEntity.getCreatedUserId())
                .type((long) 1)
                .build();
                boardHistoryMapper.insertBoardHistory(boardHistoryEntity);
        return result;
    }

    @Validated(value = { ModifyValidationGroup.class })
    @Transactional
    public Integer modifyBoard(
            @Valid @NotNull(groups = { ModifyValidationGroup.class }) BoardEntity boardEntity) {
                Integer result = boardMapper.updateBoard(boardEntity);
                BoardHistoryEntity boardHistoryEntity = BoardHistoryEntity.builder()
                .boardId(boardEntity.getId())
                .detail("글 수정"+"title :"+boardEntity.getTitle()+" context :"+boardEntity.getContext()+" userId :"+boardEntity.getCreatedUserId())
                .type((long) 2)
                .build();
                boardHistoryMapper.insertBoardHistory(boardHistoryEntity);
        return result;
    }

    @Validated(value = { RemoveValidationGroup.class })
    @Transactional
    public Integer removeBoard(
            @Valid @NotNull(groups = { RemoveValidationGroup.class }) Long id) {
                Integer result = boardMapper.deleteBoard(id);
                BoardHistoryEntity boardHistoryEntity = BoardHistoryEntity.builder()
                .boardId(id)
                .detail("글 삭제")
                .type((long) 3)
                .build();
                boardHistoryMapper.insertBoardHistory(boardHistoryEntity);
        return result;
    }

}
