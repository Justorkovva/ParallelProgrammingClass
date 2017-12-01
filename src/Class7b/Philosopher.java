package Class7b;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable {
	
	private Chopstick left, right;
	private Random random;
	private int thinkCount;
	
	private void think() throws InterruptedException {
		Thread.sleep(random.nextInt(1000));     // Think for a while
	}

	private void eat() throws InterruptedException {
		Thread.sleep(random.nextInt(1000));     // Eat for a while
	}

	public Philosopher(Chopstick left, Chopstick right) {
		this.left = left;
		this.right = right;
		this.random = new Random();
		this.thinkCount = 0;
	}


		
	
	@Override
	public void run() {
		try {
			while(thinkCount<=21) {
				++thinkCount;
				if (thinkCount % 3 == 0)
					System.out.println("Philosopher " + this + " has thought " + thinkCount + " times");
				this.think(); // think for a while
				left.lock();  // grab left chopstick 
				try {
					if (right.tryLock(1000,TimeUnit.MILLISECONDS)) { // grab right chopstick 
						try {
							this.eat(); // eat for a while
						} finally {
							right.unlock();
						}
					} else {
						// didn't get the right chopstick;
						// put down the left chopstick and think again
					}
				} finally {
					left.unlock();
				}
			}
		} catch(InterruptedException e) {	
			System.out.println("interrupted");
		}
	}
}
