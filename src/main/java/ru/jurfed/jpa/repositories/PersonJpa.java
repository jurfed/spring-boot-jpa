package ru.jurfed.jpa.repositories;

import ru.jurfed.jpa.models.Email;
import ru.jurfed.jpa.models.Person;
import ru.jurfed.jpa.models.Post;

import java.util.List;
import java.util.Optional;

public interface PersonJpa {

    Optional<Person> findById(int id);
    Optional<Email> findMailById(int id);
    List<Person> findAll();

    void renamePerson(Person person, String name);

    void addPerson(String name);

    void testBook();

    public Optional<Post> findPostById(int id);
}
