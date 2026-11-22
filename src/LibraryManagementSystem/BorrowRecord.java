package LibraryManagementSystem;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class BorrowRecord {
    public static final double FINE_PER_DAY = 0.5;
    private final Book borrowedBook;
    private final Member borrower;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;
    public BorrowRecord(Book borrowedBook, Member borrower, LocalDate borrowDate, LocalDate dueDate) {
        this.borrowedBook = borrowedBook;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = null;
    }
    public Book getBorrowedBook() {
        return borrowedBook;
    }
    public Member getBorrower() {
        return borrower;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate date) {
        this.returnDate = date;
    }
    public boolean isOverdue() {
        LocalDate referenceDate = (returnDate != null) ? returnDate : LocalDate.now();
        return referenceDate.isAfter(dueDate);
    }
    public int daysOverdue() {
        if (!isOverdue()) {
            return 0;
        }
        LocalDate referenceDate = (returnDate != null) ? returnDate : LocalDate.now();
        return (int) ChronoUnit.DAYS.between(dueDate, referenceDate);
    }

    public double fine() {
        return daysOverdue() * FINE_PER_DAY;
    }
}
