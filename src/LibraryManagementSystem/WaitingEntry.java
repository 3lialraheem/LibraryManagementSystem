package LibraryManagementSystem;
import java.time.LocalDateTime;
public class WaitingEntry implements Comparable<WaitingEntry> {
	
	private final Member member;
	private final Book book; 
	private final LocalDateTime waitingDate; // date AND time, so two entries on the same day still have an order

	public WaitingEntry(Member member, Book book) {
		this(member, book, LocalDateTime.now());
	}

	
	public WaitingEntry(Member member, Book book, LocalDateTime waitingDate) {
		if (member == null) {
			System.out.println("Member cannot be null.");
		}
		if (book == null) {
			System.out.println("Book cannot be null.");
		}
		if (waitingDate == null) {
			System.out.println("Waiting date cannot be null.");
		}
		this.member = member;
		this.book = book;
		this.waitingDate = waitingDate;
	}


	// the book on the waiting list
	public Book getBook() {
		return book;
	}

	// the member who is waiting
	public Member getMember() {
		return member;
	}

	// when the member joined the waiting list
	public LocalDateTime getWaitingDate() {
		return waitingDate;
	}

	// Smaller = served first.
	@Override
	public int compareTo(WaitingEntry other) {
		int result = Integer.compare(member.getPriority(), other.member.getPriority());
		if (result != 0) {
			return result; // Premium (1) before regular (2)
		}
		result = waitingDate.compareTo(other.waitingDate);
		if (result != 0) {
			return result; // waited longer = first
		}
		return Integer.compare(member.getId(), other.member.getId());
	}

	// Two entries are the same if the same member waits for the same book.
	// This lets the program use contains() to stop a member joining twice,
	// and remove(entry) to take someone off the waiting list.
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof WaitingEntry)) {
			return false;
		}
		WaitingEntry other = (WaitingEntry) obj;
		return member.getId() == other.member.getId() && book.getIsbn().equals(other.book.getIsbn());
	}

	@Override
	public int hashCode() {
		return 31 * member.getId() + book.getIsbn().hashCode();
	}

	// One line of waiting.txt (saved by ID): isbn|memberId|waitingDate
	public String toFileString() {
		return book.getIsbn() + "|" + member.getId() + "|" + waitingDate;
	}

	
	@Override
	public String toString() {
		String type = (member.getPriority() == 1) ? "Premium" : "Regular";
		return member.getName() + " (" + type + ") waiting for " + book.getTitle() + " since "
				+ waitingDate.toLocalDate();
	}
}


	