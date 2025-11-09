public class Book {
    private String title; 
    private String author;
    private String isbn;
    private boolean isCheckedOut;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isCheckedOut = false;
    }

    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getIsbn() {
        return this.isbn;
    }   
    public boolean isCheckedOut() {
        return this.isCheckedOut;
    }

    public void checkOut() {
        this.isCheckedOut = true;
    }

    public void returnBook() {
        this.isCheckedOut = false;
    }
}
