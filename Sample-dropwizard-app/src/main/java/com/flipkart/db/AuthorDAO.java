package com.flipkart.db;

import com.flipkart.core.Author;
import com.google.inject.Inject;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AuthorDAO {

  SessionFactory sessionFactory;

  @Inject
  public AuthorDAO(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}

  public void addAuthor(Author author) {
    Transaction transaction=null;
    try(Session session = sessionFactory.openSession()){
      transaction = session.beginTransaction();
      session.persist(author); // create a row entry
      transaction.commit();
    }catch(Exception e){
      if(transaction!=null){
        transaction.rollback();
      }
      throw new RuntimeException("Error adding author "+author.getFirstName()+e);
    }
  }

  public Optional<Author> getAuthorById(Long Id) {
    try(Session session = sessionFactory.openSession()){
      Author author = session.get(Author.class, Id); // read
      return Optional.ofNullable(author);
    } catch (Exception e) {
      throw new RuntimeException("Error finding author with id: "+Id+e);
    }
  }

  public List<Author> getAllAuthors() {
    try(Session session = sessionFactory.openSession()) {
      return session.createQuery("from Author", Author.class).list();
    } catch (Exception e) {
      throw new RuntimeException("Error getting all authors"+e);
    }
  }
}
