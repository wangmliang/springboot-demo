package com.wml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;


@EnableTransactionManagement  // 开启事务
@SpringBootApplication
@ServletComponentScan // 开启Filter
public class App
{
    public static void main( String[] args ) throws IOException {
        // SpringApplication.run(App.class, args);

        SpringApplication app = new SpringApplication(App.class);
        Environment environment = app.run(args).getEnvironment();
    }
}
