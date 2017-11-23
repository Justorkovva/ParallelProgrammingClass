package Class6b;

public class CountingThread extends Thread {
	Counter counter;

	public CountingThread(Counter counter) {
		this.counter = counter;
	}
	
	@Override
	public void run() {
		for (int i=0; i< 10000; i++) {
			counter.increment();
		}
	}
}
