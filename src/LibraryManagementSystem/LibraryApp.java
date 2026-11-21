package LibraryManagementSystem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LibraryApp {

	// Ali Jawad

	// Attributes

	public static final double FINE_PER_DAY = 0.5;

	private ArrayList<Book> libraryBooks = new ArrayList<>();
	private ArrayList<Author> authors = new ArrayList<>();
	private ArrayList<Member> libraryMembers = new ArrayList<>();
	private ArrayList<BorrowRecord> borrowingList = new ArrayList<>();
	private PriorityQueue<WaitingEntry> waitingList = new PriorityQueue<>();
	private ArrayDeque<BorrowRecord> borrowHistory = new ArrayDeque<>(); // used as a stack

	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
	}

	public static void menu() {

		int val;

		do {

			// print menu options

			System.out.println("[1] Help");
			System.out.println("[2] Data management (add, edit and delete books, authors and members)");
			System.out.println("[3] Search (books, authors, members)");
			System.out.println("[4] Borrow and return");
			System.out.println("[5] Reports (overdue books, member history, waiting list)");
			System.out.println("[6] Quit");

			val = scan.nextInt();

			switch (val) {

			case 1:

				break;

			case 2:

				break;

			case 3:

				break;

			case 4:

				break;

			case 5:

				break;

			case 6:

				break;

			default:

			}
		} while (val != 6);

	}

	public ArrayList<Book> getLibraryBooks() {
		return libraryBooks;
	}

	public ArrayList<Author> getAuthors() {
		return authors;
	}

	public ArrayList<Member> getLibraryMembers() {
		return libraryMembers;
	}

	public ArrayList<BorrowRecord> getBorrowingList() {
		return borrowingList;
	}

	public PriorityQueue<WaitingEntry> getWaitingList() {
		return waitingList;
	}

	public ArrayDeque<BorrowRecord> getBorrowHistory() {
		return borrowHistory;
	}

}
