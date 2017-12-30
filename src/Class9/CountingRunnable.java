package Class9;

public class CountingRunnable implements Runnable {
	@Override
	public void run() {
		Counter counter = Counter.getInstance();
		for (int i=0; i< 10000; i++) {
			counter.increment();
		}
	}
}
