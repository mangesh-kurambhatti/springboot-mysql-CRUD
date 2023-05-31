package com.mk.crud.springbootmysqlcrud.service;

import com.mk.crud.springbootmysqlcrud.entity.Address;
import com.mk.crud.springbootmysqlcrud.entity.Employee;

public interface IAddressServiceForTransactionMgmt {

    public void saveAddress(Address address);
}
