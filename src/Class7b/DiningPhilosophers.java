package Class7b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DiningPhilosophers {
	public static void main(String[] args) throws InterruptedException {
		int NUMBER_OF_PHILOSOPHERS = 5;
		Philosopher[] philosophers = new Philosopher[NUMBER_OF_PHILOSOPHERS];
		Chopstick[] chopsticks = new Chopstick[NUMBER_OF_PHILOSOPHERS];
		
		for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
		      chopsticks[i] = new Chopstick(true);
		}

		for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
			int leftNumber = i;
			int rightNumber = (i+1) % NUMBER_OF_PHILOSOPHERS;

			philosophers[i] = new Philosopher(chopsticks[leftNumber], chopsticks[rightNumber]);
		}
		
		ExecutorService service = null;
		int numProcessors = Runtime.getRuntime().availableProcessors();
		int numThreads = numProcessors;
		System.out.println("available processors: " + numProcessors);

		try {
			service = Executors.newFixedThreadPool(numThreads);
			for (Philosopher p: philosophers) {
				service.execute(p);
			}
		} finally {
			if (service != null) service.shutdown();
		}
		
		service.awaitTermination(2,TimeUnit.MINUTES);
		System.out.println("The dinner is finished.");
	}
}
