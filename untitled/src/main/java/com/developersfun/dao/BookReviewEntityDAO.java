package com.developersfun.dao;

import com.developersfun.Entity.BookReviewEntity;
import io.dropwizard.hibernate.AbstractDAO;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.SessionFactory;

import java.util.UUID;

public class BookReviewEntityDAO extends AbstractDAO<BookReviewEntity> {
    public BookReviewEntityDAO(SessionFactory sessionFactory){
        super(sessionFactory);

    }

    public BookReviewEntity find(String id){
        return get(id);


    }

    public BookReviewEntity save(BookReviewEntity entity) {
        if (StringUtils.isEmpty(entity.getId())) {
            entity.setId(UUID.randomUUID().toString()); // because your id is String
        }
        return persist(entity);
    }



}
