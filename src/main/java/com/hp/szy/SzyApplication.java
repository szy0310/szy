package com.hp.szy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hp.szy.Mapper")
public class SzyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SzyApplication.class, args);
    }

}
