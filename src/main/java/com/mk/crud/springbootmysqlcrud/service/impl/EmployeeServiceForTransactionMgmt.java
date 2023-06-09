package com.mk.crud.springbootmysqlcrud.service.impl;

import com.mk.crud.springbootmysqlcrud.entity.Address;
import com.mk.crud.springbootmysqlcrud.entity.Employee;
import com.mk.crud.springbootmysqlcrud.repository.AddressCrudRepo;
import com.mk.crud.springbootmysqlcrud.repository.EmployeeCrudRepo;
import com.mk.crud.springbootmysqlcrud.service.IAddressServiceForTransactionMgmt;
import com.mk.crud.springbootmysqlcrud.service.IEmployeeServiceForTransactionMgmt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeServiceForTransactionMgmt implements IEmployeeServiceForTransactionMgmt {

    @Autowired
    private EmployeeCrudRepo employeeCrudRepo;

    @Autowired
    private IAddressServiceForTransactionMgmt transactionMgmt;
//
//    @Autowired
//    private IEmployeeServiceForTransactionMgmt employeeServiceForTransactionMgmt;
//

    /*Here before we put @Transactional - if we try to save employee object with name as code then it will get saved in emp db.
    * but after that its getting error bcx of code name ideally data should not be persisited
    * After putting @Transactional it will automatically get rollback spring does that internally
    * it makes sure that until an unless transactional block is successfully completed it will not commit the changes */
    @Transactional
    @Override
    public Employee addEmployee(Employee employee) throws Exception {

        Employee savedEmployee= employeeCrudRepo.save(employee);

        if(savedEmployee.getName().equals("code"))
            throw new Exception();

        Address address= new Address();
        address.setId(3l);
        address.setName("Mumbai");
        address.setEmp(savedEmployee);

        transactionMgmt.saveAddress(address);

        return savedEmployee;
    }
}
