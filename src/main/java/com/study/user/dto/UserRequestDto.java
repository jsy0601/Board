package com.study.user.dto;

import com.study.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequestDto {

    private String email;
    private String username;
    private String password;

    public User toEntity() {
        return User.builder()
                .email(email)
                .username(username)
                .password(password)
                .build();
    }
}
