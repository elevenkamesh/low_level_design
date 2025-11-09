
public class Main {
    public static void main(String[] args) {

        LibrarySystem system = new LibrarySystem();

        // Create users
        User u1 = new User("Kamesh", "U1", 2);
        User u2 = new User("Arun", "U2", 1);

        system.addUser(u1);
        system.addUser(u2);

        // Create books
        Book b1 = new Book("The Hobbit", "Tolkien", "ISBN101");
        Book b2 = new Book("Clean Code", "Robert Martin", "ISBN102");
        Book b3 = new Book("Atomic Habits", "James Clear", "ISBN103");

        system.addBook(b1);
        system.addBook(b2);
        system.addBook(b3);

        // Borrow some books
        System.out.println("Borrowing Tests:");
        System.out.println("U1 borrows ISBN101 -> " + system.borrowBook("U1", "ISBN101"));
        System.out.println("U1 borrows ISBN102 -> " + system.borrowBook("U1", "ISBN102"));
        System.out.println("U1 borrows ISBN103 -> " + system.borrowBook("U1", "ISBN103")); // should fail, limit = 2

        System.out.println();

        // Show available books
        System.out.println("Available Books:");
        for (Book book : system.getAvailableBooks()) {
            System.out.println(book.getTitle());
        }

        System.out.println();

        // Show borrowed by user
        System.out.println("Books borrowed by U1:");
        for (Book book : system.showBooksBorredByUserId("U1")) {
            System.out.println(book.getTitle());
        }

        System.out.println();

        // Return a book
        System.out.println("Return Tests:");
        System.out.println("U1 returns ISBN101 -> " + system.returnBook("U1", "ISBN101"));

        System.out.println();

        // Show available again
        System.out.println("Available Books After Returning:");
        for (Book book : system.getAvailableBooks()) {
            System.out.println(book.getTitle());
        }
    }
}
