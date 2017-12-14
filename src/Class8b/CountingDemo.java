package Class8b;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountingDemo {
	public static void main(String args[]) {
		int nRuns = 10;
		CountingRunnable[] myRuns = new CountingRunnable[nRuns];
		for (int i=0; i<nRuns; i++) {
			myRuns[i] = new CountingRunnable();
		}
		ExecutorService service = null;
		
		System.out.println("Starting at " + LocalTime.now());
		
		try {
			int numProcessors = Runtime.getRuntime().availableProcessors();
			service = Executors.newFixedThreadPool(numProcessors);
			for (int i=0; i<nRuns; i++) {
				service.execute(myRuns[i]);
			}
		} finally {
			if (service != null) service.shutdown();
		}
		
		try {
			service.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Counter myCounter = Counter.getInstance();
		System.out.println("Finished at " + LocalTime.now());
		System.out.println("The counter is now: " + myCounter.getCount());
		
	}
}
