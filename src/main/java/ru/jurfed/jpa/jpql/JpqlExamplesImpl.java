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


    public class InvalidNameException extends Exception {
        public InvalidNameException(String message) {
            super(message);
        }
    }

    /**
     * roll back transaction if name="Bobik"
     *
     * @param name
     * @throws InvalidNameException
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = InvalidNameException.class)
    public void checkedRollBack(String name) throws InvalidNameException {
        System.err.println("----------------------Read only transaction-------------------------------");
        TypedQuery<Person> personResult = em.createQuery("select p from Person p where p.name = :pName", Person.class);
        personResult.setParameter("pName", name);
        Person person = personResult.getSingleResult();
        person.setName("name 1");
        em.persist(person);
        if (name.equals("Bobik")) {
            throw new InvalidNameException("wrong name");
        }

    }

    public void getSalary1() {

        System.err.println("\nwhere");
        TypedQuery<Integer> query = em.createQuery(
                "SELECT p.salary FROM Person AS p where p.name = :newName", Integer.class);
        query.setParameter("newName", "Katerina Ivanova");
        int salary = query.getSingleResult();

        System.err.println(salary);


        System.err.println("\nMultiple SELECT Expressions");
        TypedQuery<Object[]> query2 = em.createQuery(
                "SELECT c.name, c.salary.name FROM Person AS c", Object[].class);
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


}

class NamesAndSalary {
    String name;
    int salary;

    public NamesAndSalary(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "NamesAndSalary{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
