package com.studyisnthard.SIH.entity;

import javax.persistence.*;

@Entity
public class Test {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    String test_name;

    @ManyToOne
    User user;

    String test_description;

    public Test(){};

    public Test(Long id, String test_name, User user, String test_description) {
        this.id = id;
        this.test_name = test_name;
        this.user = user;
        this.test_description = test_description;
    }

    public String getTest_description() {
        return test_description;
    }

    public void setTest_description(String test_description) {
        this.test_description = test_description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
