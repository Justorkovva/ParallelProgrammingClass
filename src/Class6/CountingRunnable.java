package Class6;

public class CountingRunnable implements Runnable {
	Counter counter;

	public CountingRunnable(Counter counter) {
		this.counter = counter;
	}
	
	@Override
	public void run() {
		for (int i=0; i< 10000; i++) {
			counter.increment();
		}
	}
}
