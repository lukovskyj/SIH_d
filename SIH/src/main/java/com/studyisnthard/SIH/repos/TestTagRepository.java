package com.studyisnthard.SIH.repos;

import com.studyisnthard.SIH.entity.Tag;
import com.studyisnthard.SIH.entity.Test;
import com.studyisnthard.SIH.entity.TestTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TestTagRepository extends JpaRepository<TestTag, Long> {
    List<TestTag> findByTest(Test test);

    List<TestTag> findByTag(Tag tag);


    @Transactional
    @Modifying
    @Query("delete from TestTag t where t.test = :test")
    void deleteByTest(@Param("test") Test test);

}
