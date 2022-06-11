package com.studyisnthard.SIH.entity;


import javax.persistence.*;

@Entity
public class ArticleTag {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Article article;

    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn
    private Tag tag;

    public ArticleTag(){}

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public ArticleTag(Long id, Article article, Tag tag) {
        this.id = id;
        this.article = article;
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
