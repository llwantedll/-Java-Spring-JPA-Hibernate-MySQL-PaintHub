package com.llwantedll.dao;

import com.llwantedll.model.entities.Image;
import com.llwantedll.model.entities.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageDAO extends JpaRepository<Image, Long> {
    List<Image> findImagesByTags(List<Tag> tags);
    Image findImageByName(String name);
    Image findImageById(long id);

    //QUERY THAT FINDS IMAGES WITH PATTERN FROM..TO(PAGEABLE)
    @Query("SELECT DISTINCT i " +
            "from Image as i " +
            "left join i.tags t " +
            "where lower(i.name) like lower(:pattern) " +
            "OR lower(i.description) like lower(:pattern) " +
            "OR lower(t.name) like lower(:pattern) ")
    List<Image> findPattern(@Param("pattern") String pattern, Pageable pageable);

    //QUERY THAT FINDS ALL IMAGES COUNT(WITHOUT PAGEABLE)
    @Query("SELECT DISTINCT count(i) " +
            "from Image as i " +
            "left join i.tags t " +
            "where lower(i.name) like lower(:pattern) " +
            "OR lower(i.description) like lower(:pattern) " +
            "OR lower(t.name) like lower(:pattern) ")
    Long findPatternCount(@Param("pattern") String pattern);

}
