package com.kakaopay.service;

import com.kakaopay.entity.Person;
import com.kakaopay.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepositroy;

    @Override
    public List<Person> loadAll() {
        return personRepositroy.findAll();
    }

    @Transactional
    public Person savePerson(Person person){
        return personRepositroy.saveAndFlush(person);
    }

    @Override
    public Person digestEmail(Person person) {

        String origin = person.getEmail();

        StringTo12LengthMapping mapper = new StringTo12LengthMapping(origin);
        person.setCompressed(mapper.digest());

        return person;
    }

}
