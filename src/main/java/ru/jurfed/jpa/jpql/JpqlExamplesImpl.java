package ru.jurfed.jpa.jpql;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.InvalidIsolationLevelException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.jurfed.jpa.models.Person;

import javax.persistence.*;
import java.util.List;

@Repository("jpql")
public class JpqlExamplesImpl implements JpqlExamples {

    //    private EntityManagerFactory emf;
    @PersistenceContext
    private EntityManager em;

    /*    @PersistenceUnit
        public void setEm(EntityManagerFactory emf) {
            this.emf = emf;
            em = emf.createEntityManager();

        }*/
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = InvalidIsolationLevelException.class)
    @Override
    public void readOnlyPerson(String name) {
        System.err.println("----------------------Read only transaction-------------------------------");
        TypedQuery<Person> personResult = em.createQuery("select p from Person p where p.name = :pName", Person.class);
        personResult.setParameter("pName", name);
        Person person = personResult.getSingleResult();

        System.err.println(person);
        person.setName("new Name");

        em.persist(person);

    }

    /**
     * roll back transaction if name="Bobik"
     *
     * @param name
     * @throws InvalidNameException
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = InvalidNameException.class)
    public void checkedRollBack(String name) throws InvalidNameException {
        System.err.println("\n----------------------Roll back transaction-------------------------------");
        TypedQuery<Person> personResult = em.createQuery("select p from Person p where p.name = :pName", Person.class);
        personResult.setParameter("pName", name);
        Person person = personResult.getSingleResult();
        person.setName("name 1");
        em.persist(person);
        if (name.equals("Martishka")) {
//            throw new InvalidNameException("wrong name");
        }

    }

    public class InvalidNameException extends Exception {
        public InvalidNameException(String message) {
            super(message);
        }
    }


    public void getSalary1() {

        System.err.println("\nwhere");
        TypedQuery<Integer> query = em.createQuery(
                "SELECT p.salary FROM Person AS p where p.name = :newName", Integer.class);
        query.setParameter("newName", "Kesha Vislouhov");
        int salary = query.getSingleResult();

        System.err.println(salary);


        System.err.println("\nMultiple SELECT Expressions");
        TypedQuery<Object[]> query2 = em.createQuery(
                "SELECT c.name, c.salary FROM Person AS c", Object[].class);
        List<Object[]> results = query2.getResultList();
        for (Object[] result : results) {
            System.err.println(
                    "Person name: " + result[0] + ", Person salary: " + result[1]);
        }


    }


    //------------------------------------------------------------------------


    @Override
    public void getSalaryFromAnotherClass() {
        System.err.println("\nSalary from custom class");
        TypedQuery<NamesAndSalary> query3 = em.createQuery(
                "SELECT NEW ru.jurfed.jpa.jpql.NamesAndSalary(c.name, c.salary) FROM Person AS c", NamesAndSalary.class);
        List<NamesAndSalary> namesAndSalaries = query3.getResultList();
        namesAndSalaries.forEach(namesAndSalary -> System.err.println(namesAndSalary));
    }

    @Override
    public void distinct() {
        System.err.println("\ndistinct and %");
        TypedQuery<String> typedQuery = em.createQuery("select distinct p.name from Person p where p.name like 'K%'", String.class);
        typedQuery.getResultList().forEach(s -> System.err.println(s));
    }

    @Override
    public void groupByMaxSalary() {
        System.err.println("\nMax salary:");
        TypedQuery<Integer> query2 = em.createQuery(
                "SELECT max(p.salary) FROM Person p", Integer.class);
        System.err.println(query2.getSingleResult());


        System.err.println("\nCount:");
        TypedQuery<Long> count = em.createQuery("select count(p) from Person p", Long.class);
        System.err.println("Person counts: " + count.getSingleResult());

        System.err.println("\nJoin:");
        TypedQuery<Person> personQuery = em.createQuery("select p from Person p JOIN p.positions pos where pos=3", Person.class);
        personQuery.getResultList().forEach(System.err::println);
    }

    @Override
    public void addressJoinPerson() {
        System.err.println("\nAddress join person:");

        TypedQuery<Object[]> query = em.createQuery("select adr.address, per.name from Address adr join adr.person per where per.name like '%Ivan%' ", Object[].class);
        List<Object[]> results = query.getResultList();

        results.forEach(objects -> {
            System.err.println("Address: " + objects[0] + "   Person: " + objects[1]);
        });
    }


}


