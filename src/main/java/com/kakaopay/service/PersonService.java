package com.kakaopay.service;

import com.kakaopay.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> loadAll();
    Person savePerson(Person person);
    Person digestEmail(String email);
    Person collisionSaveStrategy(String email);
    Boolean isExistCoupon(String coupon);
    Boolean isExistEmail(String email);

}
