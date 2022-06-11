package com.studyisnthard.SIH.service;

import com.studyisnthard.SIH.entity.*;
import com.studyisnthard.SIH.repos.ArticleRepository;
import com.studyisnthard.SIH.repos.ArticleTagRepository;
import com.studyisnthard.SIH.repos.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ArticleTagRepository articleTagRepository;

    @Autowired
    TagRepository tagRepository;

    public Article getArticleById(Long id){
        return this.articleRepository.findById(id).orElse(new Article());
    }

    public void saveArticle(Article article){
        this.articleRepository.save(article);
    }

    public List<Article> getArticleListByUser(User user){
       return this.articleRepository.findByUser(user);
    }

    public void deleteArticleById(Long id){
        this.articleRepository.deleteById(id);
    }

    public void updateArticle(Long id,String a_data, String a_desc, String a_name){
        this.articleTagsChecker(a_desc, id);
        this.articleRepository.updateTestData(id, a_data, a_desc, a_name);
    }

    public void articleTagsChecker(String str, Long article_id){
        this.articleTagRepository.deleteByArticle(new Article(article_id, null, null, null, null));
        this.tagsChecker(str);
        ArticleTag articleTag = new ArticleTag();
        List<String> tagList = this.getTagsFormString(str);
        for (String str1 : tagList){
            Tag tag = this.tagRepository.findByTagName(str1);
            this.articleTagRepository.save(new ArticleTag(null, new Article(article_id, null, null, null, null), tag));
        }
    }

    public void tagsChecker(String str){
        if (str != null){
            List<String> tagsListFromStr = this.getTagsFormString(str);
            if (tagsListFromStr != null){
                List<Tag> tagList = new ArrayList<>();
                for (String s : tagsListFromStr){
                    tagList.add(new Tag(null, s));
                }
                this.saveTagList(tagList);
            }
        }
    }

    public List<String> getTagsFormString(String str){
        Pattern MY_PATTERN = Pattern.compile("#(\\w+)");
        Matcher mat = MY_PATTERN.matcher(str);
        List<String> strs=new ArrayList<String>();
        while (mat.find()) {
            strs.add(mat.group(1));
        }
        return strs;
    }

    public void saveTagList(List<Tag> tags){
        for (Tag tag : tags){
            this.saveTag(tag);
        }
    }

    public void saveTag(Tag tag){
        Tag tag1 = this.tagRepository.findByTagName(tag.getTagName());
        if (tag1 == null){
            this.tagRepository.save(tag);
        }
    }

}
