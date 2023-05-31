package com.mk.crud.springbootmysqlcrud.controller;

import com.mk.crud.springbootmysqlcrud.entity.Employee;
import com.mk.crud.springbootmysqlcrud.exception.BusinessException;
import com.mk.crud.springbootmysqlcrud.service.IEmployeeServiceForTransactionMgmt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class EmpControllerForTransactionMgmt {

    @Autowired
    private IEmployeeServiceForTransactionMgmt service;

    @PostMapping("/save")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        try {
            return  new ResponseEntity<>(service.addEmployee(employee), HttpStatus.OK);
        } catch (Exception e) {
            throw new BusinessException("101","Exception in EmpControllerForTransactionMgmt class");
        }
    }

}
