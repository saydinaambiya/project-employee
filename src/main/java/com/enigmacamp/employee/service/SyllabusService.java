package com.enigmacamp.employee.service;

import com.enigmacamp.employee.entity.LearningPath;
import com.enigmacamp.employee.entity.Syllabus;
import com.enigmacamp.employee.exception.EntityExistException;
import com.enigmacamp.employee.exception.NotFoundException;
import com.enigmacamp.employee.repository.SyllabusRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SyllabusService implements ISyllabusService{
    final private SyllabusRepository syllabusRepository;
    final private  ILearningPathService learningPathService;

    public SyllabusService(SyllabusRepository syllabusRepository, ILearningPathService learningPathService) {
        this.syllabusRepository = syllabusRepository;
        this.learningPathService = learningPathService;
    }

    @Override
    public Syllabus create(Syllabus syllabus) {
        try {
            Optional<LearningPath> existLearningPath = learningPathService.get(syllabus.getLearningPath().getLearningPathId());
            if (existLearningPath.isEmpty()) {
                throw new NotFoundException("Learning Path Not Found");
            }
            syllabus.setLearningPath(existLearningPath.get());
            return syllabusRepository.save(syllabus);
        } catch (DataIntegrityViolationException e) {
            throw new EntityExistException();
        }
    }

    @Override
    public Optional<Syllabus> get(String id) {
        Optional<Syllabus> syllabus = syllabusRepository.findAll().stream().filter(s -> s.getNo().equals(id)).findAny();
        if (syllabus.isEmpty()) {
            throw new NotFoundException("Syllabus is Not Found");
        }
        return syllabus;
    }
}
