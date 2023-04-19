package com.mk.crud.springbootmysqlcrud.service.impl;

import com.mk.crud.springbootmysqlcrud.entity.Employee;
import com.mk.crud.springbootmysqlcrud.repository.EmployeeCrudRepo;
import com.mk.crud.springbootmysqlcrud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeCrudRepo repo;

    @Override
    public Employee addEmployee(Employee employee) {
        return this.repo.save(employee);

    }

    @Override
    public List<Employee> getAllEmployee() {
        return this.repo.findAll();
    }

    @Override
    public Optional<Employee> getEmpById(Long id) {
        return this.repo.findById(id);
    }

    @Override
    public void deteleEmployee(Long empId) {
        this.repo.deleteById(empId);
    }
}
