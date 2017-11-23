package Class6b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountingDemo {
	public static void main(String args[]) {
		Counter myCounter = new Counter();
		
		CountingThread r1 = new CountingThread(myCounter);
		CountingThread r2 = new CountingThread(myCounter);
		ExecutorService service = null;
		
		System.out.println("Starting");
		try {
			service = Executors.newFixedThreadPool(2);
			service.execute(r1);
			service.execute(r2);
			service.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}
		System.out.println("The counter is now: " + myCounter.getCount());
		
	}
}
