package com.enigmacamp.employee.model.request;

import com.enigmacamp.employee.entity.Syllabus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter@Setter
public class LearningPathRequest {
    private String period;
    private String topic;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private SyllabusRequest syllabus;
}
