package com.kbj.callbus.api.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kbj.callbus.api.common.dto.BoardParamDto;
import com.kbj.callbus.api.common.entity.BoardEntity;
import com.kbj.callbus.common.util.PageRequest;

@Repository
@Mapper
public interface BoardMapper {

    public List<BoardEntity> selectBoardList(
            @Param(value = "boardParamDto") BoardParamDto boardParamDto,
            @Param(value = "pageRequest") PageRequest pageRequest);

    public Integer selectBoardListCount(
            @Param(value = "boardParamDto") BoardParamDto boardParamDto);

    public BoardEntity selectBoard(
            @Param(value = "id") Long id);

    public Integer insertBoard(
            @Param(value = "boardEntity") BoardEntity boardEntity);

    public Integer updateBoard(
            @Param(value = "boardEntity") BoardEntity boardEntity);

    public Integer deleteBoard(
            @Param(value = "id") Long id);
            
}
