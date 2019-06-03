package com.cskaoyan.mymeetingcinema;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cskaoyan.mymeetingcinema.mapper")
public class MymeetingcinemaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MymeetingcinemaApplication.class, args);
    }

}
