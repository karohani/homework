package com.kakaopay.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/mainmenu")
    public String index() {
        return "index";
    }

    @RequestMapping("/common")
    public String common() {
        return "common";
    }

    @RequestMapping("/study")
    public String commonstudy() {
        return "study";
    }


}
