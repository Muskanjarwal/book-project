package com.flipkart.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

  private static StandardServiceRegistry standardServiceRegistry; // to initialize hibernate
  private static SessionFactory sessionFactory;

  static{
    try {
      if(sessionFactory == null){ // if session factory is null the we create a new session

        // create StandardServiceRegistry
        standardServiceRegistry= new StandardServiceRegistryBuilder().configure().build();

        // create MetadataSources - gathers all the metadata
        MetadataSources metadataSource=new MetadataSources(standardServiceRegistry);

        // create metadata
        Metadata metadata= metadataSource.getMetadataBuilder().build();

        // create session factory
        sessionFactory= metadata.getSessionFactoryBuilder().build();
      }
    } catch (Exception e) {
      if(standardServiceRegistry != null){
        standardServiceRegistry.close();
      }
      else throw new RuntimeException(e);
    }
  }

  // Utility method to return session factory
  public static SessionFactory getSessionFactory(){
    return sessionFactory;
  }
}
