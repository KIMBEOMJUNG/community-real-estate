package com.kbj.callbus.api.common.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.kbj.callbus.common.validation.group.ModifyValidationGroup;

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
public class MemberEntity {

    @NotNull(groups = {ModifyValidationGroup.class })
    @Id
    private Long id;

    private String nickname;

    private String accountType;

    private String accountTypeKor;

    private Integer accountId;

    private Integer quit;

}
