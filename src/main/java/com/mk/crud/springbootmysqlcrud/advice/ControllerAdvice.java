package com.mk.crud.springbootmysqlcrud.advice;

import com.mk.crud.springbootmysqlcrud.exception.BusinessException;
import com.mk.crud.springbootmysqlcrud.exception.EmptyInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleAddEmployee(EmptyInputException e){
        return new ResponseEntity<>("Employee name is empty | please enter name", HttpStatus.BAD_REQUEST);
    }
}
