package com.enigmacamp.employee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "m_employee")
@Getter@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String employeeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "join_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date joinDate;

    @Column(name = "education", nullable = false)
    private String education;

    @ManyToOne
    @JoinColumn(name = "learning_path_id")
//    @JsonManagedReference
    private LearningPath learningPath;

    @ManyToOne
    @JoinColumn(name = "knowledge_leveraging_id")
    private KnowledgeLeveraging knowledgeLeveraging;

    @OneToMany(mappedBy = "employee")
    @JsonBackReference
    private List<Training> trainingList;
}
