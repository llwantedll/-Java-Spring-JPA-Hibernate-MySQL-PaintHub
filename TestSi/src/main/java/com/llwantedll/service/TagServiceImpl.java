package com.llwantedll.service;

import com.llwantedll.dao.TagDAO;
import com.llwantedll.model.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDAO tagDAO;

    @Override
    public Tag findTagByName(String name) {
        return tagDAO.findTagByName(name);
    }

    @Override
    public List<Tag> findAllTags() {
        return tagDAO.findAll();
    }

    @Override
    public void deleteTagByName(String name) {
        tagDAO.deleteTagByName(name);
    }

    @Override
    public void save(Tag tag) {
        tagDAO.save(tag);
    }

    @Override
    public void saveCollection(Iterable<Tag> tags) {
        tagDAO.saveAll(tags);
    }

    @Override
    public List<Tag> findRandomTags(int amount) {
        return tagDAO.findRandomTags(PageRequest.of(0,amount));
    }

}
