public class MyQueue<E> {
	int size = 0;
	private class Node {
		E data;
		Node next;
		Node () {}
		Node (E data) { this(data, null); }
		Node (E data, Node next) { this.data = data; this.next = next; }
	}
	private Node head;
	private Node tail;
	public void pushLeft(E data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		if (head == null) {
			head = node;
			tail = head;
			return;
		}
		head = node;
		size++;
	}

	public void pushRight(E data) {
		tail.next = new Node(data);
		tail = tail.next;
		size++;
	}

	public E popLeft() {
		E data = head.data;
		head = head.next;
		size--;
		return data;
	}

	public E popRight() {
		E data = tail.data;
		Node thead = head;
		while (thead.next != tail)
			thead = thead.next;
		thead.next = null;
		tail = thead;
		size--;
		return data;
	}

	public void insertAfter(int index, E data) {
		Node thead = head;
		for (int i = 0; i < index && thead != null; i++) {
			thead = thead.next;
		}
		Node node = new Node(data, thead.next);
		thead.next = node;
		size++;
	}

	public void removeAfter(int index) {
		Node thead = head;
		for (int i = 0; i < index && thead != null; i++) {
			thead = thead.next;
		}
		thead.next = thead.next.next;
		size--;
	}

	public int size() {
		return size;
	}
	public String toString() {
		String str = "[";
		Node thead = head;
		while (thead.next != null) {
			str += thead.data + ",";
			thead = thead.next;
		}
		str += thead.data + "]";
		return str;

	}

}