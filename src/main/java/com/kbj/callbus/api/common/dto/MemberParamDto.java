package com.kbj.callbus.api.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberParamDto {

    private Long id;

    private String nickname;

    private String account_type;

    private Integer account_id;

    private Integer quit;

}
