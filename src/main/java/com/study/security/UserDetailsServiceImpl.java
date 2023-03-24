package com.study.security;

import com.study.exception.CustomException;
import com.study.exception.ErrorCode;
import com.study.user.entity.User;
import com.study.user.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new CustomException(ErrorCode.BAD_REQUEST));

        return new UserDetailsImpl(user);
    }
}
