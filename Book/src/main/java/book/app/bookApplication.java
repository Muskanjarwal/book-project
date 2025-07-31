package book.app;

import book.app.Entity.BookEntity;
import book.app.config.BookConfiguration;

import book.app.dao.authorEntityDAO;
import book.app.dao.bookEntityDAO;
import book.app.resources.AuthorResources;
import book.app.resources.BookResources;
import book.app.service.AuthorService;
import book.app.service.BookService;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;

public class bookApplication extends Application<BookConfiguration> {
    //  entry point
    public static void main(String[] args) throws Exception {
        new bookApplication().run(args);
    }

//
   HibernateBundle<BookConfiguration> hibernateBundle = new HibernateBundle<BookConfiguration>(BookEntity.class) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(BookConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    //-----------compul-- initialse - add bundles before app starts
    @Override
    public void initialize(Bootstrap<BookConfiguration> bootstrap) {
        // required to start hibernate
        bootstrap.addBundle(hibernateBundle);   //addbundle- add hibernate support to dropwizard
    }

    @Override
    public void run(BookConfiguration configuration, Environment environment) {
        System.out.println("App is running");
           // sessionfactory is a hibernate object - creating session - represent conection to the database-used to perform crud operation on the db
        // dao class needs sessionfactory to communicate with the db
        bookEntityDAO bookEntityDAO = new bookEntityDAO(hibernateBundle.getSessionFactory());
        authorEntityDAO authorEntityDAO = new authorEntityDAO(hibernateBundle.getSessionFactory());

        // Services
        BookService bookService = new BookService(bookEntityDAO);
        AuthorService authorService = new AuthorService(authorEntityDAO);

        // Resources (Register with Jersey)
//       These lines tell Dropwizard to turn your BookResources and AuthorResources classes into active web API endpoints.--
//Think of it like this:
//BookResources and AuthorResources are like blueprints for handling requests about books and authors.
//environment.jersey().register(...) is like saying, "Hey Dropwizard, take these blueprints, build the actual 'book' and 'author' parts of my website, and make them ready to receive requests."
//Without these lines, your API won't work, as Dropwizard won't know where to send incoming requests for /books or /authors.
        environment.jersey().register(new BookResources(bookService));
        environment.jersey().register(new AuthorResources(authorService));
    }
}
