package ru.jurfed.jpa.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {

    @Id
    @Setter
    @Getter
    @SequenceGenerator(name = "addr_seq_gen", sequenceName = "addr_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addr_seq_gen")
    @Column(name = "addr_id")
    private int id;

    @Column(name = "street")
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
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", person=" + person +
                '}';
    }
}
