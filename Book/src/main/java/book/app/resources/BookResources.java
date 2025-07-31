package book.app.resources;

import book.app.Entity.BookEntity;

import book.app.service.BookService;
import io.dropwizard.hibernate.UnitOfWork;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/bookResource")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResources {

    private final BookService bookService;

    public BookResources(BookService bookService) {
        this.bookService = bookService;
    }

    private static final Map<Integer, BookEntity> books = new HashMap<>();
    private static int idCount = 1;

    // GET - get all books (in-memory data)
    @GET
    public List<BookEntity> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    // POST - add new book (in-memory data)
    @POST
    public BookEntity addBook(BookEntity book) {
        book.setId(idCount++);
        books.put(book.getId(), book);
        return book;
    }

    // GET - books by author ID (in-memory data)
    @GET
    @Path("/author/{authorId}")
    public List<BookEntity> getBooksByAuthorId(@PathParam("authorId") int authorId) {
        List<BookEntity> result = new ArrayList<>();
        for (BookEntity book : books.values()) {
            if (book.getAuthorId() == authorId) {
                result.add(book);
            }
        }
        return result;
    }

    // POST - save book entity to database via BookService
    @POST
    @Path("/Checkbook")
    @UnitOfWork
    public int postReview(@Valid BookEntity bookEntity) {
        return bookService.saveBook(bookEntity);
    }
}
