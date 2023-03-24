package com.study.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/css/**").permitAll()
                // 회원 관리 URL 전부를 login 없이 허용
                .antMatchers("/users/**").permitAll()
                .antMatchers("/api/users/**").permitAll()
                // 그 외 모든 요청은 인증과정 필요
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/users/login")
                .loginProcessingUrl("/api/users/login")
                .defaultSuccessUrl("/board/list",true)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/users/logout")
                .permitAll();
    }

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

}
