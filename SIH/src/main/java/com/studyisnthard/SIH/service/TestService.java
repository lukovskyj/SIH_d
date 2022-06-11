package com.studyisnthard.SIH.service;

import com.studyisnthard.SIH.DTO.TestPreview;
import com.studyisnthard.SIH.entity.*;
import com.studyisnthard.SIH.repos.QuestionRepository;
import com.studyisnthard.SIH.repos.TagRepository;
import com.studyisnthard.SIH.repos.TestRepository;
import com.studyisnthard.SIH.repos.TestTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    TagRepository tagRepository;
    @Autowired
    TestTagRepository testTagRepository;

    public List<Test> getTestByAuthor(User user){
        return testRepository.findByUser(user);
    }

    public Test getTestById(Long test_id){
        Test test = testRepository.findById(test_id).orElse(new Test());
        return test;
    }

    public List<Question> getQuestionByTest(Long test_id){
        Test test = new Test(test_id,  null,  null, null);
        List<Question> testList = this.questionRepository.findByTest(test);
        return this.questionRepository.findByTest(test);
    }

    public Question getQuestionById(Long id){
        return questionRepository.findById(id).orElse(new Question());
    }

    public Test getTestByQuestTestId(Long question_id){
        Question question = questionRepository.findById(question_id).orElse(new Question());
        if (question.getId() != null){
            return this.testRepository.findById(question.getTest().getId()).orElse(new Test());
        }
        else {
            return null;
        }
    }

    public void updateQuestion(Question question){
        this.questionRepository.updateQuestionData(question.getId(), question.getCorrect_answer(), question.getQuestion_text());
    }

    public void saveDefaultQuestion(Long test_id){
        this.questionRepository.save(new Question(null, new Test(test_id, null, null, null), "default", "default"));
    }

    public void deleteQuestionById(Long question_id){
        this.questionRepository.deleteQuestionById(question_id);
    }

    public void deleteTestById(Long test_id){
        for (Question question : this.questionRepository.findByTest(
                new Test(test_id, null, null, null))){
            this.questionRepository.deleteQuestionById(question.getId());
        }
        this.testTagRepository.deleteByTest(new Test(test_id, null, null, null));
        this.testRepository.deleteById(test_id);
    }

    public void saveTag(Tag tag){
        Tag tag1 = this.tagRepository.findByTagName(tag.getTagName());
        if (tag1 == null){
            this.tagRepository.save(tag);
        }
    }

    public void saveTagList(List<Tag> tags){
        for (Tag tag : tags){
            this.saveTag(tag);
        }
    }


    public void createNewTest(String test_name, String test_desc, User user){
        this.testRepository.save(new Test(null, test_name, user, test_desc));
    }

    public void updateTest(Long id, String test_name, String test_description){
        this.testTagsChecker(test_description, id);
        this.testRepository.updateTestData(id, test_name, test_description);
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

    public void testTagsChecker(String str, Long test_id){
        this.testTagRepository.deleteByTest(new Test(test_id, null, null, null));
        this.tagsChecker(str);
        TestTag testTag = new TestTag();
        List<String> tagList = this.getTagsFormString(str);
        for (String str1 : tagList){
            Tag tag = this.tagRepository.findByTagName(str1);
            this.testTagRepository.save(new TestTag(null, new Test(test_id, null, null, null), tag));
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

    public List<Test> findLast3Test(){
        ArrayList<Test> last3Test = (ArrayList<Test>) this.testRepository.findAll();
        for (int i = 0; i < last3Test.size() - 7; i++){
            last3Test.remove(i);
        }
        return last3Test;
    }

    public List<TestPreview> getTestPreview(){
        List<Test> testList = findLast3Test();
        ArrayList<TestPreview> testPreviews = new ArrayList<>();
        for (Test test : testList){
            //int test_id, String test_name, String test_desc, List<Tag> tagList
            testPreviews.add(new TestPreview(test.getId(), test.getTest_name(), test.getTest_description(), this.getTestTag(test.getId())));
        }
        return testPreviews;
    }

    public List<Tag> getTestTag(Long test_id){
        List<TestTag> testTagList = this.testTagRepository.findByTest(new Test(test_id, null, null, null));

        ArrayList<Tag> tags = new ArrayList<>();
        for (TestTag testTag : testTagList){
            tags.add(this.tagRepository.findById(testTag.getId()).orElse(new Tag()));
        }
        return tags;
    }

    public List<Test> getTestByTag(String tag_name){
        List<TestTag> testTagList = this.testTagRepository.findByTag(this.tagRepository.findByTagName(tag_name));
        ArrayList<Test> tests = new ArrayList<>();
        if (testTagList != null){
            if (testTagList.size() > 3){
                for (int i = 0; i <3; i++){
                    tests.add(this.testRepository.findById(testTagList.get(i).getTest().getId()).orElse(new Test()));
                }
            }
            else {
                for (int i = 0; i < testTagList.size(); i++){
                    tests.add(this.testRepository.findById(testTagList.get(i).getTest().getId()).orElse(new Test()));
                }
            }
            List<Test>  t = new ArrayList<Test>(tests);
            return t;
        }
        else {
            return null;
        }
    }
}
