package com.flipkart.service;

import com.flipkart.core.Author;
import com.flipkart.core.Book;
import com.flipkart.db.AuthorDAO;
import com.flipkart.db.BookDAO;
import java.util.List;
import java.util.Optional;

public class ServiceLayerImpl implements ServiceLayer {
  AuthorDAO authorDAO;
  BookDAO bookDAO;

  public ServiceLayerImpl(AuthorDAO authorDAO, BookDAO bookDAO) {
    this.authorDAO = authorDAO;
    this.bookDAO = bookDAO;
  }

  public void addAuthor(Author author){
    authorDAO.addAuthor(author);
  }

  public Optional<Author> getAuthorById(Long Id){
    return authorDAO.getAuthorById(Id);
  }
  public List<Author> getAllAuthors(){
    return authorDAO.getAllAuthors();
  }
  public void addBook(Book book){
    bookDAO.addBook(book);
  }
  public Optional<Book> getBookById(Long Id){
    return bookDAO.getBookById(Id);
  }
  public List<Book> getAllBooks(){
    return bookDAO.getAllBooks();
  }
  public List<Book> getBooksByAuthorId(Long Id){
    return bookDAO.getBooksByAuthorId(Id);
  }
}
