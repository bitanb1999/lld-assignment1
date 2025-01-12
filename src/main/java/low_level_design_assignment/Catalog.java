package low_level_design_assignment;

import java.util.*;


class Catalog extends Search {
    private HashMap<String, List<BookItem>> bookTitles = new HashMap<>();
    private HashMap<String, List<BookItem>> bookAuthors = new HashMap<>();
    private HashMap<String, List<BookItem>> bookSubjects = new HashMap<>();
    private HashMap<String, List<BookItem>> bookPublicationDates = new HashMap<>();

    @Override
    public List<BookItem> searchByTitle(String query) {
        return bookTitles.getOrDefault(query, null);
    }

    @Override
    public List<BookItem> searchByAuthor(String query) {
        return bookAuthors.getOrDefault(query, null);
    }

    @Override
    public List<BookItem> searchBySubject(String query) {
        return bookSubjects.getOrDefault(query, null);
    }

    @Override
    public List<BookItem> searchByPubDate(String query) {
        return bookPublicationDates.getOrDefault(query, null);
    }

    // Methods to add books to the catalog
    public void addBookByTitle(String title, BookItem book) {
        bookTitles.computeIfAbsent(title, k -> new ArrayList<>()).add(book);
    }

    public void addBookByAuthor(String author, BookItem book) {
        bookAuthors.computeIfAbsent(author, k -> new ArrayList<>()).add(book);
    }

    public void addBookBySubject(String subject, BookItem book) {
        bookSubjects.computeIfAbsent(subject, k -> new ArrayList<>()).add(book);
    }

    public void addBookByPubDate(String publishDate, BookItem book) {
        bookPublicationDates.computeIfAbsent(publishDate, k -> new ArrayList<>()).add(book);
    }
}

