

#### Spring boot jpa (jpql)
- @Repository
- @Transactional (readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = InvalidNameException.class)
- @PersistenceContext -> EntityManager em;
- @Entity, @Table, @Id, @GeneratedValue(strategy = GenerationType.SEQUENCE),@Column(name = "addr_id"),...
- @OneToMany, @JoinColumn, ...

em.merge(person);
em.persist(person);
em.remove(person);
em.find(Address.class, id)

        List<Person> persons = em.createQuery("select per from Person per", Person.class).getResultList();
        return persons;
        
        
        TypedQuery<Person> allMatchesQuery = em.createQuery("select per from Person per where per.id = :perId", Person.class);
        allMatchesQuery.setParameter("perId", 1);
        Person person = allMatchesQuery.getSingleResult();
        
        
        String query = "insert into mail(mail_name) values ('Marfusha!')";
        em.createNativeQuery(query).executeUpdate();
        
        
        TypedQuery<Object[]> query2 = em.createQuery(
            "SELECT c.name, c.salary FROM Person AS c", Object[].class);
        List<Object[]> results = query2.getResultList();
         
         TypedQuery<NamesAndSalary> query3 = em.createQuery(
            "SELECT NEW ru.jurfed.jpa.jpql.NamesAndSalary(c.name, c.salary) FROM Person AS c", 
            NamesAndSalary.class);
         List<NamesAndSalary> namesAndSalaries = query3.getResultList();
         
         
         TypedQuery<Object[]> query = em.createQuery(
            "select adr.address, per.name from Address adr join adr.person per where per.name like '%Ivan%' ",
             Object[].class);
         List<Object[]> results = query.getResultList();