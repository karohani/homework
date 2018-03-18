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


    @RequestMapping(value="/person/list", method= RequestMethod.GET)
    public List<Person> dog(@RequestParam("page") int page, @RequestParam("perPage") int n ){

        List<Person> personList = personService.loadAll();
        return personList;
    }

    @RequestMapping(value="/person/insert/{email}", method = RequestMethod.GET)
    public String successable(@PathVariable String email){

        Person person = personService.digestEmail(email);
        System.out.println("EXIST?" + personService.isExistEmail(email));

        if(personService.isExistEmail(email)){
            return "fail";
        }

        personService.savePerson(person);
        return person.getCompressed();
    }

}
