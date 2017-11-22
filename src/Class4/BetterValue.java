package Class4;

public class BetterValue extends Value {
	private boolean available = false;
	public synchronized int get() {
		while (!available) {
			try {
				wait();
			}
			catch (InterruptedException e) {
			}
		}
		available = false;
		notifyAll();
		return value;
	}
	public synchronized void put (int v) {
		while (available) {
			try {
				wait();
			}
			catch (InterruptedException e) {
			}
		}
		value = v;
		available = true;
		notifyAll();
	}
}