
import java.util.ArrayList;
import java.util.List;
public class LibrarySystem {

    private List<User> users;
    private List<Book> books;

    public LibrarySystem() {
        this.users = new ArrayList<>();
        this.books = new ArrayList<>();

    }

    
    public  void addUser(User user) {
        users.add(user);
    }

    public void addBook(Book book) {
        books.add(book);
    }   


    public List<User> getUsers() {
        return users;
    }

    public List<Book> getallBooks() {
        return books;
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
    public List<Book> showBooksBorredByUser(User user) {
        return user.getBorrowedBooks();
    }
    public List<Book> showBooksBorredByUserId(String userId) {

        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user.getBorrowedBooks();
            }
        }
        return new ArrayList<>(); // Return empty list if user not found
       
    }

    public boolean returnBook (String userId, String isbn) {
        User user = null;
        for (User u : users) {
            if (u.getUserId().equals(userId)) {
                user = u;
                break;
            }
        }
        if (user == null) {
            return false; // User not found
        }

        Book bookToReturn = null;
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                bookToReturn = b;
                break;
            }
        }
        if (bookToReturn == null) {
            return false; // Book not found
        }

        if (user.returnBook(bookToReturn)) {
            bookToReturn.returnBook();
            return true;
        }
        return false; // Book was not borrowed by the user
    }

    public boolean borrowBook(String userId, String isbn) {
        User user = null;
        for (User u : users) {
            if (u.getUserId().equals(userId)) {
                user = u;
                break;
            }
        }
        if (user == null) {
            return false; // User not found
        }

        Book bookToBorrow = null;
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                bookToBorrow = b;
                break;
            }
        }
        if (bookToBorrow == null || bookToBorrow.isCheckedOut()) {
            return false; // Book not found or already checked out
        }

        if (user.borrowBook(bookToBorrow)) {
            bookToBorrow.checkOut();
            return true;
        }
        return false; // User has reached max books allowed
    }


}
