//11.3 - 
public class TestAccountClass {    
  public static void main(String[] args) { 

    // A test program that creates objects of Account, savingsAcount, and CheckingAccount
    // and invokes their toString() methods 
		
	// ID: 1122, Balance 20,000, Interest rate 4.5%
	Account account = new Account(1122, 20000, 0.045);
	CheckingAccount ckAccount = new CheckingAccount(2222, 1000);
	SavingsAccount svAccount = new SavingsAccount(3322, 6000);
	 
	//Print account number and balance 
	System.out.println(account);

	//Print checking account number and balance
	System.out.println("CheckingAccount: " + ckAccount.toString());
	
	//Print savings account number and balance 
	System.out.println("SavingsAccount: " + svAccount.toString());
		
  }

}