package Class5;

public class ParkingGarageTest {

	public static void main(String[] args) {
		int numberOfPlaces = 10;
		ParkingGarage myGarage = new ParkingGarage(numberOfPlaces);

		System.out.println("The garage is opening! Welcome!");
		int numberOfCars = 40;
		Car[] cars = new Car[numberOfCars];
		
		for (int i=0; i<numberOfCars; ++i) {
			cars[i] = new Car(myGarage,i);
			cars[i].start();
		}
		
		for (int i=0; i<numberOfCars; ++i) {
			try {
				cars[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("The garage is closing for today! Good bye!");
	}
}
