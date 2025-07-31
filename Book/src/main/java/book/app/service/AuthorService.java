package book.app.service;

import book.app.Entity.AuthorEntity;
import book.app.dao.authorEntityDAO;

public class AuthorService {
// contain business logic, They use DAOs to get or save data.
    private final authorEntityDAO authorEntityDAO;

    public AuthorService(authorEntityDAO authorEntityDAO) {
        this.authorEntityDAO = authorEntityDAO;
    }

    public int saveAuthor(AuthorEntity authorEntity) {
        return authorEntityDAO.save(authorEntity).getId();
    }
}
