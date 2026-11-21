package LibraryManagementSystem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class LibraryApp {

	//Ali Jawad

	// Attributes

	public static final double FINE_PER_DAY = 0.5;

	private ArrayList<Book> libraryBooks = new ArrayList<>();
	private ArrayList<Author> authors = new ArrayList<>();
	private ArrayList<Member> libraryMembers = new ArrayList<>();
	private ArrayList<BorrowRecord> borrowingList = new ArrayList<>();
	private PriorityQueue<WaitingEntry> waitingList = new PriorityQueue<>();
	private ArrayDeque<BorrowRecord> borrowHistory = new ArrayDeque<>(); // used as a stack

	
	
}
