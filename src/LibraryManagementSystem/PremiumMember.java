package LibraryManagementSystem;

import java.time.LocalDate;

public class PremiumMember extends Member{
	
	private LocalDate subscriptionEnd;

	public PremiumMember(int id, String name, String phone, String email, LocalDate joinDate,
			LocalDate subscriptionEnd) {
		super(id, name, phone, email, joinDate);
		this.subscriptionEnd = subscriptionEnd;
	}

	public LocalDate getSubscriptionEnd() {
		return subscriptionEnd;
	}
	
	@Override
	public int getPriority() {
		return 1;
	}

	@Override
	public int getBorrowLimit() {
		return 6;
	}

	@Override
	public int getBorrowDays() {
		return 30;
	}

	public boolean isSubActive() {
        return LocalDate.now().isBefore(subscriptionEnd);
    }
	
	public void renewSubscription(int months) {
        subscriptionEnd = subscriptionEnd.plusMonths(months);
    }
}
