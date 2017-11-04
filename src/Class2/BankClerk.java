package Class2;

public class BankClerk extends Thread {
private Account account;

public BankClerk(Account counter) {
this.account = counter;
}

@Override
public void run() {
doSomeTransfers();
}

private void doSomeTransfers() {
for (int i=0; i< 1000; i++) {
synchronized (account) {
account.credit(100);
}

}
}
}
