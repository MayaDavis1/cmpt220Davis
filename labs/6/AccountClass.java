//9.7
import java.util.Date;

public class AccountClass {
	public static void main(String[] args) {
		// ID: 1122, Balance 20,000, Interest rate 4.5%
		Account account = new Account(1122, 20000, 0.045);
		// Withdraw 2,500
		account.withdraw(2500);
		// Deposit 3,000
		account.deposit(3000);
		//To get date
		Date currentTime = new Date();
		// Output
		System.out.println("Balance after withdrawing $2,500 and depositing $3,000 is: " + account.getBalance());
		System.out.println("The monthly interest is: " + account.getMonthlyInterestRate());
		System.out.println("This account was created: " + currentTime.toString());
	}
}
     class Account {
		private int id = 0;
		private double balance = 0;
		private double annualInterestRate = 0;
		private java.util.Date dateCreated;
		
		// Default
		public Account() {
		}
		
	public Account(int id1, double balance1, double annualInterestRate1) {
		this.id= id1;
		this.balance = balance1;
		this.annualInterestRate = annualInterestRate1;
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int newId) {
		id = newId;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance (double newBalance) {
		balance = newBalance;
	}
	
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	
	public void setAnnualInterestRate(double newAnnualInterestRate) {
		annualInterestRate = newAnnualInterestRate;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Date newDateCreated) {
		dateCreated = newDateCreated;
	}
	
	public double getMonthlyInterestRate() {
		double monthlyInterestRate = annualInterestRate / 12;
		double monthlyInterest = balance * monthlyInterestRate;
		return monthlyInterest;
	}
	
	public void deposit(double depositAmount) {
		this.balance = balance + depositAmount;
	}
	
	public void withdraw(double withdrawAmount) {
		this.balance = balance - withdrawAmount;	
	}
	
	
}

