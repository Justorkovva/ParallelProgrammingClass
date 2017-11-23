package Class5;

class Car extends Thread
{
	private ParkingGarage garage;
	private int waitingNumber;
	
	public Car(ParkingGarage garage, int waitingNumber)
	{
    	this.garage = garage;
    	this.waitingNumber = waitingNumber;
    }
	
	public void run()
	{
		makeSomePhoneCalls();
		garage.enter(waitingNumber);
    	System.out.println(getName() + " with nr " + waitingNumber 
    			+ " entering the garage.");
    	doShopping();
    	System.out.println(getName() + " leaving the garage.");
    	garage.leave();
    }

	private void makeSomePhoneCalls() {
		try {
			sleep((int) (Math.random() * 100));
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	private void doShopping() {
		try {
			sleep((int) (Math.random() * 500));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
