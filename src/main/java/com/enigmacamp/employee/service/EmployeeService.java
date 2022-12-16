package com.enigmacamp.employee.service;

import com.enigmacamp.employee.exception.EntityExistException;
import com.enigmacamp.employee.exception.NotFoundException;
import com.enigmacamp.employee.entity.Employee;
import com.enigmacamp.employee.entity.LearningPath;
import com.enigmacamp.employee.repository.EmployeeRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository employeeRepository;
    private final LearningPathService learningPathService;

    public EmployeeService(EmployeeRepository employeeRepository, LearningPathService learningPathService) {
        this.employeeRepository = employeeRepository;
        this.learningPathService = learningPathService;
    }

    @Override
    public Employee create(Employee employee) {
        try {
            return employeeRepository.save(employee);
        } catch (DataIntegrityViolationException e) {
            throw new EntityExistException();
        }
    }

    @Override
    public Optional<Employee> get(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new NotFoundException("Employee is Not Found");
        }
        return employee;
    }

    @Override
    public Employee getOne(String email) {
        try {
            Optional<Employee> employee = employeeRepository.getEmployeeByEmail(email);
            if (employee.isEmpty()) {
                throw new NotFoundException("Employee is not found");
            }
            return employee.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Page<Employee> getAll(int page, int pageSize, String direction, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
        Pageable pageable = PageRequest.of((page-1), pageSize, sort);
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee insertLearning(Employee employee, String id) {
        employeeRepository.findById(id);
        if (employee.getKnowledgeLeveraging() == null) {
            Optional<LearningPath> existingLearningPath =learningPathService.get(employee.getLearningPath().getLearningPathId());
            if (existingLearningPath.isEmpty()) {
                throw new NotFoundException("Learning Path is Not Found");
            }
            employee.setEmployeeId(id);
            employee.setLearningPath(existingLearningPath.get());
        }
        return employeeRepository.save(employee);
    }
}
