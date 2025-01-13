package low_level_design_assignment;

import java.util.HashMap;
import java.util.List;

public interface Search {
    public List<BookItem> searchByTitle(String title);

    public List<BookItem> searchByAuthor(String author);

    public List<BookItem> searchBySubject(String subject);

    public List<BookItem> searchByPubDate(String publishDate);
}

