package Class9;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
	private final ReentrantLock myLock = new ReentrantLock();
	private int count = 0;

	private Counter() {};
	private static volatile Counter instance;

	public static Counter getInstance() {
		if (instance == null) {
			synchronized(Counter.class) {
				if (instance == null) {
					instance = new Counter();
				}
			}
		}
		return instance;
	}
	
	public void increment() { 
		myLock.lock();
		try {
			count++;
		} finally {
			myLock.unlock();			
		}
	}
	public int getCount() {
		return count;
	}
}
