package com.mk.crud.springbootmysqlcrud.exception;

public class ControllerException extends RuntimeException{

    String id;
    String msg;

    public ControllerException() {

    }

    public ControllerException(String id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
