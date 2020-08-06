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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addr_id")
    private Address address;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = false, fetch = FetchType.EAGER/*, mappedBy = "post_Id"*/
    )
    @JoinColumn(name = "mail_person_id", referencedColumnName = "person_id")
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
            joinColumns = @JoinColumn(name = "positions_person_id", nullable = true),
            inverseJoinColumns = @JoinColumn(name = "positions_pos_id",nullable = true))
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", address=" + address +
                ", mails=" + mails +
                ", positions=" + positions +
                '}';
    }
}
