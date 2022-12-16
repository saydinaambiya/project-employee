package com.enigmacamp.employee.controller;

import com.enigmacamp.employee.entity.Syllabus;
import com.enigmacamp.employee.model.request.SyllabusRequest;
import com.enigmacamp.employee.model.response.SuccessResponse;
import com.enigmacamp.employee.service.ISyllabusService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/syllabus")
@Validated
public class SyllabusController {
    private final ModelMapper modelMapper;
    private final ISyllabusService service;

    public SyllabusController(ModelMapper modelMapper, ISyllabusService service) {
        this.modelMapper = modelMapper;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity registerSyllabus(@Valid @RequestBody SyllabusRequest syllabusRequest){
        Syllabus newSyllabus = modelMapper.map(syllabusRequest, Syllabus.class);
        Syllabus result = service.create(newSyllabus);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success insert new syllabus", newSyllabus));
    }

    @GetMapping("/{no}")
    public ResponseEntity getSyllabusByNo(@PathVariable("no") String no){
        Optional<Syllabus> existSyllabus = service.get(no);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get syllabus by No", existSyllabus));
    }
}
