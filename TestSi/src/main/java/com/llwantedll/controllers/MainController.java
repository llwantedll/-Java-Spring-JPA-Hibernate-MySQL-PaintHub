package com.llwantedll.controllers;

import com.llwantedll.model.entities.User;
import com.llwantedll.model.logic.ImageResultAggregate;
import com.llwantedll.model.logic.PageNavigator;
import com.llwantedll.service.ImageService;
import com.llwantedll.service.SecurityService;
import com.llwantedll.service.TagService;
import com.llwantedll.service.UserService;
import com.llwantedll.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MainController {

    //IN FUTURE THIS VARIABLES WILL BE ADJUSTABLE
    public static final int PAGE_SHOW = 5;
    public static final int IMAGE_PER_PAGE = 9;
    public static final int TAGS_ON_PAGE = 10;

    @Autowired private UserService userService;
    @Autowired private SecurityService securityService;
    @Autowired private ImageService imageService;
    @Autowired private TagService tagService;

    @Autowired private UserValidator userValidator;

    @GetMapping("/")
    public String mainPage(ModelMap model){
        return findImages(1, "", model);
    }

    //SEARCH ENGINE
    @GetMapping("/find")
    public String findImages(@RequestParam int page,
                             @RequestParam String find,
                             ModelMap model){
        ImageResultAggregate im = imageService.findImagesPageByPattern(find,page-1, IMAGE_PER_PAGE);
        model.put("images", im.getImages());
        model.put("pageNavigator", new PageNavigator(page, PAGE_SHOW,
                IMAGE_PER_PAGE, im.getCount()));
        model.put("findParameter", find);
        model.put("tagCloud", tagService.findRandomTags(TAGS_ON_PAGE));
        return "index";
    }

    @GetMapping("/error")
    public String errorPage(ModelMap model){
        model.put("error", "login or password is incorrect");
        return mainPage(model);
    }

    @GetMapping("/register")
    public String reg(ModelMap map){
        map.put("userForm", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("userForm") User userForm,
                           ModelMap modelMap,
                           BindingResult bindingResult,
                           @RequestParam MultipartFile avatarMP){
        userValidator.validate(userForm, bindingResult);
        if(bindingResult.hasErrors()){
            return "register";
        }
        if(avatarMP!=null) {
            try {
                userForm.setAvatar(avatarMP.getBytes());
                userService.save(userForm);
                securityService.autologin(userForm.getLogin(), userForm.getConfirmPassword());
                return "redirect:/";
            } catch (IOException e) {
                return "/register";
            }
        }
        return "/register";
    }

    //USER PROFILE PAGE
    @GetMapping("/profile/{login}")
    public String profile(@PathVariable String login, ModelMap model){
        User userProfile = userService.getUserByLogin(login);
        model.put("userProfile", userProfile);
        model.put("tagCloud", tagService.findRandomTags(TAGS_ON_PAGE));
        return "profile";
    }

}
