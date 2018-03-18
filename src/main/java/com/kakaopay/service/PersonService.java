package com.kakaopay.service;

import com.kakaopay.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> loadAll();
    Person savePerson(Person person);
    Person digestEmail(String email);
    Person collisionSaveStretegy(String email);
    Person findCompressed(String email);

}
