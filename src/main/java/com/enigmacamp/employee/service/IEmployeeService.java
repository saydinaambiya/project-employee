package com.enigmacamp.employee.service;

import com.enigmacamp.employee.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IEmployeeService {
    Employee create(Employee employee);

    Optional<Employee> get(String id);
    Employee getOne(String email);

    Page<Employee> getAll(int page, int pageSize, String direction, String sortBy);

    Employee insertLearning(Employee employee, String id);
}
