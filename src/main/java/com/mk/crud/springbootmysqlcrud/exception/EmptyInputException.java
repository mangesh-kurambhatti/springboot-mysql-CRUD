package com.mk.crud.springbootmysqlcrud.exception;

public class EmptyInputException extends RuntimeException{

    String id;
    String msg;

    public EmptyInputException() {

    }

    public EmptyInputException(String id, String msg) {
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
