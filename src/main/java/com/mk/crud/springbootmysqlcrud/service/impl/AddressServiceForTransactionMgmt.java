package com.mk.crud.springbootmysqlcrud.service.impl;

import com.mk.crud.springbootmysqlcrud.entity.Address;
import com.mk.crud.springbootmysqlcrud.repository.AddressCrudRepo;
import com.mk.crud.springbootmysqlcrud.service.IAddressServiceForTransactionMgmt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressServiceForTransactionMgmt implements IAddressServiceForTransactionMgmt {

    @Autowired
    private AddressCrudRepo repo;

    @Override
    @Transactional //This is transaction inside transaction
    public void saveAddress(Address address) {
        repo.save(address);
    }
}
