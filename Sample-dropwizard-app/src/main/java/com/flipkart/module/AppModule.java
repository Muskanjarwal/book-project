package com.flipkart.module;

import com.flipkart.db.AuthorDAO;
import com.flipkart.db.BookDAO;
import com.flipkart.db.HibernateUtil;
import com.flipkart.service.ServiceLayer;
import com.flipkart.service.ServiceLayerImpl;
import com.google.inject.AbstractModule;
import org.hibernate.SessionFactory;

public class AppModule extends AbstractModule {

  private final HibernateUtil hibernateUtil;

  public AppModule(HibernateUtil hibernateUtil) {this.hibernateUtil = hibernateUtil;}

  @Override
  protected void configure() {
    bind(SessionFactory.class).toInstance(hibernateUtil.getSessionFactory());
    bind(AuthorDAO.class).toInstance(new AuthorDAO(hibernateUtil.getSessionFactory()));
    bind(BookDAO.class).toInstance(new BookDAO(hibernateUtil.getSessionFactory()));
    bind(ServiceLayer.class).to(ServiceLayerImpl.class);
  }
}
