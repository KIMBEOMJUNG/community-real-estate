package com.kbj.callbus.api.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import com.kbj.callbus.api.common.dto.LikedDto;
import com.kbj.callbus.api.common.dto.LikedParamDto;
import com.kbj.callbus.api.common.entity.LikedEntity;
import com.kbj.callbus.api.common.service.LikedService;
import com.kbj.callbus.common.util.PageRequest;
import com.kbj.callbus.common.util.PageResponse;

@RestController
public class RestApiCommonLikedController {
    
    @Autowired
    private LikedService likedService;

    @GetMapping(path = "/liked/createLiked")
    public Integer getCreateLiked(
                HttpServletRequest request, @ModelAttribute LikedDto likedDto) {
                HttpSession session = request.getSession();
                String id = ""+session.getAttribute("id");
                int afterId = Integer.parseInt(id);
                LikedEntity likedEntity = LikedEntity.builder()
                    .boardId(likedDto.getBoardId())
                    .userId((long) afterId)
                .build();
        return likedService.createLiked(likedEntity);
    }

    @GetMapping(path = "/liked/get")
    public PageResponse<LikedEntity> getBoardList(
            @ModelAttribute LikedParamDto likedParamDto,
            @ModelAttribute PageRequest pageRequest) {
        return likedService.getBoardList(likedParamDto, pageRequest);
    }

    
}
