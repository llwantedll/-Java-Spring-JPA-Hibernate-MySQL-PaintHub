package com.llwantedll.service;

import com.llwantedll.model.entities.Image;
import com.llwantedll.model.entities.Tag;
import com.llwantedll.model.logic.ImageResultAggregate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImageService {
    List<Image> getAllImages();
    List<Image> findImagesByTags(List<Tag> tags);
    void saveImage(Image image);
    void deleteImageByid(long id);
    Image findImageByName(String name);
    Image findImageById(long id);
    Long countImages();
    ImageResultAggregate findImagesPageByPattern(String pattern, int page, int elements);
}
