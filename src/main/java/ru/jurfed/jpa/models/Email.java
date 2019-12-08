package ru.jurfed.jpa.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Email {

    @Setter
    @Getter
    @Id
    @Column(name = "emailId")
    private int id;

    @Column(name = "address")
    @Getter
    @Setter
    private String address;


}
