package com.llwantedll.controllers;

import com.llwantedll.model.entities.Image;
import com.llwantedll.service.ImageService;
import com.llwantedll.service.TagService;
import com.llwantedll.validator.ImageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ImageController {

    @Autowired private ImageValidator imageValidator;

    @Autowired private ImageService imageService;
    @Autowired private TagService tagService;

    @GetMapping("/add_image")
    public String addImageLink(ModelMap model){
        model.put("addImageForm", new Image());
        model.put("tagCloud", tagService.findRandomTags(MainController.TAGS_ON_PAGE));
        return "add_image";
    }

    @PostMapping("/add_image")
    public String add_image(@ModelAttribute(name = "addImageForm") Image addImageForm,
                            BindingResult bindingResult,
                            @RequestParam("imageMP") MultipartFile file,
                            ModelMap model){
        imageValidator.validate(addImageForm, bindingResult);
        if(bindingResult.hasErrors()) {
            return "/add_image";
        }
        try {
            addImageForm.setImage(file.getBytes());
            imageService.saveImage(addImageForm);
            return "redirect:/";
        } catch (IOException e) {
            return "/add_image";
        }
    }

    @GetMapping("/delete_image/{imageId}")
    public String deleteImage(@PathVariable int imageId, ModelMap model){
        if(imageService.findImageById(imageId) != null) {
            model.put("delete_text", "deleted");
            imageService.deleteImageByid(imageId);
        }
        else
            model.put("delete_text", "image not found");
        return "index";
    }

    @GetMapping("/image_profile/{imageId}")
    public String imageProfile(@PathVariable long imageId, ModelMap model){
        Image imageProfile = imageService.findImageById(imageId);
        model.put("imageProfile", imageProfile);
        model.put("tagCloud", tagService.findRandomTags(MainController.TAGS_ON_PAGE));
        return "image_profile";
    }
}
