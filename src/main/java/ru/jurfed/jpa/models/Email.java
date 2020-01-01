package ru.jurfed.jpa.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Email {

    @Id
    @Setter
    @Getter
    @SequenceGenerator(name = "email_seq_gen", sequenceName = "email_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_seq_gen")
    @Column(name = "emailid")
    private int id;

    @Column(name = "address")
    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personid", referencedColumnName = "person_id")
    private Person person;

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", person=" + person +
                '}';
    }
}
