package ru.jurfed.jpa.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "position")
@Table(name = "position")
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
    Set<Person> personSet = new HashSet();

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
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return name.equals(position.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
