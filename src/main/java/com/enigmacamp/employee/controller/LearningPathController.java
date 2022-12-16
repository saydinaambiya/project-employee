package com.enigmacamp.employee.controller;

import com.enigmacamp.employee.entity.LearningPath;
import com.enigmacamp.employee.model.request.LearningPathRequest;
import com.enigmacamp.employee.model.response.PagingResponse;
import com.enigmacamp.employee.model.response.SuccessResponse;
import com.enigmacamp.employee.service.ILearningPathService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/learning-path")
@Validated
public class LearningPathController {
    private final ModelMapper modelMapper;
    private final ILearningPathService learningPathService;

    public LearningPathController(ModelMapper modelMapper, ILearningPathService learningPathService) {
        this.modelMapper = modelMapper;
        this.learningPathService = learningPathService;
    }

    @PostMapping
    ResponseEntity insertLearningPath(@Valid @RequestBody LearningPathRequest learningPathRequest){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        LearningPath newLearningPath = modelMapper.map(learningPathRequest, LearningPath.class);
        LearningPath result = learningPathService.create(newLearningPath);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success insert new learning path", result));
    }

    @GetMapping
    public ResponseEntity getALl(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "ASC") String direction,
            @RequestParam(defaultValue = "period") String sortBy
    ) throws Exception{
        Page<LearningPath> learningPaths = learningPathService.getAll(page, pageSize, direction, sortBy);
        return ResponseEntity.status(HttpStatus.OK).body(new PagingResponse<>("Success get all learning path", learningPaths));
    }

    @GetMapping("/{id}")
    public ResponseEntity getLearningPathById(@PathVariable("id") String id){
        LearningPath learningPath = learningPathService.get(id).get();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get learning path by ID", learningPath));
    }
}
