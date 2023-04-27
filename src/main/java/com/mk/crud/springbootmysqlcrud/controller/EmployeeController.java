package com.mk.crud.springbootmysqlcrud.controller;

import com.mk.crud.springbootmysqlcrud.entity.Employee;
import com.mk.crud.springbootmysqlcrud.exceptions.BusinessException;
import com.mk.crud.springbootmysqlcrud.exceptions.ControllerException;
import com.mk.crud.springbootmysqlcrud.repository.EmployeeCrudRepo;
import com.mk.crud.springbootmysqlcrud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @PostMapping("/save")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        try {
            return new ResponseEntity<>(iEmployeeService.addEmployee(employee), HttpStatus.CREATED);
        } catch (BusinessException e) {
            ControllerException controllerException = new ControllerException(e.getCode(), e.getMsg());
            return new ResponseEntity<>(controllerException, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new ControllerException("604", "Something went wrong in addEmployee..!"), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllEmployee() {
        try {
            return new ResponseEntity<>(iEmployeeService.getAllEmployee(), HttpStatus.OK);
        } catch (BusinessException e) {
            return new ResponseEntity<>(new ControllerException(e.getCode(), e.getMsg()), HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(new ControllerException("607","Something went wrong"), HttpStatus.BAD_REQUEST);
        }

    }

    //{} -> denotes path variable
    @GetMapping("/emp/{empid}")
    public ResponseEntity<Employee> getEmpById(@PathVariable("empid") Long id) {
        return new ResponseEntity<Employee>(iEmployeeService.getEmpById(id).get(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empid}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("empid") Long empId) {
        iEmployeeService.deteleEmployee(empId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee savedEployeed = iEmployeeService.addEmployee(employee);
        return new ResponseEntity<>(savedEployeed, HttpStatus.CREATED);
    }
}
