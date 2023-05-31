package com.mk.crud.springbootmysqlcrud.controller;

import com.mk.crud.springbootmysqlcrud.entity.Employee;
import com.mk.crud.springbootmysqlcrud.service.IEmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(controllers = EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IEmployeeService iEmployeeService;

    private List<Employee> employeeList;
    @BeforeEach
    void setup(){
        this.employeeList = new ArrayList<>();

        this.employeeList.add(new Employee(1l,"Mangesh"));
        this.employeeList.add(new Employee(2l,"Suyash"));
        this.employeeList.add(new Employee(3l,"Shubhash"));
        this.employeeList.add(new Employee(4l,"Mahesh"));
    }

    @Test
    public void testGetAllEmployee() throws Exception {

        given(iEmployeeService.getAllEmployee()).willReturn(this.employeeList);

        this.mockMvc.perform(get("/data/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()",is(employeeList.size())));
    }

    @Test
    public void testGetEmployeeById() throws Exception {

        given(iEmployeeService.getEmpById(1l)).willReturn(Optional.ofNullable(this.employeeList.get(0)));

        this.mockMvc.perform(get("/data/emp/{empid}",1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(employeeList.get(0).getName())));
    }

























}
