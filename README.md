# lld-assignment1
Backend Engineering Launchpad Cohort 10
### Requirements:

#### * Book Management
- Implement a Book class with attributes such as title, author, ISBN, and publication year.
- Create a system to add, remove, and update books in the library inventory.
- Implement a search functionality to find books by title, author, or ISBN.

#### * Patron Management
- Design a Patron class to represent library members.
-  Implement functionality to add new patrons and update their information.
-   Create a system to track patron borrowing history.

#### * Lending Process
- Implement book checkout and return functionalities.

#### * Inventory Management
- Keep track of available and borrowed books.

### Solution:
The LLD-design imagined is as shown in the image
![LLDAssignment drawio](https://github.com/user-attachments/assets/2e07cf73-93b5-405f-8244-f8ba44575c22)


The requirements as identified are:

* Actors:
  - Librarian
  - Patrons
  - Books
    
* Requirements from the Library system
  - To add, remove or modify a book item which is essentially multiple copies of a book.
  - To have a search system that can be used to search for books 
  - To add a new patron or cancel the membership of an existing one.
  - checkout, renew, reserve or return a book.
  - calculate fine if delayed return
  - send return or reservation notifications
    
* OOP concepts implemented
  To ensure the code adheres to the SOLID principles, here are the key changes and principles observed:
    1. **Single Responsibility Principle (SRP)**: Each class in the code has a single responsibility. For example, `Patron` handles member-related operations, `Librarian` handles librarian-specific functions, and `BookItem` deals with book item attributes and operations.
    2. **Open/Closed Principle (OCP)**: The code is open for extension but closed for modification. For example, if we need to add new types of notifications or book formats, we can extend the respective enums or classes without modifying existing code.
    3. **Liskov Substitution Principle (LSP)**: Subclasses or derived classes (`Librarian`, `Patron`) can replace their base class (`Account`) without altering the desired behavior of the program. Each subclass correctly implements or overrides the base class methods.
    4. **Interface Segregation Principle (ISP)**: The code does not impose methods on classes that do not use them. Each interface or abstract class like `Account` only contains methods relevant to the derived classes.
    5. **Dependency Inversion Principle (DIP)**: The code uses abstraction (`Person`, `Account`) to depend on, rather than concrete classes. This allows for flexibility and easier testing.
       
* Strategy Design Pattern immplemented in **Fine Strategy** :
  Defined a Strategy Interface: Created an interface FineStrategy with a method calculateFine.
  Concrete Strategies: Implemented different concrete strategies like RegularFineStrategy and PremiumFineStrategy.
  Context Class (Fine): The Fine class was then implemented to choose a FineStrategy to calculate the fine dynamically.


