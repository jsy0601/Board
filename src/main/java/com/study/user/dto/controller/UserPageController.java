package com.study.user.dto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserPageController {

    // 회원가입
    @GetMapping("/signup")
    public String signup() {
        return "user/signup";
    }

    // 로그인
    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

//    @GetMapping("/login/error")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "user/login";
//    }
}
