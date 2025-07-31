package com.developersfun.Entity;


import jakarta.persistence.*;

import java.util.UUID;

@Entity        //  name of the table to be used in the code
@Table(name = "bookreview" )   // name of the table in the database
public class BookReviewEntity {


    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name="book_id")
    private String bookId;

    @Column(name="rating")
    private Integer rating;

    @Column(name = "review")
    private String review;


    // ----- Getters -----

    public String getId() {
        return id;
    }

    public String getBookId() {
        return bookId;
    }

    public Integer getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }

    // ----- Setters -----

    public void setId(String id) {
        this.id = id;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setReview(String review) {
        this.review = review;
    }

}
