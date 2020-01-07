package ru.jurfed.jpa.jpql;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Repository
public class JpqlExamplesImpl {

    private EntityManagerFactory emf;

    private EntityManager em;

}
