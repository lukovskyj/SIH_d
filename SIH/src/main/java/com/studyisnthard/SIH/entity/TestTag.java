package com.studyisnthard.SIH.entity;

import javax.persistence.*;

@Entity
public class TestTag {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Test test;

    @ManyToOne
    @JoinColumn
    private Tag tag;

    public TestTag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TestTag(Long id, Test test, Tag tag) {
        this.id = id;
        this.test = test;
        this.tag = tag;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
