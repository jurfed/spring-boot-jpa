package ru.jurfed.jpa.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Mail")
@Table(name = "mail")
public class Mail {

    public Mail() {
    }

    public Mail(String mailName) {
        this.mailName = mailName;
    }

    @Id
    @SequenceGenerator(name = "mail_seq", sequenceName = "mail_seq_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mail_seq")
    @Column(name = "mail_id")
    private int mailId;

    @Column(name = "mail_name")
    private String mailName;

    public String getMailName() {
        return mailName;
    }

    public void setMailName(String mailName) {
        this.mailName = mailName;
    }

    public int getMailId() {
        return mailId;
    }

    public void setMailId(int mailId) {
        this.mailId = mailId;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "mailId=" + mailId +
                ", mailName='" + mailName + '\'' +
                '}';
    }
}
