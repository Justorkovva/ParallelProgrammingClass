package Class1;
public class SomeRunnables {
public static void main( String [ ] args ) {
	ABCRunnable r1 = new ABCRunnable() ;
	ABCRunnable r2 = new ABCRunnable() ;

	Thread t1 = new Thread( r1 ) ; 
	Thread t2 = new Thread( r2 ) ;

	t1.start() ;
	t2.start() ;
	}
}