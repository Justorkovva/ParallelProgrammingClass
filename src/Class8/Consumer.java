package Class8;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private BlockingQueue<Integer> queue;
	private final int numberToConsume;
	
	public Consumer(BlockingQueue<Integer> queue, int numberToConsume) {
		this.queue = queue;
		this.numberToConsume = numberToConsume;
	}

	@Override
	public void run() {
		try {
			for (int i=0; i<numberToConsume; i++) {
				Integer x;
				x = queue.take();
				consume(x);
			}
		} catch (InterruptedException e) {}
	}
	
	private void consume(Integer x) {
		System.out.println("Consuming " + x);
	}
}
