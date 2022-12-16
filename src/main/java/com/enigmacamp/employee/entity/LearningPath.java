package com.enigmacamp.employee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "t_learning_path")
@Getter@Setter
@ToString
public class LearningPath {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String learningPathId;

    @Column(name = "period", nullable = false)
    private String period;

    @Column(name = "topic", nullable = false, unique = true)
    private String topic;

    @Column(name = "start_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @OneToMany(mappedBy = "learningPath",cascade = CascadeType.ALL)
//    @JoinColumn(name = "employee_id")
    @JsonBackReference
    private List<Employee> employeeList;

    @OneToMany(mappedBy = "learningPath", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Syllabus> syllabus;
}
