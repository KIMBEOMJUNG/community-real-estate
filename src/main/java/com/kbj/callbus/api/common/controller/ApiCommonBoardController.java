package com.kbj.callbus.api.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kbj.callbus.api.common.dto.BoardHistoryParamDto;
import com.kbj.callbus.api.common.entity.BoardEntity;
import com.kbj.callbus.api.common.service.BoardHistoryService;
import com.kbj.callbus.api.common.service.BoardService;
import com.kbj.callbus.common.util.PageRequest;

@Controller
public class ApiCommonBoardController {
    
    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardHistoryService boardHistoryService;
    
    @RequestMapping(path = "/board/list")
    public String getTestList() {
        return "/board/main";
    }

    @RequestMapping(path = "/board/detail")
    public String getdetail(HttpServletRequest request, Model model) {
        try {
            Long id = Long.parseLong(request.getParameter("id")); 
            BoardEntity boardDetail = boardService.getBoardDetail(id);
            model.addAttribute("item", boardDetail);
            BoardHistoryParamDto boardHistoryParamDto = new BoardHistoryParamDto();
            boardHistoryParamDto.setBoardId(id);
            PageRequest pageRequest = new PageRequest();
            pageRequest.setRowSize(99999);
            model.addAttribute("boardHistoryList", boardHistoryService.getBoardHistoryList(boardHistoryParamDto, pageRequest));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "/board/detail";
    }

    @RequestMapping(path = "/board/write")
    public String getWrite() {
        return "/board/write";
    }

    @RequestMapping(path = "/board/update")
    public String getUpdate(HttpServletRequest request, Model model) {
        try {
            Long id = Long.parseLong(request.getParameter("id")); 
            BoardEntity boardDetail = boardService.getBoardDetail(id);
            model.addAttribute("item", boardDetail);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "/board/update";
    }

    
}
