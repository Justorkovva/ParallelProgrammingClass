package Class4;

public class PCTest4 {

	public static void main(String[] args) {
		GoodValue v = new GoodValue();
		Producer p1 = new Producer(v,"p1");
		Producer p2 = new Producer(v,"p2");
		Producer p3 = new Producer(v,"p3");
		Consumer c1 = new Consumer(v,"c1");
		Consumer c2 = new Consumer(v,"c2");
		Consumer c3 = new Consumer(v,"c3");
		p1.start();
		p2.start();
		p3.start();
		c1.start();
		c2.start();
		c3.start();
	}

}
