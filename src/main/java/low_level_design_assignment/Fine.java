package low_level_design_assignment;
import java.time.*;
public class Fine {
private LocalDate creationDate;
private String bookItemBarcode;
private String memberId;
private FineStrategy fineStrategy;

public Fine(LocalDate creationDate, String bookItemBarcode, String memberId,FineStrategy fineStrategy) {
    this.creationDate = creationDate;
    this.bookItemBarcode = bookItemBarcode;
    this.memberId = memberId;
    this.fineStrategy = fineStrategy;
}
 public void setFineStrategy(FineStrategy fineStrategy) {
    this.fineStrategy = fineStrategy;
}

public void collectFine(String memberId, long overdueDays) {
        double fineAmount = fineStrategy.calculateFine(overdueDays);
        System.out.println("Collected fine of $" + fineAmount + " from member " + memberId);
        // Actual implementation to collect fine
    }
}



