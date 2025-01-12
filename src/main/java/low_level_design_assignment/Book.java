package low_level_design_assignment;

import java.util.*;

abstract class Book {
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private List<String> authors;

    public Book(String ISBN, String title, String subject, String publisher, String language, int numberOfPages) {
        this.ISBN = ISBN;
        this.title = title;
        this.subject = subject;
        this.publisher = publisher;
        this.language = language;
        this.numberOfPages = numberOfPages;
        this.authors = new ArrayList<>();
    }

    // Getters and setters for the fields can be added as needed
}
