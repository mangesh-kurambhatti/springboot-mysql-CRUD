package com.mk.crud.springbootmysqlcrud.controller;

import com.mk.crud.springbootmysqlcrud.entity.Employee;
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
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
         return new ResponseEntity<>(iEmployeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity<>(iEmployeeService.getAllEmployee(),HttpStatus.OK);
    }
    //{} -> denotes path variable
    @GetMapping("/emp/{empid}")
    public ResponseEntity<Employee> getEmpById(@PathVariable("empid") Long id){
        return new ResponseEntity<Employee>(iEmployeeService.getEmpById(id).get(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empid}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("empid") Long empId){
        iEmployeeService.deteleEmployee(empId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee savedEployeed= iEmployeeService.addEmployee(employee);
        return new ResponseEntity<>(savedEployeed,HttpStatus.CREATED);
    }
}
