package Class10a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ListDemo {
	public static void main(String[] args) {
		
		// change the comment to choose between lists
		ConcurrentList myList = new ConcurrentList();
//		SynchronizedList myList = new SynchronizedList();
		
		int nThreads = 10;
		ExecutorService myService = null;
		
	    long start = System.currentTimeMillis();

		try {
			int numProcessors = Runtime.getRuntime().availableProcessors();
			myService = Executors.newFixedThreadPool(numProcessors);
			for (int i=0; i<nThreads; i++) {
				myService.execute(new Worker(myList));
			}
		} finally {
			if (myService != null) myService.shutdown();
		}
		
		try {
			myService.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    long end = System.currentTimeMillis();
		
		System.out.println(myList);
	    System.out.println("Elapsed time: " + (end - start) + "ms");
	}
}
