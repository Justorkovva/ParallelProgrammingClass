package Class7;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountingDemo {
	public static void main(String args[]) {
		Counter myCounter = new Counter();
		
		CountingRunnable r1 = new CountingRunnable(myCounter);
		CountingRunnable r2 = new CountingRunnable(myCounter);
		ExecutorService service = null;
		
		System.out.println("Starting at " + LocalTime.now());
		
		try {
			service = Executors.newFixedThreadPool(2);
			service.execute(r1);
			service.execute(r2);
		} finally {
			if (service != null) service.shutdown();
		}
		
		try {
			service.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Finished at " + LocalTime.now());
		System.out.println("The counter is now: " + myCounter.getCount());
		
	}
}
