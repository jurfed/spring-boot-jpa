package ru.jurfed.jpa.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Data
/*@NoArgsConstructor
@AllArgsConstructor*/
@Entity(name = "Person")
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


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mails=" + mails +
                '}';
    }
}
