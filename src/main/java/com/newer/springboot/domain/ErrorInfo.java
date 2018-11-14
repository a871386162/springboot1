package com.newer.springboot.domain;


import java.io.Serializable;

public class ErrorInfo<T> implements Serializable {
    private static final long serialVersionUID = 7319618189896407200L;

    public static final int OK=0;
    public static final int ERROR=100;
    private int code;
    private String message;
    private String url;
    private T data;

    public ErrorInfo() {
    }

    public static int getOK() {
        return OK;
    }

    public static int getERROR() {
        return ERROR;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
