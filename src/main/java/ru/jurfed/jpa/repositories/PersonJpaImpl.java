package ru.jurfed.jpa.repositories;

import org.springframework.stereotype.Repository;
import ru.jurfed.jpa.models.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonJpaImpl implements PersonJpa {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<Person> findById(int id) {
        return Optional.ofNullable(em.find(Person.class, id));
    }

    @Override
    public Optional<Address> findMailById(int id) {
        return Optional.ofNullable(em.find(Address.class, id));
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
    public void addNewPersonWithNewMails() {
        List<Mail> mailList = new ArrayList<>();

        Mail mail1 = new Mail();
        mail1.setMailName("yandex.ru");
        mailList.add(mail1);

        Mail mail2 = new Mail();
        mail2.setMailName("mail.ru");
        mailList.add(mail2);

        Person person = new Person();
        person.setName("Jury");
        person.setMails(mailList);
        em.persist(person);
        System.err.println("new Person with two new mails!!!!!!!!!!!!!!!   " + person);

    }

    @Transactional
    @Override
    public void addNewMailsToOldPerson() {
        TypedQuery<Person> allMatchesQuery = em.createQuery("select per from Person per where per.id = :perId", Person.class);
        allMatchesQuery.setParameter("perId", 1);
        Person person = allMatchesQuery.getSingleResult();
        List<Mail> mailList = new ArrayList<>();

        Mail mail1 = new Mail();
        mail1.setMailName("inbox.ru");
        mailList.add(mail1);

        Mail mail2 = new Mail();
        mail2.setMailName("google.ru");
        mailList.add(mail2);

        person.setMails(mailList);
        em.merge(person);
        System.err.println("old Person with two new mails!!!!!!!!!!!!!!!   " + person);
    }

    @Override
    @Transactional
    public void addOneNewMailToOtherMailsForPerson() {
        TypedQuery<Person> allMatchesQuery = em.createQuery("select per from Person per where per.name = :personName", Person.class);
        allMatchesQuery.setParameter("personName", "Kuzya");
        Person person = allMatchesQuery.getSingleResult();
        person.getMails().add(new Mail("kuzy@yandex.ru"));
        em.merge(person);
        System.err.println("Added one new mail to other mails for Kuzya: " + person);
    }

    @Transactional
    @Override
    public void nativeSqlQuery() {
        String query = "insert into mail(mail_name) values ('Marfusha!')";
        em.createNativeQuery(query).executeUpdate();
        System.out.println();
    }

    @Transactional
    @Override
    public void removePerson() {
        TypedQuery<Person> allMatchesQuery = em.createQuery("select per from Person per where per.name = :personName", Person.class);
        allMatchesQuery.setParameter("personName", "Jury");
        Person person = allMatchesQuery.getSingleResult();
        em.remove(person);
    }

    @Transactional
    @Override
    public void manyToManyAddPositionToPerson() {
        TypedQuery<Person> allMatchesQuery = em.createQuery("select per from Person per where per.name = :personName", Person.class);
        allMatchesQuery.setParameter("personName", "Kuzya");

        Position pos1 = new Position("doctor");
        em.persist(pos1);
        Position pos2 = new Position("engener");
        em.persist(pos2);


        Person person = allMatchesQuery.getSingleResult();
        person.setPositions(new HashSet(){{add(pos1); add(pos2);}});
        em.merge(person);
        System.err.println(person);
    }


}
