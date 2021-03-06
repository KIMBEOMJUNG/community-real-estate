package com.kbj.callbus.api.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.kbj.callbus.api.common.dto.MemberParamDto;
import com.kbj.callbus.api.common.entity.MemberEntity;
import com.kbj.callbus.common.util.PageRequest;

@Repository
@Mapper
public interface MemberMapper {

    public List<MemberEntity> selectMemberList(
            @Param(value = "memberParamDto") MemberParamDto memberParamDto,
            @Param(value = "pageRequest") PageRequest pageRequest);

    public Integer selectMemberListCount(
            @Param(value = "memberParamDto") MemberParamDto memberParamDto);

    public MemberEntity selectMember(
            @Param(value = "nickname") String nickname);

    public Integer insertMember(
            @Param(value = "memberEntity") MemberEntity memberEntity);

    public Integer updateMember(
            @Param(value = "memberEntity") MemberEntity memberEntity);

    public Integer deleteMember(
            @Param(value = "id") Long id);
            
}
