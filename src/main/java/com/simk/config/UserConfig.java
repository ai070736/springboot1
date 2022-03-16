package com.simk.config;

import com.simk.service.UserService;
import com.simk.service.impl.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
}
