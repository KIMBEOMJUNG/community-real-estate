package com.kbj.callbus.api.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardParamDto {

    private Long id;

    private String title;

    private String context;

    private Integer createdUserId;

}
