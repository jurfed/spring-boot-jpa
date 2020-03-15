package ru.jurfed.jpa.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {

    @Id
/*    @Setter
    @Getter*/
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "addr_id")
    private int id;

    @Column(name = "street")
/*    @Getter
    @Setter*/
    private String address;

/*    @Getter
    @Setter*/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personid", referencedColumnName = "person_id")
    private Person person;


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", person=" + person +
                '}';
    }
}
