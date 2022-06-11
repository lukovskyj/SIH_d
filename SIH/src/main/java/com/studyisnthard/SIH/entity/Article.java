package com.studyisnthard.SIH.entity;

import javax.persistence.*;

@Entity
public class Article {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String articleName;
    private String articleDesc;
    @Column(length = 10000)
    private String articleData;

    @ManyToOne
    User user;

    public Article(){}

    public Article(Long id, String articleName, String articleDesc, String articleData, User user) {
        this.id = id;
        this.articleName = articleName;
        this.articleDesc = articleDesc;
        this.articleData = articleData;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleDesc() {
        return articleDesc;
    }

    public void setArticleDesc(String articleDesc) {
        this.articleDesc = articleDesc;
    }

    public String getArticleData() {
        return articleData;
    }

    public void setArticleData(String articleData) {
        this.articleData = articleData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
