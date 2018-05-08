package com.wml.springboot.exception;

/**
 * <pre>
 * <b>Title：</b>MyException.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/5/7 - 17:46<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public class MyException extends RuntimeException {

    public MyException(String message) {
        super(message);
    }

    public MyException(Throwable cause)
    {
        super(cause);
    }

}
