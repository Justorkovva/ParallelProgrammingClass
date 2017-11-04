package Class2;


public class CountingDemo {
public static void main(String args[]) {
Counter myCounter = new Counter();

CountingThread t1 = new CountingThread(myCounter);
CountingThread t2 = new CountingThread(myCounter);

t1.start();
t2.start();

///join added to wait for thread to finish before getting count

try {
t1.join();
t2.join();
} catch (InterruptedException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

System.out.println("The counter is now: " 
+ myCounter.getCount());
}
}

