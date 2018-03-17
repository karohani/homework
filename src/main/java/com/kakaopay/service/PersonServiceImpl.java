package com.kakaopay.service;

import com.kakaopay.entity.Person;
import com.kakaopay.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepositroy;

    @Override
    public List<Person> loadAll() {
        return personRepositroy.findAll();
    }
}
