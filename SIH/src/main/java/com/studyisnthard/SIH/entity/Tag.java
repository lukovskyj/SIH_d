package com.studyisnthard.SIH.entity;

import javax.persistence.*;

@Entity
public class Tag {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    String tagName;

    public Tag(){}

    public Tag(Long id, String tagName) {
        this.id = id;
        this.tagName = tagName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
