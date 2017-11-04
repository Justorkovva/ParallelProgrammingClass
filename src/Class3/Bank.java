package Class3;

public class Bank {

	public static void main(String[] args) {
		Bank_Account accountA = new Bank_Account(1);
		Bank_Account accountB = new Bank_Account(2);
		
		for (int i = 0; i < 100; i++) {
			BankClerk t1 = new BankClerk(accountA, accountB, 10.00);
			BankClerk t2 = new BankClerk(accountB, accountA, 10.00);
			t1.start();
			t2.start();
			
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {}
		}
		
		System.out.println("On my account are: "); 
		System.out.println("A: "+ accountA.balance + " zl.");
		System.out.println("B: "+ accountB.balance + " zl.");
	}
}


