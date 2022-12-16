package com.enigmacamp.employee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "m_syllabus")
@Getter@Setter
@ToString
public class Syllabus {
    @Id
    @Column(name = "no", nullable = false, unique = true)
    private String no;

    @Column(name = "syllabus", nullable = false)
    private String syllabus;

    @Column(name = "day", nullable = false)
    private String day;

    @Column(name = "status")
    private String status = "On Progress";

    @Column(name = "notes")
    private String notes = "please fill constructive suggestions for future improvement ( by appraiser )";

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "learningPathId")
    private LearningPath learningPath;

}
