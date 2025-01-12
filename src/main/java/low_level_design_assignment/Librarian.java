package low_level_design_assignment;

public class Librarian extends Account {
    Librarian(String id, String password, Person person, AccountStatus status) {
        super(id, password, person, status);
    }

    public void addBookItem(BookItem bookItem) {
        // Implementation for adding a book item
    }

    public void blockMember(Patron member) {
        // Implementation for blocking a member
    }

    public void unblockMember(Patron member) {
        // Implementation for unblocking a member
    }
}
