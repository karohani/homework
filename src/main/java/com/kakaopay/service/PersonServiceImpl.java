package com.kakaopay.service;

import com.kakaopay.entity.Person;
import com.kakaopay.repository.PersonRepository;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
    public Person savePerson(Person person) {

        Person inPerson;

        try{
            inPerson = personRepositroy.save(person);

        }catch(Exception e){
            collisionSaveStrategy(person.getEmail());
        }
        return inPerson;
    }

    @Override
    public Person digestEmail(String email) {

        Person person = new Person();
        StringTo12LengthMapping mapper = new StringTo12LengthMapping(email);
        person.setCompressed(mapper.digest());

        return person;
    }

    @Override
    public Person collisionSaveStrategy(String email) {

        StringTo12LengthMapping mapper = new StringTo12LengthMapping(email);
        String compressed = mapper.digest();

        do{
                email += "a";
                mapper.setOrigin(email);
                compressed = mapper.digest();

        }while(isExistCoupon(compressed));

        Person collisionPerson = new Person();
        collisionPerson.setEmail(email);
        collisionPerson.setCompressed(compressed);

        return savePerson(collisionPerson);
    }

    @Override
    public Boolean isExistCoupon(String coupon) {

        return personRepositroy.findByCompressed(coupon) != null;
    }

    @Override
    public Boolean isExistEmail(String email) {

        return personRepositroy.findByEmail(email) != null;
    }

}
