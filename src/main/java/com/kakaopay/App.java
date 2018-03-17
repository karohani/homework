package com.kakaopay;

import com.kakaopay.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import com.kakaopay.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.servlet.annotation.WebServlet;

@SpringBootApplication
@EnableJpaRepositories
public class App {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

		PersonRepository personRepository = context.getBean(PersonRepository.class);
		personRepository.save(new Person("Hans", "Meiser"));
		personRepository.save(new Person("Peter", "Lustig"));

	}

}
