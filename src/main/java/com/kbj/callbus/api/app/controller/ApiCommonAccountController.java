package com.kbj.callbus.api.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kbj.callbus.api.common.service.BoardService;

@Controller
public class ApiCommonAccountController {
    
    @Autowired
    private BoardService boardService;

    @RequestMapping(path = "/login")
    public String getLogin() {
        return "/account/login";
    }

    @RequestMapping(path = "/logout")
    public String getLogout(
        HttpServletRequest request) {
            HttpSession session = request.getSession();
            session.invalidate();
        return "/account/login";
    }
    
}
