//11.3
public class CheckingAccount extends Account {
    
	protected double OVERDRAFT_LIMIT = 300;  
	
	public CheckingAccount(int id, double balance) {
      super(id, balance);     
    	}
	
	
	@Override
	public void withdraw(double wAmount) {
      // If within over draft limit, allow withdraw		
	  if (balance - wAmount < OVERDRAFT_LIMIT)  
		super.withdraw(wAmount);
	}
	
	
	@Override
	public String toString() {
      return "Checking account balance is: " + getBalance();
	}
  
}