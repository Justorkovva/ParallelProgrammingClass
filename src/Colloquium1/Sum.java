package Colloquium1;

public class Sum {
private int sum = 0;
public void add() { synchronized (this){
sum++; 
}
}
public synchronized int getSum() { return sum; }
}