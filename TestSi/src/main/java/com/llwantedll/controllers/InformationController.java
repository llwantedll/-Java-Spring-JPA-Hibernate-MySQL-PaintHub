package com.llwantedll.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InformationController {

    @GetMapping("/about_us")
    public String aboutUs(ModelMap map){
        map.put("information", "about_us");
        return "information";
    }

    @GetMapping("/rules")
    public String rules(ModelMap map){
        map.put("information", "rules");
        return "information";
    }
}
