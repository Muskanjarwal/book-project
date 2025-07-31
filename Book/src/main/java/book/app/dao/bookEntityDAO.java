package book.app.dao;

import book.app.Entity.BookEntity;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class bookEntityDAO extends AbstractDAO<BookEntity> {

    public bookEntityDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public BookEntity find(int id) {
        return get(id);
    }

    public BookEntity save(BookEntity bookEntity) {
        return persist(bookEntity);
    }
}
