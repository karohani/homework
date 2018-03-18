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

@CrossOrigin("*")
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


    @RequestMapping(value="/person/list", method= RequestMethod.GET)
    public List<Person> dog(@RequestParam("page") int page, @RequestParam("per_page") int n ){

        HashMap<String, Object> map = new HashMap<>();
        List<Person> personList = personService.loadAll();
        System.out.println(page + " " + n);
        map.put("CouponList", personList);
        map.put("query", "a");
        return personList;
    }

    @RequestMapping(value="/person/insert/{email}", method = RequestMethod.GET)
    public String successable(@PathVariable String email){

        Person person = new Person();
        person.setEmail(email);
        person = personService.digestEmail(person);
        personService.savePerson(person);
        return person.getCompressed();
    }

}
