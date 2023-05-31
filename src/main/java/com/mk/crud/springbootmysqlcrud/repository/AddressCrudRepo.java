package com.mk.crud.springbootmysqlcrud.repository;

import com.mk.crud.springbootmysqlcrud.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressCrudRepo extends JpaRepository<Address,Long> {
}
