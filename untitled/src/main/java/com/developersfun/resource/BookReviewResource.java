package com.developersfun.resource;



import com.developersfun.Entity.BookReviewEntity;
import com.developersfun.dao.BookReviewEntityDAO;
import io.dropwizard.hibernate.UnitOfWork;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.util.Date;

@Path("/book")

public class BookReviewResource {

    // create a dao

    private final BookReviewEntityDAO bookReviewEntityDAO;

    public BookReviewResource(BookReviewEntityDAO bookReviewEntityDAO){
        this.bookReviewEntityDAO= bookReviewEntityDAO;
    }
    @GET
    @Path("/healthCheck")
    public String healthCheck(){

        return "ping received at "+ new Date();
    }

    @POST

    @Path("/review")
    @UnitOfWork
    public String postReview(@Valid BookReviewEntity bookReviewEntity){

        return bookReviewEntityDAO.save(bookReviewEntity)
                .getId() ;
    }
}


//WHAT WE NEED TO CONFIGURE HIBERNATE Connection
//FOR DB CONNECTION
//database
// Configuration
// database properties
// entity
//DAO- data access object
