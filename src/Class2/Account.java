package Class2;
public class Account {

private int accountNumber;
private double balance;

public Account() {
accountNumber = 0;
balance = 0;
}

public Account(int accountNumber) {
this.accountNumber = accountNumber;
balance = 0;
}

public Account(int accountNumber, double balance) {
this.accountNumber = accountNumber;
this.balance = balance;
}

public void setAccountNumber(int accountNumber) {
this.accountNumber = accountNumber;
}

public int getAccountNumber() {
return accountNumber;
}

public void setBalance(double balance) {
this.balance = balance;
}

public double getBalance() {
return balance;
}

public void credit(double amount) {
balance += amount;
}

public void debit(double amount) {
balance -= amount;
}

@Override
public String toString() {
return "Account " + accountNumber + " balance " + 
balance;
}

}

