package com.flipkart.resources;

import com.flipkart.core.Author;
import com.flipkart.service.ServiceLayer;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/author")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorResource {

  private final ServiceLayer serviceLayer;

  public AuthorResource(ServiceLayer serviceLayer) {this.serviceLayer = serviceLayer;}

  @GET
  public Response getAllAuthors() {
    return Response.ok(serviceLayer.getAllAuthors()).build();
  }

  @GET
  @Path("/{Id}")
  public Response getAuthorById(@PathParam("Id") Long id) {
    return serviceLayer.getAuthorById(id)
        .map(author->Response.ok(author).build())
        .orElse(Response.status(Response.Status.NOT_FOUND).build());
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  public Response addAuthor(Author author) {
    serviceLayer.addAuthor(author);
    return Response.ok(author).build();
  }
}
