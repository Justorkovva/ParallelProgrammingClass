package Class7;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
	private final ReentrantLock myLock = new ReentrantLock();
	private int count = 0;
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
