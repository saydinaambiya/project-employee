package com.enigmacamp.employee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "t_knowledge_leveraging")
@Getter@Setter
public class KnowledgeLeveraging {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String knowledgeLeveragingId;

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

    @OneToMany(mappedBy = "knowledgeLeveraging", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Employee> employeeList;

    @OneToMany(mappedBy = "knowledgeLeveraging")
    @JsonBackReference
    private List<Material> materialList;
}
