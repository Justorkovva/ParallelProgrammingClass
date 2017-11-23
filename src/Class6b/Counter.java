package Class6b;

public class Counter {
	private int count = 0;
	public synchronized void increment() { count++; }
	public synchronized int getCount() {
		return count;
	}
}
