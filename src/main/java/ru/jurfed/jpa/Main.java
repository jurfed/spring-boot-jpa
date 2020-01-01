package ru.jurfed.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.jurfed.jpa.models.Email;
import ru.jurfed.jpa.models.Person;
import ru.jurfed.jpa.models.Post;
import ru.jurfed.jpa.repositories.PersonJpa;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class);
        PersonJpa personJpa = context.getBean(PersonJpa.class);


        Person person = personJpa.findById(1).get();
        System.err.println("!!!!!!!!!!!!!!! Person: " + person);

        personJpa.renamePerson(person,"Kuzya");
        System.err.println("!!!!!!!! Renamed Person: " + person);

        personJpa.addPerson("Gleb");
        personJpa.addPerson("Puk");

        System.err.println("!!!!!!!!!! All Persons: " + personJpa.findAll());


        Email email = personJpa.findMailById(1).get();
        System.err.println("!!!!!!!!!!!!!!! EMail: " + email);


        System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        personJpa.testBook();
        Post p = personJpa.findPostById(1).get();
        System.err.println(p);

    }

}
