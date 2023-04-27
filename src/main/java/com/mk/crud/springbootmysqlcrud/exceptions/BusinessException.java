package com.mk.crud.springbootmysqlcrud.exceptions;

public class BusinessException extends RuntimeException {

    String code;
    String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BusinessException() {
    }

    public BusinessException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
