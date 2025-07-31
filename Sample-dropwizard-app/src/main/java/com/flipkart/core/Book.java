package com.flipkart.core;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name="title")
  private String title;

  @Column(name="Author_id")
  private int authorId;

  public Book() {
  }

  public Book(long id, String title, int authorId) {
    this.id = id;
    this.title = title;
    this.authorId = authorId;
  }

  public String getTitle() {
    return title;
  }

  public long getId() {
    return id;
  }

  public int getAuthorId() {
    return authorId;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAuthorId(int authorId) {
    this.authorId = authorId;
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", authorId=" + authorId +
        '}';
  }
}
