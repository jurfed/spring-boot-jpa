package ru.jurfed.jpa.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Data
/*@NoArgsConstructor
@AllArgsConstructor*/
@Entity(name = "Person")
@Table(name = "Person")
public class Person {

    @Id
    @SequenceGenerator(name = "person_seq_gen", sequenceName = "person_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq_gen")
    @Column(name = "person_id")
    private int id;

    @Column(name = "person_name", nullable = false)
    private String name;

    @Column(name = "salary", nullable = true)
    private int salary;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = false, fetch = FetchType.EAGER/*, mappedBy = "post_Id"*/
    )
    @JoinColumn(name = "mail_person", referencedColumnName = "person_id")
    private List<Mail> mails = new ArrayList<>();

    public List<Mail> getMails() {
        return mails;
    }

    public void setMails(List<Mail> mails) {
        this.mails = mails;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "POSITIONS",
            joinColumns = @JoinColumn(name = "person_id", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "pos_id",nullable = true))
    Set<Position> positions = new HashSet();


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mails=" + mails +
                ", salary=" + salary +
                ", positions=" + positions +
                '}';
    }
}
