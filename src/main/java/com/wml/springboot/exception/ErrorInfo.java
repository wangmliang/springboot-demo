package com.wml.springboot.exception;

/**
 * <pre>
 * <b>Title：</b>ErrorInfo.java<br/>
 * <b>@author：</b>WML<br/>
 * <b>@date：</b>2018/5/7 - 18:31<br/>
 * <b>@version V1.0</b></br/>
 * <b>Copyright (c) 2018 ASPire Tech.</b>
 * </pre>
 */
public class ErrorInfo {

    /**
     * 时间戳
     */
    private Long timestamp;
    /**
     * 状态码
     */
    private Integer status;

    /**
     * 错误信息
     */
    private String error;
    /**
     * 错误信息描述
     */
    private String message;
    /**
     * 访问路径
     */
    private String path;

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "timestamp=" + timestamp +
                ", status=" + status +
                ", error='" + error + '\'' +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
