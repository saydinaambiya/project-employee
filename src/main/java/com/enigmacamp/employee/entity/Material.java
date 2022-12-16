package com.enigmacamp.employee.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;



@Entity
@Table(name = "m_material")
@Getter@Setter
public class Material {
    @Id
    @Column(name = "no", nullable = false, unique = true)
    private String no;

    @Column(name = "material", nullable = false)
    private String material;

    @Column(name = "day", nullable = false)
    private String day;

    @Column(name = "status")
    private String status;

    @Column(name = "notes")
    private String notes = "please fill constructive suggestions for future improvement ( by appraiser )";

    @ManyToOne
    @JoinColumn(name = "knowledge_leveraging_id")
    private KnowledgeLeveraging knowledgeLeveraging;
}
