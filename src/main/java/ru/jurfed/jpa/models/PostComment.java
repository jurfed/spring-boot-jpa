package ru.jurfed.jpa.models;

import javax.persistence.*;

@Entity(name = "PostComment")
@Table(name = "post_comment")
public class PostComment {
 
    @Id
    @SequenceGenerator(name = "post_comment", sequenceName = "post_comment_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_comment")
    private int id;
 
    private String review;

    public PostComment() {}

    public PostComment( String review) {
        this.review = review;
    }

    public PostComment( String review, int post_Id) {
        this.review = review;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "PostComment{" +
                "id=" + id +
                ", review='" + review + '\'' +
                '}';
    }

}