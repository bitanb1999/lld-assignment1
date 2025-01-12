package low_level_design_assignment;
import java.util.logging.Logger;
import java.time.*;
public class Patron extends Account {
    private LocalDate dateOfMembership;
    private int totalBooksCheckedOut;
    Logger logger = Logger.getLogger(getClass().getName());
    Patron(String id, String password, Person person, AccountStatus status) {
        super(id, password, person, status);
        this.dateOfMembership = LocalDate.now();
        this.totalBooksCheckedOut = 0;
    }

    public int getTotalBooksCheckedOut() {
        return totalBooksCheckedOut;
    }

    public void reserveBookItem(BookItem bookItem) {
        // Implementation for reserving a book item
    }

    public void incrementTotalBooksCheckedOut() {
        this.totalBooksCheckedOut++;
    }

    public boolean checkoutBookItem(BookItem bookItem) {
        if (this.totalBooksCheckedOut >= Constants.MAX_BOOKS_ISSUED_TO_A_USER) {
            logger.info("The user has already checked out the maximum number of books");
            return false;
        }
        BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
        if (bookReservation != null && !bookReservation.getMemberId().equals(this.getId())) {
            logger.info("This book is reserved by another member");
            return false;
        } else if (bookReservation != null) {
            bookReservation.updateStatus(ReservationStatus.COMPLETED);
        }

        if (!bookItem.checkout(this.getId())) {
            return false;
        }

        this.incrementTotalBooksCheckedOut();
        return true;
    }

    public void checkForFine(String bookItemBarcode) {
        BookLending bookLending = BookLending.fetchLendingDetails(bookItemBarcode);
        LocalDate dueDate = bookLending.getDueDate();
        LocalDate today = LocalDate.now();
        if (today.isAfter(dueDate)) {
            long diffDays = Duration.between(dueDate.atStartOfDay(), today.atStartOfDay()).toDays();
            Fine.collectFine(this.getId(), diffDays);
        }
    }

    public void returnBookItem(BookItem bookItem) {
        this.checkForFine(bookItem.getBarcode());
        BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
        if (bookReservation != null) {
            bookItem.updateBookItemStatus(BookStatus.RESERVED);
            bookReservation.sendBookAvailableNotification();
        }
        bookItem.updateBookItemStatus(BookStatus.AVAILABLE);
    }

    public boolean renewBookItem(BookItem bookItem) {
        this.checkForFine(bookItem.getBarcode());
        BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
        if (bookReservation != null && !bookReservation.getMemberId().equals(this.getId())) {
            logger.info("This book is reserved by another member");
            this.totalBooksCheckedOut--;
            bookItem.updateBookItemStatus(BookStatus.RESERVED);
            bookReservation.sendBookAvailableNotification();
            return false;
        } else if (bookReservation != null) {
            bookReservation.updateStatus(ReservationStatus.COMPLETED);
        }

        BookLending.lendBook(bookItem.getBarcode(), this.getId());
        bookItem.updateDueDate(LocalDate.now().plusDays(Constants.MAX_LENDING_DAYS));
        return true;
    }
}
