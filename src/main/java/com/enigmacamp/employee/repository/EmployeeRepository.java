package com.enigmacamp.employee.repository;

import com.enigmacamp.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Transactional
    @Query(value = "select * from m_employee where email = ?1", nativeQuery = true)
    Optional<Employee> getEmployeeByEmail(String email);
}
