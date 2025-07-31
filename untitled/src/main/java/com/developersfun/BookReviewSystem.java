package com.developersfun;


import com.developersfun.Entity.BookReviewEntity;
import com.developersfun.config.BRSConfiguration;
import com.developersfun.dao.BookReviewEntityDAO;
import com.developersfun.resource.BookReviewResource;
import io.dropwizard.core.Application;

import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;

public class BookReviewSystem extends Application<BRSConfiguration> {
    public static void main(String[] args) throws Exception{


        new BookReviewSystem().run(args);
    }

    @Override
    public void run(BRSConfiguration brsconfiguration, Environment environment) throws Exception {
                System.out.println("its running");

                BookReviewEntityDAO bookReviewEntityDAO=new BookReviewEntityDAO(hibernateBundle.getSessionFactory());
                environment.jersey().register(new BookReviewResource(bookReviewEntityDAO));


    }

    HibernateBundle<BRSConfiguration> hibernateBundle = new HibernateBundle<BRSConfiguration>(BookReviewEntity.class) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(BRSConfiguration brsconfiguration) {
            return brsconfiguration.getDataSourceFactory();  // FIX: return actual DataSourceFactory
        }
    };

    @Override
    public void initialize(Bootstrap<BRSConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

}

