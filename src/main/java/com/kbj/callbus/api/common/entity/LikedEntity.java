package com.kbj.callbus.api.common.entity;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class LikedEntity {

    @NotNull(groups = {ModifyValidationGroup.class })
    @Id
    private Long boardId;

    @NotNull(groups = {ModifyValidationGroup.class })
    @Id
    private Long userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdDate;

    /*****************/

    private String title;

    private String nickname;

}
