package com.enigmacamp.employee.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter@Setter
public class KnowledgeLeveragingRequest {
    private String period;
    private String topic;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
}
