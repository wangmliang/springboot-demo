package com.wml.springboot.entity;

/**
 * <pre>
 * <b>Title：</b>SigarInfoEntity.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018-05-10 - 下午 10:27<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public class SigarInfoEntity {
    private String value;
    private String name;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public SigarInfoEntity(String value, String name) {
        super();
        this.value = value;
        this.name = name;
    }

    public SigarInfoEntity(){

    }
}
