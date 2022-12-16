package com.enigmacamp.employee.repository;

import com.enigmacamp.employee.entity.LearningPath;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearningPathRepository extends JpaRepository<LearningPath, String> {
}
