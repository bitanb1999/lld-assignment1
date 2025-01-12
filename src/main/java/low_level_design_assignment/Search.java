package low_level_design_assignment;

import java.util.HashMap;
import java.util.List;

abstract class Search {
    public abstract List<BookItem> searchByTitle(String title);

    public abstract List<BookItem> searchByAuthor(String author);

    public abstract List<BookItem> searchBySubject(String subject);

    public abstract List<BookItem> searchByPubDate(String publishDate);
}

