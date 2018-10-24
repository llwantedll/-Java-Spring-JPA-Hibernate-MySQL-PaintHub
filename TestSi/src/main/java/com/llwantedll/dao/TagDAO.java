package com.llwantedll.dao;

import com.llwantedll.model.entities.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagDAO extends JpaRepository<Tag, Long>{
    Tag findTagByName(String name);
    void deleteTagByName(String name);

    @Query("SELECT t from Tag as t order by rand()")
    List<Tag> findRandomTags(Pageable p );
}
