package Class1;
public class SomeThreads { 
	
	public static void main( String [ ] args ) { 
		ABCThread t1 = new ABCThread() ; 
		ABCThread t2 = new ABCThread() ;
		ABCThread t3 = new ABCThread() ; 
		ABCThread t4 = new ABCThread() ;


	t1.start() ; 
	t2.start() ; 
	t3.start() ; 
	t4.start() ; 
	}} 
	