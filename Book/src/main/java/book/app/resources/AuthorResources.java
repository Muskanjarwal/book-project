package book.app.resources;

import book.app.Entity.AuthorEntity;

import book.app.service.AuthorService;
import io.dropwizard.hibernate.UnitOfWork;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//define REST endpoints (URLs) for your app.
//They use services to process requests and send responses as JSON.
@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResources {

    private final AuthorService authorService;

    public AuthorResources(AuthorService authorService) {
        this.authorService = authorService;
    }

    private static final Map<Integer, AuthorEntity> authors = new HashMap<>();
    private static int idCount = 1;

    @GET
    public List<AuthorEntity> getAllAuthors() {
        return new ArrayList<>(authors.values());
    }

    @GET
    @Path("/{id}")
    public AuthorEntity getAuthorById(@PathParam("id") int id) {
        return authors.get(id);
    }

    @POST
    public AuthorEntity addAuthor(AuthorEntity author) {
        author.setId(idCount++);
        authors.put(author.getId(), author);
        return author;
    }

    @POST
    @Path("/Checkauthor")
    @UnitOfWork
    public int postAuthorEntity(@Valid AuthorEntity authorEntity) {
        return authorService.saveAuthor(authorEntity);
    }
}
