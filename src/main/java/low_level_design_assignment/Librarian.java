package low_level_design_assignment;

public class Librarian extends Account {
    Librarian(String id, String password, Person person, AccountStatus status) {
        super(id, password, person, status);
    }

    public void addBookItem(BookItem bookItem) {
        // Implementation for adding a book item
    }

    public void blockMember(Patron patron) {
        // Implementation for blocking a member
    }

    public void unblockMember(Patron patron) {
        // Implementation for unblocking a member
    }
    public void createAccountForPatron(Patron patron) {
        // Implementation for creating an account for a patron
        System.out.println("Account created for patron: " + patron.getId());
    }

    public void removeAccountForPatron(Patron patron) {
        // Implementation for removing an account for a patron
        System.out.println("Account removed for patron: " + patron.getId());
    }
}
