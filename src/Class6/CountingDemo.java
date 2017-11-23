package Class6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountingDemo {
	public static void main(String args[]) {
		Counter myCounter = new Counter();
		
		CountingRunnable r1 = new CountingRunnable(myCounter);
		CountingRunnable r2 = new CountingRunnable(myCounter);
		ExecutorService service = null;
		
		System.out.println("Starting");
		try {
			service = Executors.newFixedThreadPool(2);
			service.execute(r1);
			service.execute(r2);
			service.awaitTermination(10, TimeUnit.SECONDS); //works like a join method
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			service.shutdown(); //always 
		}
		System.out.println("The counter is now: " + myCounter.getCount());
		
	}
}
