package com.mk.crud.springbootmysqlcrud.service;

import com.mk.crud.springbootmysqlcrud.entity.Employee;

public interface IEmployeeServiceForTransactionMgmt {

    public Employee addEmployee(Employee employee)throws Exception;
}
