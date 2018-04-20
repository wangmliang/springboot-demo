package com.wml.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wangml on 2018/4/20.
 */
@Component
public class TestConfig {

    @Value("${test.id}")
    private Integer id;

    @Value("${test.age}")
    private Integer age;

    @Value("${test.address}")
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "TestConfig{" +
                "id=" + id +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
