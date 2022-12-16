package com.enigmacamp.employee.controller;

import com.enigmacamp.employee.entity.Employee;
import com.enigmacamp.employee.model.request.EmployeeRequest;
import com.enigmacamp.employee.model.request.LearningPathIdRequest;
import com.enigmacamp.employee.model.response.PagingResponse;
import com.enigmacamp.employee.model.response.SuccessResponse;
import com.enigmacamp.employee.service.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
@Validated
public class EmployeeController {
    private final ModelMapper modelMapper;
    private final IEmployeeService service;

    public EmployeeController(ModelMapper modelMapper, IEmployeeService service) {
        this.modelMapper = modelMapper;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity registerEmployee(@Valid @RequestBody EmployeeRequest employeeRequest) {
        Employee newEmployee = modelMapper.map(employeeRequest, Employee.class);
        Employee result = service.create(newEmployee);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>(newEmployee.getName() + " Success registered", result));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity getEmployeeById(@PathVariable("id") String id) {
//        Employee employee = employeeService.get(id).get();
//        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get by ID", employee));
//
//    }

    @GetMapping("/{email}")
    public ResponseEntity getEmployeeByEmail(@PathVariable("email") String email){
        Employee employee = service.getOne(email);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get by email", employee));
    }

    @GetMapping
    public ResponseEntity getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "ASC") String direction,
            @RequestParam(defaultValue = "name") String sortBy
    ) throws Exception {
        Page<Employee> employees = service.getAll(page, pageSize, direction, sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(new PagingResponse<>("Succes get all employees", employees));

    }

    @PostMapping("/{id}-learning-path")
    public ResponseEntity insertEmployeeLearningPath(@Valid @RequestBody LearningPathIdRequest learningPathIdRequest, @PathVariable("id") String id) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Employee existingEmployee = modelMapper.map(learningPathIdRequest, Employee.class);
        Employee result = service.insertLearning(existingEmployee, id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success insert learning path", result));
    }


}

