package Class2;

public class Counter {
private int count = 0;
public void increment() { count++; }
//public void increment() { 
//synchronized (this) {
//count++;
//}
//}
/// if this is used the class is called thread safe
public synchronized int getCount() {
return count;
// if you worry about access to count++ you should also worry about this count too
}
}



