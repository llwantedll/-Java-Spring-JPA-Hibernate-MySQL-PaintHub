package com.llwantedll.service;

import com.llwantedll.dao.ImageDAO;
import com.llwantedll.dao.UserDAO;
import com.llwantedll.model.entities.Image;
import com.llwantedll.model.entities.Tag;
import com.llwantedll.model.entities.User;
import com.llwantedll.model.logic.ImageResultAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired private SecurityService securityService;
    @Autowired private TagService tagService;

    @Autowired private UserDAO userDAO;
    @Autowired private ImageDAO imageDAO;

    @Override
    public List<Image> getAllImages() {
        return imageDAO.findAll();
    }

    @Override
    public List<Image> findImagesByTags(List<Tag> tags) {
        return imageDAO.findImagesByTags(tags);
    }

    @Override
    public void saveImage(Image image) {
        User user = userDAO.findByLogin(securityService.findLoggedInLogin());
        if(user!=null){
            image.setUser(user);
            image.setDateLoad(Date.valueOf(LocalDate.now()));

            //STRING TAGS TO LIST OF TAGS
            List<Tag> tags = Arrays.stream(image.getTagsString()
                    .split(","))
                    .map(e -> new Tag(e.trim().toLowerCase()))
                    .collect(Collectors.toList());

            //UPDATE TAG IF EXIST, ADD TAG IF DOESN'T
            for (int i = 0; i < tags.size(); i++) {
                Tag tag = tagService.findTagByName(tags.get(i).getName());
                if(tag!=null){
                    tag.setNewImage(image);
                    image.setNewTag(tag);
                    tags.remove(i);
                    i--;
                }
                else
                    image.setNewTag(tags.get(i));
            }

            //SAVE TAGS&IMAGE
            tagService.saveCollection(tags);
            imageDAO.save(image);
        }

    }

    @Override
    public void deleteImageByid(long id) {
        imageDAO.deleteById(id);
    }

    @Override
    public Image findImageByName(String name) {
        return imageDAO.findImageByName(name);
    }

    @Override
    public Image findImageById(long id) {
        return imageDAO.findImageById(id);
    }


    @Override
    public Long countImages() {
        return imageDAO.count();
    }

    @Override
    public ImageResultAggregate findImagesPageByPattern(String pattern, int page, int elements){
        ImageResultAggregate result = new ImageResultAggregate();
        Pageable pageable = PageRequest.of(page, elements, Sort.Direction.DESC, "dateLoad", "id");
        String patternParam = "%"+pattern+"%";
        result.setImages(imageDAO.findPattern(patternParam, pageable));
        result.setCount(imageDAO.findPatternCount(patternParam));
        return result;
    }
}
