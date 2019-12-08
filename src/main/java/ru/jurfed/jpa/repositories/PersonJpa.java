package ru.jurfed.jpa.repositories;

import ru.jurfed.jpa.models.Person;

import java.util.List;
import java.util.Optional;

public interface PersonJpa {

    Optional<Person> findById(int id);
    List<Person> findAll();

    void renamePerson(Person person, String name);

    void addPerson(String name);
}
