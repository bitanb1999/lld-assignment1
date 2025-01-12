package low_level_design_assignment;
import java.util.logging.Logger;
import java.time.*;
public class BookReservation {
    private LocalDate creationDate;
    private ReservationStatus status;
    private String bookItemBarcode;
    private String memberId;

    public BookReservation(LocalDate creationDate, ReservationStatus status, String bookItemBarcode, String memberId) {
        this.creationDate = creationDate;
        this.status = status;
        this.bookItemBarcode = bookItemBarcode;
        this.memberId = memberId;
    }

    public static BookReservation fetchReservationDetails(String barcode) {
        // Fetch reservation details from the database or data source
        return null; // Placeholder for actual implementation
    }

    public String getMemberId() {
        return memberId;
    }

    public void updateStatus(ReservationStatus status) {
        this.status = status;
    }

    public void sendBookAvailableNotification() {
        // Send notification to the member that the book is available
    }
}
