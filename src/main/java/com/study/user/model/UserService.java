package com.study.user.model;

import com.study.exception.CustomException;
import com.study.exception.ErrorCode;
import com.study.user.dto.UserRequestDto;
import com.study.user.entity.User;
import com.study.user.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long save(final UserRequestDto params) {
        Optional<User> user = userRepository.findByUsername(params.getUsername());
        if (user.isPresent()) {
           throw new CustomException(ErrorCode.DUPLICATE_RESOURCE);
        }

        String password = passwordEncoder.encode(params.getPassword());
        User entity = new User(params.getUsername(), params.getEmail(), password);

        return userRepository.save(entity).getId();
    }

}
