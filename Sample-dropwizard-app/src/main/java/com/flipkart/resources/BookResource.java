package com.flipkart.resources;

import com.flipkart.core.Book;
import com.flipkart.service.ServiceLayer;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/book")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
  private final ServiceLayer serviceLayer;

  public BookResource(ServiceLayer serviceLayer) {
    this.serviceLayer = serviceLayer;
  }

  @GET
  public Response getAllBooks() {
    return Response.ok(serviceLayer.getAllBooks()).build();
  }

  @GET
  @Path("/{Id}")
  public Response getBookById(@PathParam("Id") Long id) {
    return serviceLayer.getBookById(id).map(book -> Response.ok(book).build())
        .orElse(Response.status(Response.Status.NOT_FOUND).build());
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response addBook(Book book) {
    serviceLayer.addBook(book);
    return Response.status(Response.Status.CREATED).entity(book).build();
  }

  @GET
  @Path("/author/{AuthorId}")
  public Response getBooksByAuthorId(@PathParam("AuthorId") Long authorId) {
    return Response.ok(serviceLayer.getBooksByAuthorId(authorId)).build();
  }
}
