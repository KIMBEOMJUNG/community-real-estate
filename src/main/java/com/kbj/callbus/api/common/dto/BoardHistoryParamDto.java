package com.kbj.callbus.api.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardHistoryParamDto {

    private Long id;

    private Long boardId;

    private String detail;

    private Long type;

    private Integer createdUserId;

}
