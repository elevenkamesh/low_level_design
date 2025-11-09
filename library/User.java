
import java.util.ArrayList;
public class User {
    private String name;
    private String userId;
    private int maxBooksAllowed;
    private ArrayList<Book> borrowedBooks;

    public User(String name, String userId, int maxBooksAllowed) {
        this.name = name;
        this.userId = userId;
        this.maxBooksAllowed = maxBooksAllowed;
        this.borrowedBooks = new ArrayList<>();
        
    }
    public String getName() {
        return this.name;
    }
    public String getUserId() {
        return this.userId;
    }
    public int getMaxBooksAllowed() {
        return this.maxBooksAllowed;
    }
    public  ArrayList<Book> getBorrowedBooks() {
        return this.borrowedBooks;
    }
    public boolean borrowBook(Book book) {

        if( this.borrowedBooks.size() < this.maxBooksAllowed ) {
            this.borrowedBooks.add(book);
            return true;
        }
        return false; // No space to borrow more books
    }
    public boolean returnBook(Book book) {
        return this.borrowedBooks.remove(book);
    }
}
