package com.study.user.dto.controller;

import com.study.user.dto.UserRequestDto;
import com.study.user.model.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserApiController {

    private final UserService userService;

    // 회원 가입
    @PostMapping("/signup")
    public Long save(@RequestBody final UserRequestDto params) {
      return userService.save(params);
    }
}
