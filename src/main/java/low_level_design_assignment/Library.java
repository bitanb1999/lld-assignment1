import java.util.*;

public class Library {
    private String name;
    private Address address;
    private List<Book> books;
    private List<Author> authors;
    private List<Patron> patrons;
    private Librarian librarian;

    public Library(String name, Address address, Librarian librarian) {
        this.name = name;
        this.address = address;
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.patrons = new ArrayList<>();
        this.librarian = librarian;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    public void setPatrons(List<Patron> patrons) {
        this.patrons = patrons;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Add a new author to the library
    public void addAuthor(Author author) {
        authors.add(author);
    }

    // Add a new patron to the library
    public void addPatron(Patron patron) {
        patrons.add(patron);
        librarian.createAccountForPatron(patron);
    }

    // Remove a patron from the library
    public void removePatron(Patron patron) {
        patrons.remove(patron);
        librarian.removeAccountForPatron(patron);
    }

    // Find a book by its ISBN
    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getISBN().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // Find books by author name
    public List<Book> findBooksByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                result.add(book);
            }
        }
        return result;
    }

    // Find books by title
    public List<Book> findBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }
}
