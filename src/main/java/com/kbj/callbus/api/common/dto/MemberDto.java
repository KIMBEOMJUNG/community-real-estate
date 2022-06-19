package com.kbj.callbus.api.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    private Long id;

    private String nickname;

    private String account_type;

    private Integer account_id;

    private Integer quit;

}
