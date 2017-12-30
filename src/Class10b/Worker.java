package Class10b;

import java.util.Random;

public class Worker implements Runnable {

	private ConcurrentList myList;
	private Random myRand;
	
	public Worker(ConcurrentList myList) {
		this.myList = myList;
		this.myRand = new Random();
	}

	private void fillList() {
		for (int i=0; i<10; i++) {
			myList.insert(myRand.nextInt(1000));
		}
	}
	
	@Override
	public void run() {
		fillList();
	}

}
