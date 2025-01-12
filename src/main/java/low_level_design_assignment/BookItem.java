package low_level_design_assignment;
import java.time.*;
import java.util.logging.Logger;
public class BookItem extends Book {
    private String barcode;
    private boolean isReferenceOnly;
    private boolean borrowed;
    private LocalDate dueDate;
    private double price;
    private BookFormat bookFormat;
    private BookStatus status;
    private LocalDate dateOfPurchase;
    private LocalDate publicationDate;
    private String placedAt;

    BookItem(String numISBN, String title, String subject, String publisher, String language, int numberOfPages,
                    String barcode, boolean isReferenceOnly, boolean borrowed, LocalDate dueDate, double price,
                    BookFormat bookFormat, BookStatus status, LocalDate dateOfPurchase, LocalDate publicationDate,
                    String placedAt) {
        super(numISBN, title, subject, publisher, language, numberOfPages);
        this.barcode = barcode;
        this.isReferenceOnly = isReferenceOnly;
        this.borrowed = borrowed;
        this.dueDate = dueDate;
        this.price = price;
        this.bookFormat = bookFormat;
        this.status = status;
        this.dateOfPurchase = dateOfPurchase;
        this.publicationDate = publicationDate;
        this.placedAt = placedAt;
    }

    public boolean checkout(String memberId) {
        if (isReferenceOnly) {
            Logger.getLogger(BookItem.class.getName()).info( "This book is Reference only and can't be issued");
            return false;
        }
        // Assuming BookLending.lendBook is a static method
        if (!BookLending.lendBook(barcode, memberId)) {
            return false;
        }
        updateBookItemStatus(BookStatus.LOANED);
        return true;
    }

    public void updateBookItemStatus(BookStatus status) {
        this.status = status;
    }

    public void updateDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public String getBarcode() {
        return barcode;
    }

    // Additional getters and setters as needed
}

