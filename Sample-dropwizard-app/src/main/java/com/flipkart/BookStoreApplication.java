package com.flipkart;

import com.flipkart.core.Author;
import com.flipkart.core.Book;
import com.flipkart.db.AuthorDAO;
import com.flipkart.db.BookDAO;
import com.flipkart.db.HibernateUtil;
import com.flipkart.health.DatabaseHealthCheck;
import com.flipkart.resources.AuthorResource;
import com.flipkart.resources.BookResource;
import com.flipkart.service.ServiceLayer;
import com.flipkart.service.ServiceLayerImpl;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import org.hibernate.SessionFactory;

public class BookStoreApplication extends Application<BookStoreConfiguration> {

  public static void main(String[] args) {
    try {
      new BookStoreApplication().run(args);
    }catch(Exception e){
      e.printStackTrace();
    }
  }
  private final HibernateBundle<BookStoreConfiguration> hibernate = new HibernateBundle<BookStoreConfiguration>(Author.class,
      Book.class) {
    @Override
    public DataSourceFactory getDataSourceFactory(BookStoreConfiguration configuration) {
      return configuration.getDataSourceFactory();
    }
  };

  @Override
  public void initialize(Bootstrap<BookStoreConfiguration> bootstrap) {
    bootstrap.addBundle(hibernate);
  }

  @Override
  public void run(BookStoreConfiguration config, Environment environment) {
    AuthorDAO dao1=new AuthorDAO(hibernate.getSessionFactory());
    BookDAO dao2=new BookDAO(hibernate.getSessionFactory());

    ServiceLayer serviceLayer=new ServiceLayerImpl(dao1,dao2);

    AuthorResource resource1=new AuthorResource(serviceLayer);
    BookResource resource2=new BookResource(serviceLayer);

    environment.jersey().register(resource1);
    environment.jersey().register(resource2);

    // Health Checks
    final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    environment.healthChecks().register("database", new DatabaseHealthCheck(sessionFactory));
  }
}
