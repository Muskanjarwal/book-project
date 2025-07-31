package book.app.dao;

import book.app.Entity.AuthorEntity;
import book.app.Entity.BookEntity;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class authorEntityDAO extends AbstractDAO<AuthorEntity> {
//    It runs when you create a new authorEntityDAO and needs a SessionFactory (used to connect to the database).
    public authorEntityDAO(SessionFactory sessionFactory){
//        Calls the parent class’s constructor to set up database access.
        super(sessionFactory);
    }

//    handle database operations (save, find, update, delete).
//    They use Hibernate to talk to the database.
    public AuthorEntity find(int id) {
        return get(id);
    }

    public AuthorEntity save(AuthorEntity authorEntity) {
        return persist(authorEntity);
    }
}
