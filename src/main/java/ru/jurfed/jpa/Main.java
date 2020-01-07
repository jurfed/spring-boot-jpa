package ru.jurfed.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.jurfed.jpa.jpql.JpqlExamples;
import ru.jurfed.jpa.jpql.JpqlExamplesImpl;
import ru.jurfed.jpa.models.Address;
import ru.jurfed.jpa.models.Person;
import ru.jurfed.jpa.repositories.PersonJpa;

@SpringBootApplication
public class Main {

    public static void main(String[] args) throws JpqlExamplesImpl.InvalidNameException {
        System.err.println("----------------------------SPRING BOOT DATA JPA   /models/; /repositories/----------------------------------");

        ApplicationContext context = SpringApplication.run(Main.class);
        PersonJpa personJpa = context.getBean(PersonJpa.class);


        Person person = personJpa.findById(1).get();
        System.err.println("!!!!!!!!!!!!!!! Person: " + person);

        personJpa.renamePerson(person, "Kuzya");
        System.err.println("!!!!!!!! Renamed Person: " + person);

        personJpa.addPerson("Gleb");
        personJpa.addPerson("Puk");

        System.err.println("!!!!!!!!!! All Persons: " + personJpa.findAll());


        Address email = personJpa.findMailById(1).get();
        System.err.println("!!!!!!!!!!!!!!! EMail: " + email);


        /**
         * create new Person with new mails
         */
        personJpa.addNewPersonWithNewMails();

        /**
         * add new Mails to old Person
         */
        personJpa.addNewMailsToOldPerson();

        /**
         * add new Mails to other mails for Person Kuzya
         */
        personJpa.addOneNewMailToOtherMailsForPerson();

        /**
         * create native query
         */
        personJpa.nativeSqlQuery();

        /**
         * remove Person
         */
        personJpa.removePerson();

        personJpa.manyToManyAddPositionToPerson();

        personJpa.manyToManyAddPositionToPerson2();

        /**
         * rename Person
         */
        personJpa.renamePerson("Ivan Zolotozvonov",1);
        personJpa.renamePerson("Katerina Ivanova",2);
        personJpa.renamePerson("Kesha Vislouhov",3);
        personJpa.renamePerson("Bobik",-43);
        personJpa.renamePerson("Martishka",-44);


        System.err.println("----------------------------JPQL & Transactional   /models/; /jpql/----------------------------------");
        JpqlExamples jpqlExamples = (JpqlExamples) context.getBean("jpql");
        jpqlExamples.readOnlyPerson("Bobik");



        //roll back transaction if name = "Bobik"
        jpqlExamples.checkedRollBack("Martishka");
//        jpqlExamples.checkedRollBack("Bobik");

        //get salary to Integer.class; to Object[].class
        jpqlExamples.getSalary1();

        // get name, salaru to NamesAndSalary.class
        jpqlExamples.getSalaryFromAnotherClass();
        jpqlExamples.distinct();
    }

}
