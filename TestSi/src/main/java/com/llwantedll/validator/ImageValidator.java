package com.llwantedll.validator;

import com.llwantedll.model.entities.Image;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.io.IOException;
import java.util.Arrays;

@Component
public class ImageValidator implements Validator{
    @Override
    public boolean supports(Class<?> aClass) {
        return Image.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Image image = (Image) o;

        //IMAGE SIZE VALIDATE
        try {
            if(image.getImageMP().getBytes().length > 16777215
                    || image.getImageMP().getBytes().length == 0){
                errors.rejectValue("imageMP", "Size.addImageForm.image");
            }
        } catch (IOException e) {
            e.printStackTrace();
            errors.rejectValue("imageMP", "Error.addImageForm.image");
        }

        //IMAGE NAME VALIDATE
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        if(image.getName().length()>20){
            errors.rejectValue("name", "Size.addImageForm.name");
        }

        //IMAGE DESCRIPTION VALIDATE
        if(image.getDescription().length()>500){
            errors.rejectValue("description", "Size.addImageForm.description");
        }


        //CHECKS IF ALL TAGS LENGTH IS HIGHER THAN 100 OR
        //SOME TAG IS HIGHER THAN 20
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tagsString", "Required");
        if(image.getTagsString().length()>100){
            errors.rejectValue("tagsString", "Size.addImageForm.tags");
        }
        else{
            if(Arrays.stream(image.getTagsString()
                    .split(","))
                    .anyMatch(e -> e.length() > 20))
                errors.rejectValue("tagsString", "Size.addImageForm.tag");
        }
    }
}
