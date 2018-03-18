package com.kakaopay.repository;


import com.kakaopay.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByCompressed(String compressed);
    Person findByEmail(String Email);
}
