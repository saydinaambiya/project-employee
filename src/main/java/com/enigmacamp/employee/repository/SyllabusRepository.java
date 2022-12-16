package com.enigmacamp.employee.repository;

import com.enigmacamp.employee.entity.Syllabus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SyllabusRepository extends JpaRepository<Syllabus, String> {
}
