package Class7b;

import java.util.concurrent.locks.ReentrantLock;

public class Chopstick extends ReentrantLock {
	public Chopstick(boolean fair) {
		super(fair);
	}
}
