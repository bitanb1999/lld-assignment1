package low_level_design_assignment;
import java.time.*;
public class Fine {
private LocalDate creationDate;
private String bookItemBarcode;
private String memberId;

public Fine(LocalDate creationDate, String bookItemBarcode, String memberId) {
    this.creationDate = creationDate;
    this.bookItemBarcode = bookItemBarcode;
    this.memberId = memberId;
}

public static void collectFine(String memberId, long days) {
    // Collect fine from the member based on the number of overdue days
}
}
