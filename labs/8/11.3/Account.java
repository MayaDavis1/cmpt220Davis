//11.3
import java.util.Date;
// 11.3 Account class 
//      updated from 9.7
public class Account {
    protected int id = 0;
    protected double balance = 0;
    protected double annualInterestRate = 0;
	protected java.util.Date dateCreated;
				  
	// Default constructor 
    public Account() {
    }
				  
	// Construct an account with specified id, balance, and annual interest rate
    public Account(int id1, double balance1, double annualInterestRate1) {
	  this.id = id1;
	  this.balance = balance1;
	  this.annualInterestRate = annualInterestRate1;
	}

    // 11.3
    Account(int id, double balance) {
  	  this.id = id;
  	  this.balance = balance;
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
					 
	public double getMonthlyInterest() {
	  // Calculate monthly interest  
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
		  
	//11.3 -----------------------------------------
	@Override
	public String toString() {
	  return "Account number: " + id + "\n" +
	         "Interest rate: " + annualInterestRate;		  
	}
	
}