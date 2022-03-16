package com.simk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
//测试commit1
//在hotfix分支修改

//hotfix 冲突测试
@EnableCaching
@SpringBootApplication
public class springMain {
    public static void main(String[] args) {
        SpringApplication.run(springMain.class,args);
    }
}
