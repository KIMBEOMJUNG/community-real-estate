package com.kbj.callbus.api.common.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.kbj.callbus.api.common.entity.MemberEntity;
import com.kbj.callbus.api.common.mapper.MemberMapper;
import com.kbj.callbus.common.validation.group.ReadValidationGroup;

@Validated
@Service
public class AccountService {

    @Autowired
    private MemberMapper memberMapper;

    @Validated(value = { ReadValidationGroup.class })
    @Transactional(readOnly = true)
    public MemberEntity getMember(
            @Valid @NotNull(groups = { ReadValidationGroup.class }) String nickname) {
        return memberMapper.selectMember(nickname);
    }

}
