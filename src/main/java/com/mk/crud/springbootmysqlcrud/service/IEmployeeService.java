package com.mk.crud.springbootmysqlcrud.service;

import com.mk.crud.springbootmysqlcrud.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Employee addEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Optional<Employee> getEmpById(Long id);

    void deteleEmployee(Long empId);

}
