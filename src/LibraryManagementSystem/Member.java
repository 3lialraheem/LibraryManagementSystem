package LibraryManagementSystem;

import java.time.LocalDate;

public class Member extends Person {
	
	private String phone;
	private String email;
	private final LocalDate joinDate;
	private int activeBorrowings;
	private int totalBorrowings;
	
	public Member(int id, String name, String phone, String email, LocalDate joinDate) {
		
		super(id, name);
		this.phone = phone;
		this.email = email;
		this.joinDate = joinDate;
		this.activeBorrowings = 0;
		this.totalBorrowings = 0;
	}
	
	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public int getActiveBorrowings() {
		return activeBorrowings;
	}

	public int getTotalBorrowings() {
		return totalBorrowings;
	}

	public void updatePhone(String newPhone) {
		this.phone = newPhone;
	}
	
	public void updateEmail(String newEmail) {
		this.email = newEmail;
	}
	
	// Methods
	
	public int getPriority() {
		return 2; 
	}
	
	public int getBorrowLimit() {
		return 3; 
	}
	
	public int getBorrowDays() {
		return 15;
	}
	
	public boolean canBorrow() {
		if (activeBorrowings < getBorrowLimit()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void addBorrow() {
		if (canBorrow()) {
			activeBorrowings++;
			totalBorrowings++;
		}
		else {
			System.out.println("This user reached the borrwoing limit");
		}
	}
	
	public void addReturn() {
		if (activeBorrowings > 0) {
			activeBorrowings--;
		}
		else {
			System.out.println("This user has no books to return");
		}
	}
	
}
