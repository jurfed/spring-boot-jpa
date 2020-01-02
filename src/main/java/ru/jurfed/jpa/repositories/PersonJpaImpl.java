package ru.jurfed.jpa.repositories;

import org.springframework.stereotype.Repository;
import ru.jurfed.jpa.models.Address;
import ru.jurfed.jpa.models.Person;
import ru.jurfed.jpa.models.Post;
import ru.jurfed.jpa.models.PostComment;

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
    public Optional<Address> findMailById(int id) {
        return Optional.ofNullable(em.find(Address.class,id));
    }

    @Override
    public List<Person> findAll() {
        List<Person> persons = em.createQuery("select per from Person per", Person.class).getResultList();
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

    @Transactional
    @Override
    public void testBook() {
        Post post = new Post(1,"title 1");

        post.getComments().add(
                new PostComment("My first review", post.getId())
        );
        post.getComments().add(
                new PostComment("My second review", post.getId())
        );
        post.getComments().add(
                new PostComment("My third review", post.getId())
        );
        post.getComments().add(
                new PostComment("My fourth review", post.getId())
        );

        em.persist(post);

    }

    @Override
    public Optional<Post> findPostById(int id) {
        return Optional.ofNullable(em.find(Post.class,id));
    }
}
