package com.studyisnthard.SIH.DTO;

import com.studyisnthard.SIH.entity.Tag;

import java.util.List;

public class TestPreview {
    private Long test_id;
    private String test_name;
    private String test_desc;
    private List<Tag> tagList;

    public TestPreview(Long test_id, String test_name, String test_desc, List<Tag> tagList) {
        this.test_id = test_id;
        this.test_name = test_name;
        this.test_desc = test_desc;
        this.tagList = tagList;
    }

    public TestPreview(){};

    public Long getTest_id() {
        return test_id;
    }

    public void setTest_id(Long test_id) {
        this.test_id = test_id;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    public String getTest_desc() {
        return test_desc;
    }

    public void setTest_desc(String test_desc) {
        this.test_desc = test_desc;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
