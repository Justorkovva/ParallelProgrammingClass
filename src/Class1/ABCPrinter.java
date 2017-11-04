package Class1;
public class ABCPrinter {
	
	public void run () { 
		for (char i = 'A' ; i <= 'Z' ; i++) {
			System.out.print(i);
			BeLazy.doNothingForOneSecond () ; 
		}
	}
	public void start() { 
		run(); 
		}
	
}
