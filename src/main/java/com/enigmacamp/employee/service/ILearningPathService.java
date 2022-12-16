package com.enigmacamp.employee.service;

import com.enigmacamp.employee.entity.LearningPath;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ILearningPathService {
    LearningPath create(LearningPath learningPath);
    Optional<LearningPath> get(String id);
    Page<LearningPath> getAll(int page, int pageSize, String direction, String sortBy);
}
