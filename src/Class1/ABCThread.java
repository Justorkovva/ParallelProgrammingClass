package Class1;
public class ABCThread extends Thread {
	
	@Override
	public void run () { 
		for (char i = 'A' ; i <= 'Z' ; i++) {
			System.out.print(i);
			BeLazy.doNothingForOneSecond () ; 
		}
	}
}
