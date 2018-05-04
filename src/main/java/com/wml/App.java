package com.wml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;


@EnableTransactionManagement  // 开启事务
@SpringBootApplication
public class App
{
    public static void main( String[] args ) throws IOException {
        SpringApplication.run(App.class, args);
    }
}
