package com.studyisnthard.SIH.repos;

import com.studyisnthard.SIH.entity.Test;
import com.studyisnthard.SIH.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findByUser(User user);

    @Transactional
    @Modifying
    @Query("update Test t set t.test_name = :test_name, t.test_description = :test_description where t.id = :id")
    void updateTestData(@Param("id") Long id, @Param("test_name") String test_name,
                            @Param("test_description") String test_description);

    Optional<Test> findById(Long id);

    @Transactional
    void deleteById(Long id);

}
