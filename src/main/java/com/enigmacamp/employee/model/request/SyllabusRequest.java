package com.enigmacamp.employee.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class SyllabusRequest {
    private String no;
    private String syllabus;
    private String day;

    private LearningPathIdRequest learningPath;

}
