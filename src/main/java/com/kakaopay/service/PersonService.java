package com.kakaopay.service;

import com.kakaopay.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> loadAll();
    Person savePerson(Person person);
    Person digestEmail(Person person);

}
