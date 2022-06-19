package com.kbj.callbus.api.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kbj.callbus.api.common.dto.BoardDto;
import com.kbj.callbus.api.common.dto.BoardParamDto;
import com.kbj.callbus.api.common.entity.BoardEntity;
import com.kbj.callbus.api.common.service.BoardService;
import com.kbj.callbus.common.util.PageRequest;
import com.kbj.callbus.common.util.PageResponse;

@RestController
public class RestApiCommonBoardController {
    
    @Autowired
    private BoardService boardService;

    @GetMapping(path = "/board/get")
    public PageResponse<BoardEntity> getBoardList(
            @ModelAttribute BoardParamDto boardParamDto,
            @ModelAttribute PageRequest pageRequest) {
        return boardService.getBoardList(boardParamDto, pageRequest);
    }

    @GetMapping(path = "/board/createBoard")
    public Integer getCreateBoard(
        HttpServletRequest request, @ModelAttribute BoardDto boardDto) {
                HttpSession session = request.getSession();
                String id = ""+session.getAttribute("id");
                int afterId = Integer.parseInt(id);
                BoardEntity boardEntity = BoardEntity.builder()
                    .title(boardDto.getTitle())
                    .context(boardDto.getContext())
                    .createdUserId(afterId)
                    .build();
        return boardService.createBoard(boardEntity);
    }

    @GetMapping(path = "/board/modifyBoard")
    public Integer modifyBoard(
            @ModelAttribute BoardDto boardDto) {
            BoardEntity boardEntity = BoardEntity.builder()
                .id(boardDto.getId())
                .title(boardDto.getTitle())
                .context(boardDto.getContext())
                .createdUserId(boardDto.getCreatedUserId())
                .build();
        return boardService.modifyBoard(boardEntity);
    }

    @DeleteMapping(path = "/board/removeBoard/{id}")
    public Integer removeBoard(
            @PathVariable(name = "id") Long id) {
        return boardService.removeBoard(id);
    }

}
