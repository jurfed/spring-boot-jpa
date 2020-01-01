package ru.jurfed.jpa.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Data
/*@NoArgsConstructor
@AllArgsConstructor*/
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Setter
    @Getter
    @SequenceGenerator(name = "person_seq_gen", sequenceName = "person_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq_gen")
    @Column(name = "person_id")
    private int id;

    @Setter
    @Getter
    @Column(name = "person_name", nullable = false)
    private String name;

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
