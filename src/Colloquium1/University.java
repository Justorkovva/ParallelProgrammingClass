package Colloquium1;

public class University {
public static void main(String args[]) {
Sum mySum = new Sum();

Teacher t1 = new Teacher(mySum);
Teacher t2 = new Teacher(mySum);
t1.start();
t2.start();

try {
t1.join();
t2.join();
} catch (InterruptedException e) {
e.printStackTrace();
}


System.out.println("The number of students is: " 
+ mySum.getSum());
}
}