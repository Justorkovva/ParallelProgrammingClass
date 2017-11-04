package Class3;
public class BankClerk  extends Thread {
	private Bank_Account	accountFROM;
	private Bank_Account	accountTO;
	private double	amount;

	public BankClerk(Bank_Account accountFROM, 
			Bank_Account accountTO, double amount) {
		
		this.accountFROM = accountFROM;
		this.accountTO = accountTO;
		this.amount = amount;
	}
	
	public void run() {
		drinkSomeCoffee();
		synch();
	}
	
	private void transfer() {
		
			double balanceFROM = accountFROM.balance - amount;
			double balanceTO = accountTO.balance + amount;
			drinkSomeCoffee();
			accountFROM.balance = balanceFROM;
			drinkSomeCoffee();
			accountTO.balance = balanceTO;		
	
		
	
	}
	private void synch(){
		if(accountFROM.getAccountNumber()>accountTO.getAccountNumber())
		{synchronized(accountTO) {synchronized (accountFROM) {
			transfer();	
		}}}
		else {synchronized(accountFROM) {synchronized (accountTO) {
			transfer();	
		}}}
		
	
	}
	
	
	private void drinkSomeCoffee() {
		try {
			sleep((int) Math.random()*100);
		} catch (InterruptedException e) { }		
	}
}
