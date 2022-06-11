package com.studyisnthard.SIH.repos;

import com.studyisnthard.SIH.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByTagName(String tagName);

    Optional<Tag> findById(Long id);
}
