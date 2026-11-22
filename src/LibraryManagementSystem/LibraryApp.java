package LibraryManagementSystem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {

	// Attributes

	private ArrayList<Book> libraryBooks = new ArrayList<>();
	private ArrayList<Author> authors = new ArrayList<>();
	private ArrayList<Member> libraryMembers = new ArrayList<>();
	private ArrayList<BorrowRecord> borrowingList = new ArrayList<>();
	private ArrayDeque<BorrowRecord> borrowHistory = new ArrayDeque<>(); // used as a stack

	// One Scanner shared by every method that reads input
	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		LibraryApp app = new LibraryApp(); // create the object that holds all the lists
		app.menu();
	}

	public void menu() {

		int val;

		do {

			// print menu options
			System.out.println();
			System.out.println("===== Library Management System =====");
			System.out.println("[1] Help");
			System.out.println("[2] Data management (add, edit and delete books, authors and members)");
			System.out.println("[3] Search (books, authors, members)");
			System.out.println("[4] Borrow and return");
			System.out.println("[5] Reports (overdue books, member history, waiting list)");
			System.out.println("[6] Quit");

			val = readInt("Enter your choice: ");

			switch (val) {

			case 1:
				help();
				break;

			case 2:
				System.out.println("Data management: coming soon.");
				break;

			case 3:
				System.out.println("Search: coming soon.");
				break;

			case 4:
				System.out.println("Borrow and return: coming soon.");
				break;

			case 5:
				System.out.println("Reports: coming soon.");
				break;

			case 6:
				quit();
				break;

			default:
				System.out.println("Invalid choice. Please enter a number from 1 to 6.");
			}

		} while (val != 6);
	}

	// Reads a whole line and keeps asking until the user types a whole number.
	// Using nextLine() avoids the leftover-Enter problem of nextInt().
	private int readInt(String prompt) {
		while (true) {
			System.out.print(prompt);
			String line = scan.nextLine().trim();
			try {
				return Integer.parseInt(line);
			} catch (NumberFormatException e) {
				System.out.println("\"" + line + "\" is not a number. Try again.");
			}
		}
	}

	public void help() {
		System.out.println();
		System.out.println("===== Help =====");
		System.out.println("1 - Help: shows this explanation of the menu.");
		System.out.println("2 - Data management: add, edit and delete books, authors and members.");
		System.out.println("3 - Search: find books, authors or members by keyword or ID.");
		System.out.println("4 - Borrow and return: borrow a book, return it, or join a book's waiting list.");
		System.out.println("5 - Reports: overdue books, a member's borrowing history and the waiting list.");
		System.out.println("6 - Quit: saves all data and closes the program.");
	}

	public void quit() {
		// TODO: save all data here once FileManager is written, e.g.
		// FileManager.saveAll(this);
		System.out.println("Goodbye!");
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

	public ArrayDeque<BorrowRecord> getBorrowHistory() {
		return borrowHistory;
	}

}
