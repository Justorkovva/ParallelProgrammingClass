package Class4;

public class BadValue extends Value {
	public synchronized int get() {
		return value;
	}
	public synchronized void put(int v) {
		value = v;
	}
}
