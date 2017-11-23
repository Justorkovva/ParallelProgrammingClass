package Class5;

public class ParkingGarage {
	private int freePlaces;
	private int nextWaitingNumber;
	
	public ParkingGarage(int freePlaces) {
		this.freePlaces = freePlaces;
		nextWaitingNumber = 0;
	}
	
	public synchronized void enter(int waitingNumber) {
		while (freePlaces == 0 || waitingNumber != nextWaitingNumber) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("waiting nr " + waitingNumber 
				+ " free places " + freePlaces);
		nextWaitingNumber++;
		freePlaces--;
		notifyAll();
	}
	
	public synchronized void leave() {
		freePlaces++;
		notifyAll();
	}
}
