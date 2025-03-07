package com.zihenzzz.register;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.zihenzzz.**.dao")
@ComponentScan("com.zihenzzz")
public class RegisterApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegisterApplication.class,args);
    }
}
