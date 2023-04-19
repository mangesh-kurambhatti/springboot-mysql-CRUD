package com.mk.crud.springbootmysqlcrud.repository;

import com.mk.crud.springbootmysqlcrud.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeCrudRepo extends JpaRepository<Employee,Long> {
}
