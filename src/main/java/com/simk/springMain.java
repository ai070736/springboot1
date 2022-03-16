package com.simk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class springMain {
    public static void main(String[] args) {
        SpringApplication.run(springMain.class,args);
    }
}