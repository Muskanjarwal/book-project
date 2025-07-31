package book.app.service;

import book.app.Entity.BookEntity;
import book.app.dao.bookEntityDAO;


public class BookService {

    // create DAO object
    private final bookEntityDAO bookEntityDAO;

    // constructor to inject DAO
    public BookService(bookEntityDAO bookEntityDAO) {
        this.bookEntityDAO = bookEntityDAO;
    }


    // method - check and post review
    // -- call bookEntityDAO and save
    public int saveBook(BookEntity bookEntity) {
        return bookEntityDAO.save(bookEntity).getId();
    }

}
