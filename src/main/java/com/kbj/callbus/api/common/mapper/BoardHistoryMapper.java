package com.kbj.callbus.api.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kbj.callbus.api.common.dto.BoardHistoryParamDto;
import com.kbj.callbus.api.common.entity.BoardHistoryEntity;
import com.kbj.callbus.common.util.PageRequest;

@Repository
@Mapper
public interface BoardHistoryMapper {

    public List<BoardHistoryEntity> selectBoardHistoryList(
            @Param(value = "boardHistoryParamDto") BoardHistoryParamDto boardHistoryParamDto,
            @Param(value = "pageRequest") PageRequest pageRequest);

    public Integer selectBoardHistoryListCount(
            @Param(value = "boardHistoryParamDto") BoardHistoryParamDto boardHistoryParamDto);

    public BoardHistoryEntity selectBoardHistory(
            @Param(value = "id") Long id);

    public Integer insertBoardHistory(
            @Param(value = "boardHistoryEntity") BoardHistoryEntity boardHistoryEntity);

    public Integer updateBoardHistory(
            @Param(value = "boardHistoryEntity") BoardHistoryEntity boardHistoryEntity);

    public Integer deleteBoardHistory(
            @Param(value = "id") Long id);
            
}
