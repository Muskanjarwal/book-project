package book.app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name= "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="book_title")
    private String title;

    @Column(name = "author_id")
    private int authorId;

    // ----- Getters -----

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getAuthorId() {
        return authorId;
    }

    // ----- Setters -----

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}

