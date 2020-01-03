package ru.jurfed.jpa.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Position")
public class Position {

    public Position() {
    }

    public Position(String name) {
        this.name = name;
    }

    public Position(String name, Set<Person> personSet) {
        this.name = name;
        this.personSet = personSet;
    }

    @Id
    @Column(name = "position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "position_name")
    private String name;

    @ManyToMany(mappedBy = "positions")
    Set<Person> personSet;

    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", personSet=" + personSet +
                '}';
    }
}
