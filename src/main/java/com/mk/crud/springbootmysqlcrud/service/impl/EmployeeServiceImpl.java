package com.mk.crud.springbootmysqlcrud.service.impl;

import com.mk.crud.springbootmysqlcrud.entity.Employee;
import com.mk.crud.springbootmysqlcrud.exceptions.BusinessException;
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

        if (employee.getName().isEmpty() || employee.getName().length() <= 0)
            throw new BusinessException("601", "Name is blank | please provide valid name");
        try {
            return this.repo.save(employee);
        } catch (IllegalArgumentException e) {
            throw new BusinessException("602", " emp object is null");
        } catch (Exception e) {
            throw new BusinessException("603", "Something went wrong in service layer");
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList = null;
        try {
            employeeList = this.repo.findAll();
        } catch (Exception e) {
            throw new BusinessException("606", "Something went wrong in service layer");
        }
        //TODO - uncomment below line for exception generation
        //employeeList.removeAll(employeeList);
        if (employeeList.isEmpty())
            throw new BusinessException("605", "list is empty");
        return employeeList;


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
