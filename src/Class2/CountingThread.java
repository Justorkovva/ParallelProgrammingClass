package Class2;

public class CountingThread extends Thread {
Counter counter;
/// counter is a sheared resource we have to limit access to it

public CountingThread(Counter counter) {
this.counter = counter;
}

@Override
public void run() {
for (int i=0; i< 10000; i++) {
synchronized (counter) {
///synchronized block added
//it is a guarded block
//only 1 thread can excess, other threads are put into waiting queue
//make the blocks as small as possible
//synchronized could be before loop but it would slow down the program and it is unnecessary
///locks are more flexible
// with synchronized we cannot delete item from waiting list
counter.increment();
}
}
}
}
