package Class8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Setup {

	public static void main(String[] args) {
		int myCapacity = 20;
		BlockingQueue<Integer> myQueue = new ArrayBlockingQueue<Integer>(myCapacity);
		
		// in total we will produce 16 = 4 * 4 products
		int numberOfProducers = 4;
		int numberOfProductsForEachProducer = 4;

		// in total we will consume 16 = 2 * 8 products
		int numberOfConsumers = 2;
		int numberOfProductsForEachConsumer = 8;

		Producer[] prods = new Producer[numberOfProducers];
		Consumer[] cons = new Consumer[numberOfConsumers];

		ExecutorService myPool = null;

		try {
			myPool = Executors.newFixedThreadPool(4);
			
			for (int i=0; i<numberOfProducers; i++) {
				prods[i] = new Producer(myQueue, numberOfProductsForEachProducer);
				myPool.execute(prods[i]);
				System.out.println("Producer " + i + " is now in the thread pool.");
			}
			
			for (int i=0; i<numberOfConsumers; i++) {
				cons[i] = new Consumer(myQueue, numberOfProductsForEachConsumer);
				myPool.execute(cons[i]);
				System.out.println("Consumer " + i + " is now in the thread pool.");
			}			
		} finally {
			if (myPool != null) { 
				myPool.shutdown();
			}			
		}
		
		try {
			myPool.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All done! Good bye!");
	}

}
