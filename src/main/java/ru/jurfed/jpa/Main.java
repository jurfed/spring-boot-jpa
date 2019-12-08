package ru.jurfed.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.jurfed.jpa.models.Person;
import ru.jurfed.jpa.repositories.PersonJpa;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class);
        PersonJpa personJpa = context.getBean(PersonJpa.class);


        Person person = personJpa.findById(1).get();
        System.out.println(person);

        personJpa.renamePerson(person,"Kuzya");
        System.out.println(person);

        personJpa.addPerson("Gleb");
        personJpa.addPerson("Puk");

        System.err.println(personJpa.findAll());
    }

}
