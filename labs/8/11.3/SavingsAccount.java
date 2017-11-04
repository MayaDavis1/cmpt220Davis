//11.3
class SavingsAccount extends Account {
    
	public SavingsAccount(int id, double balance) {
    	  super(id, balance);
    }
	
	@Override
	public void withdraw(double wAmount) {
      // Cannot overdrawn	
	  if (balance - wAmount >= 0)   
		super.withdraw(wAmount);
	}
    
    @Override
    public String toString() {
      return "Savings account balance is: " + getBalance();

    }
}    