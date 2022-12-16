package com.enigmacamp.employee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "m_achievement_type")
@Getter@Setter
@ToString
public class AchievementType {
    @Id
    @Column(name = "achievement_type_id", nullable = false, unique = true)
    private String achievementTypeId;

    @Column(name = "achievement_type", nullable = false, unique = true)
    private String achievementType;

    @OneToMany(mappedBy = "achievementType")
    @JsonBackReference
    private List<Training> trainingList;
}
