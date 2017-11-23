package Class6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DiningPhilosophers {
	public static void main(String[] args) {
		int NUMBER_OF_PHILOSOPHERS = 5;
		Philosopher[] philosophers = new Philosopher[NUMBER_OF_PHILOSOPHERS];
		Chopstick[] chopsticks = new Chopstick[NUMBER_OF_PHILOSOPHERS];
		ExecutorService service = null;
		
		for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
		      chopsticks[i] = new Chopstick(i);
		}
		
		int numProcessors = Runtime.getRuntime().availableProcessors();
		int numThreads = numProcessors;
		System.out.println("available processors: " + numProcessors);
		
		try {
			service = Executors.newFixedThreadPool(numThreads);

			for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
				int leftNumber = i;
				int rightNumber = (i+1) % NUMBER_OF_PHILOSOPHERS;

				philosophers[i] = new Philosopher(chopsticks[leftNumber], chopsticks[rightNumber]);
				service.execute(philosophers[i]);
			}
			service.awaitTermination(2, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			service.shutdown();
		}

		System.out.println("The dinner is finished.");
	}
}
