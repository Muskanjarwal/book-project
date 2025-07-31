package com.flipkart.db;

import com.flipkart.core.Book;
import com.google.inject.Inject;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class BookDAO {

  SessionFactory sessionFactory;

  @Inject
  public BookDAO(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public void addBook(Book book) {
    Transaction transaction = null;
    try (Session session = sessionFactory.openSession()) {
      transaction = session.beginTransaction();
      session.persist(book);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      throw new RuntimeException("Error in adding Book " + book.getTitle() + e);
    }
  }

  public Optional<Book> getBookById(Long Id) {
    try (Session session = sessionFactory.openSession()) {
      Book book = session.get(Book.class, Id);
      return Optional.ofNullable(book);
    } catch (Exception e) {
      throw new RuntimeException("Error in getting books by Id" + e);
    }
  }

  public List<Book> getAllBooks() {
    try (Session session = sessionFactory.openSession()) {
      return session.createQuery("from Book", Book.class).list();
    } catch (Exception e) {
      throw new RuntimeException("Error getting all books" + e);
    }
  }

  public List<Book> getBooksByAuthorId(Long authorId) {
    try (Session session = sessionFactory.openSession()) {
      return session.createQuery("from Book where authorId = :authorId", Book.class).setParameter("authorId", authorId)
          .list();
    } catch (Exception e) {
      throw new RuntimeException("Error getting books by authorId" + e);
    }
  }
}
