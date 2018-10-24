package com.llwantedll.validator;

import com.llwantedll.Utils.EmailUtil;
import com.llwantedll.model.entities.User;
import com.llwantedll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.io.IOException;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        //USER LOGIN VALIDATE
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Required");
        if(user.getLogin().length() <= 4 || user.getLogin().length() >= 16){
            errors.rejectValue("login", "Size.userForm.login");
        }

        if(userService.getUserByLogin(user.getLogin())!=null){
            errors.rejectValue("login", "Duplicate.userForm.login");
        }

        //USER NAME VALIDATE
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        if(user.getName().length() <= 2 || user.getName().length() >= 32){
            errors.rejectValue("name", "Size.userForm.name");
        }

        //USER EMAIL VALIDATE
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required");
        if(!EmailUtil.validate(user.getEmail())) {
            errors.rejectValue("email", "Pattern.userForm.email");
        }

        if(userService.getUserByEmail(user.getEmail())!=null){
            errors.rejectValue("email", "Duplicate.userForm.email");
        }

        //USER PASSWORD VALIDATE
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if(user.getPassword().length() <= 6 || user.getPassword().length() >= 20){
            errors.rejectValue("email", "Size.userForm.password");
        }

        if(!user.getPassword().equals(user.getConfirmPassword())){
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }

        //USER AVATAR VALIDATE
        try {
            if(user.getAvatarMP().getBytes().length > 1677721){
                errors.rejectValue("avatarMP", "Size.userForm.avatar");
            }
        } catch (IOException e) {
            e.printStackTrace();
            errors.rejectValue("avatarMP", "Error.addImageForm.image");
        }
    }
}
