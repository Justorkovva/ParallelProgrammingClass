package Class2;


public class BankingDemo {
public static void main(String args[]) {
Account myAccount = new Account();

BankClerk t1 = new BankClerk(myAccount);
BankClerk t2 = new BankClerk(myAccount);

t1.start();
t2.start();

try {
t1.join();
t2.join();
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}


System.out.println("The balance is now: " 
+ myAccount.getBalance() + "zl.");

System.out.println("We expect that each clerk has paid in 1000 * 100 = 100 000 zl.");
double totalAmount = 2 * 1000 * 100;
System.out.println("The two clerks have paid in a total of " + 
totalAmount + "zl.");
System.out.println("We are missing "  + (myAccount.getBalance() - 
totalAmount) + "zl.");
}
}