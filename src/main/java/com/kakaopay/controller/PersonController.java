package com.kakaopay.controller;


import com.kakaopay.entity.Person;
import com.kakaopay.repository.PersonRepository;
import com.kakaopay.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/pro")
    public String showIndex(Model model) {

        List<Person> personList = personService.loadAll();
        System.out.println("M");
        model.addAttribute("personList", personList);
        return "index.html"; // return index.html Template
    }


    @RequestMapping(value="/person/{compressed}", method= RequestMethod.GET)
    public HashMap<String, Object> dog(@PathVariable String compressed){

        HashMap<String, Object> map = new HashMap<>();
        List<Person> personList = personService.loadAll();
        map.put("Coupon_List", personList);
        map.put("query", compressed);
        return map;
    }

    @RequestMapping(value="/person/insert/{email}", method = RequestMethod.GET)
    public String successable(@PathVariable String email){

        Person person = new Person();
        person.setEmail(email);
        personService.savePerson(person);
        return "sucess";
    }
}
