package com.llwantedll.service;

import com.llwantedll.model.entities.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagService {
    Tag findTagByName(String name);
    List<Tag> findAllTags();
    void deleteTagByName(String name);
    void save(Tag tag);
    void saveCollection(Iterable<Tag> tags);
    List<Tag> findRandomTags(int amount);
}
