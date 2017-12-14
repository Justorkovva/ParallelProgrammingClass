package Class8;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	private final BlockingQueue<Integer> queue;
	private final int numberToProduce;
	private Integer productId = 0;

	public Producer(BlockingQueue<Integer> queue, int numberToProduce) {
		this.queue = queue;
		this.numberToProduce = numberToProduce;
	}

	@Override
	public void run() {
		try {
			for (int i=0; i<numberToProduce; i++) {
				Integer x = produce();
				queue.put(x);
			}
		} catch (InterruptedException ex) { }
	}
	
	private Integer produce() {
		Integer x = productId;
		productId++;
		System.out.println("Producing " + x);
		return x;
	}
}
