package com.enigmacamp.employee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "t_training")
@Getter@Setter
public class Training {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String trainingId;

    @Column(name = "no", nullable = false, unique = true)
    private String no;

    @Column(name = "course", nullable = false)
    private String course;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "start_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "organizer", nullable = false)
    private String organizer;

    @Column(name = "training_value", nullable = false)
    private String training_value;

    @Column(name = "budget", nullable = false)
    private Integer budget;

    @Column(name = "certificate", nullable = false)
    private String certificate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonManagedReference
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonManagedReference
    private AchievementType achievementType;
}
