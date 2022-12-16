package com.enigmacamp.employee.service;

import com.enigmacamp.employee.entity.Syllabus;

import java.util.Optional;

public interface ISyllabusService {
    Syllabus create(Syllabus syllabus);
    Optional<Syllabus> get(String id);
}
