package com.flipkart.service;

import com.flipkart.core.Author;
import com.flipkart.core.Book;
import java.util.List;
import java.util.Optional;

public interface ServiceLayer {
  public void addAuthor(Author author);
  public Optional<Author> getAuthorById(Long Id);
  public List<Author> getAllAuthors();
  public void addBook(Book book);
  public Optional<Book> getBookById(Long Id);
  public List<Book> getAllBooks();
  public List<Book> getBooksByAuthorId(Long Id);
}
