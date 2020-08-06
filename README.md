

#### Spring boot jpa (jpql)
- @Repository
- @Transactional
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