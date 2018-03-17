package com.kakaopay.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Main {

    @RequestMapping("/mainmenu")
    public String index() {
        return "index";
    }

}
