package Class6;

import java.util.Random;

class Philosopher extends Thread {
	private Chopstick left, right;
	private Random random;
	private int thinkCount;
	
	public Philosopher(Chopstick left, Chopstick right) {
		this.left = left; 
		this.right = right;
		random = new Random();
	}
	
	private void think() throws InterruptedException {
		Thread.sleep(random.nextInt(1000));     // Think for a while
	}

	private void eat() throws InterruptedException {
		Thread.sleep(random.nextInt(1000));     // Eat for a while
	}

	public void run() {
		try {
			while(thinkCount<=21) {
				++thinkCount;
				if (thinkCount % 3 == 0)
					System.out.println("Philosopher " + this + " has thought " + thinkCount + " times");
				this.think(); // think for a while
				if (left.getId() < right.getId()) {
					synchronized(left) { // grab left chopstick 
						synchronized(right) { // grab right chopstick 
							this.eat(); // eat for a while
						}
					}
				} else {
					synchronized(right) { // grab right chopstick 
						synchronized(left) { // grab left chopstick 
							this.eat(); // eat for a while
						}
					}
				}
			}
		} catch(InterruptedException e) {}
	}
}
