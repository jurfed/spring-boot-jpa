package ru.jurfed.jpa.repositories;

import ru.jurfed.jpa.models.Address;
import ru.jurfed.jpa.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersonJpa {

    Optional<Person> findById(int id);
    Optional<Address> findMailById(int id);
    List<Person> findAll();

    void renamePerson(Person person, String name);

    void addPerson(String name);


    void addNewPersonWithNewMails();

    void addNewMailsToOldPerson();

    void addOneNewMailToOtherMailsForPerson();

    void nativeSqlQuery();

    void removePerson();

    void manyToManyAddPositionToPerson();

    void manyToManyAddPositionToPerson2();

    void renamePerson(String newName, int id);
}
