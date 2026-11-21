package LibraryManagementSystem;
import java.util.PriorityQueue;
public class Book {
    private String title;
    private final String isbn;
    private Author author;
    private int pages;
    private int year;
    private int availableCopies;
    private final PriorityQueue<WaitingEntry> waitingList;
    public Book(String isbn, String title, Author author, int pages, int year, int availableCopies) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN cannot be empty.");
        }
        if (pages < 1) {
            throw new IllegalArgumentException("Pages must be at least 1.");
        }
        if (availableCopies < 0) {
            throw new IllegalArgumentException("Available copies cannot be negative.");
        }
        this.isbn = isbn.trim();
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
        this.availableCopies = availableCopies;
        this.waitingList = new PriorityQueue<>();
        if (author != null) {
            author.addBook(this);
        }
    }
    public String getTitle() {
        return title;
    }
    public String getIsbn() {
        return isbn;
    }
    public Author getAuthor() {
        return author;
    }
    public int getPages() {
        return pages;
    }
    public int getYear() {
        return year;
    }
    public int getAvailableCopies() {
        return availableCopies;
    }
    public PriorityQueue<WaitingEntry> getWaitingList() {
        return waitingList;
    }
    public void updateTitle(String title) {
        if (title != null && !title.isBlank()) {
            this.title = title.trim();
        }
    }
    public void updatePages(int pages) {
        if (pages < 1) {
            throw new IllegalArgumentException("Pages must be at least 1.");
        }
        this.pages = pages;
    }
    public void updateYear(int year) {
        this.year = year;
    }
    public void setAuthor(Author author) {
        this.author = author;
        if (author != null) {
            author.addBook(this);
        }
    }
    public boolean isAvailable() {
        return availableCopies > 0;
    }
    public void decreaseCopies() {
        if (availableCopies <= 0) {
            throw new IllegalStateException("No available copies left to decrease for ISBN: " + isbn);
        }
    }
    public void increaseCopies() {
    }
    public String toFileString() {
        int authorId = (author != null) ? author.getId() : -1;
        return isbn + "|" + title + "|" + authorId + "|" + pages + "|" + year + "|" + availableCopies;
    }
}
