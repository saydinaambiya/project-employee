package com.enigmacamp.employee.service;

import com.enigmacamp.employee.exception.EntityExistException;
import com.enigmacamp.employee.exception.NotFoundException;
import com.enigmacamp.employee.entity.LearningPath;
import com.enigmacamp.employee.repository.LearningPathRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LearningPathService implements ILearningPathService{
    final private LearningPathRepository learningPathRepository;

    public LearningPathService(LearningPathRepository learningPathRepository) {
        this.learningPathRepository = learningPathRepository;
    }

    @Override
    public LearningPath create(LearningPath learningPath) {
        try {

            return learningPathRepository.save(learningPath);
        } catch (DataIntegrityViolationException e) {
            throw new EntityExistException();
        }
    }

    @Override
    public Optional<LearningPath> get(String id) {
        Optional<LearningPath> learningPath = learningPathRepository.findById(id);
        if (learningPath.isEmpty()) {
            throw new NotFoundException("Learning Path is Not Found");
        }
        return learningPath;
    }

    @Override
    public Page<LearningPath> getAll(int page, int pageSize, String direction, String sortBy) {
        Sort sort = Sort.by(Sort.Direction.valueOf(direction), sortBy);
        Pageable pageable = PageRequest.of((page-1), pageSize, sort);
        return learningPathRepository.findAll(pageable);
    }
}
