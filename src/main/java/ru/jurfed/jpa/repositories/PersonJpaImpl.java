package ru.jurfed.jpa.repositories;

import org.springframework.stereotype.Repository;
import ru.jurfed.jpa.models.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonJpaImpl implements PersonJpa{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Person> findById(int id) {
        return Optional.ofNullable(em.find(Person.class,id));
    }

    @Override
    public List<Person> findAll() {
        List<Person> persons = em.createQuery("select persons from Person persons", Person.class).getResultList();
        return persons;
    }

    @Transactional
    @Override
    public void renamePerson(Person person, String name) {
        person.setName(name);
        em.merge(person);
    }

    @Transactional
    @Override
    public void addPerson(String name) {
        Person person = new Person();
        person.setName(name);
        em.persist(person);
    }
}
