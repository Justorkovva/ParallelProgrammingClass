package Class10b;

public class SynchronizedList extends ConcurrentList {

	public synchronized void insert(int value) {
		Node current = head;
		Node next = current.next;

		while (true) {
			doPause();
			if (next == tail || next.value < value ) {
				Node node = new Node(value, current, next);
				next.previous = node;
				current.next = node;
				return;
			} 
			current = next;
			next = current.next;
		}
	}

	private void doPause() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
