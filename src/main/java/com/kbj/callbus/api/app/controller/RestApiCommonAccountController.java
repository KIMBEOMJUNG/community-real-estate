package com.kbj.callbus.api.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.kbj.callbus.api.common.entity.MemberEntity;
import com.kbj.callbus.api.common.service.AccountService;

@RestController
public class RestApiCommonAccountController {
    
    @Autowired
    private AccountService accountService;

    @GetMapping(path = "/account/login/{nickname}")
    public MemberEntity getCreateLiked(
        HttpServletRequest request, @PathVariable(name = "nickname") String nickname) {
                MemberEntity member = accountService.getMember(nickname);
                if(member != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("id", member.getId());
                    session.setAttribute("nickname", member.getNickname());
                    session.setAttribute("accountId", member.getAccountId());
                    session.setAttribute("accountType", member.getAccountType());
                    session.setAttribute("accountTypeKor", member.getAccountTypeKor());
                }
        return member;
    }

    @GetMapping(path = "/account/checkType")
    public int getAccountType(
        @RequestHeader("Authorization") String data) {
                System.out.println("in get type data : " + data);
                String[] type = data.split("\\s+");
                if(type.length == 2) {
                    if(type[0] != null && type[0] != "") {
                        return 1;
                    }
                }
        return 0;
    }
   
}
