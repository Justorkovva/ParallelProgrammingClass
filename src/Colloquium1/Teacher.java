package Colloquium1;

public class Teacher extends Thread {
Sum sum;
public Teacher(Sum sum) {
this.sum = sum;
}

@Override 
public void run() {
for (int i=0; i< 500; i++) {
synchronized(sum){
sum.add();
}
}
}
}
