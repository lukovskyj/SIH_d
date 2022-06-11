package com.studyisnthard.SIH.entity;

import javax.persistence.*;

@Entity
public class Achievements {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String achievementsName;
    private String achievementsDescription;

    public Achievements(){};

    public Achievements(Long id, String achievementsName, String achievementsDescription) {
        this.id = id;
        this.achievementsName = achievementsName;
        this.achievementsDescription = achievementsDescription;
    }

    public String getAchievementsName() {
        return achievementsName;
    }

    public void setAchievementsName(String achievementsName) {
        this.achievementsName = achievementsName;
    }

    public String getAchievementsDescription() {
        return achievementsDescription;
    }

    public void setAchievementsDescription(String achievementsDescription) {
        this.achievementsDescription = achievementsDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
