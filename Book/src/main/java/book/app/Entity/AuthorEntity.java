package book.app.Entity;

import jakarta.persistence.*;

public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


//    Maps the next field (name) to the "author_name" column in the database.
    @Column(name = "author_name")
    private String name;

    // ----- Getters -----

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // ----- Setters -----

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
