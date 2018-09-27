public class LinkedList<E> {

	private class Node {
		E data;
		Node next;
		Node () {}

		Node (E data) {
			this(data, null);
		}

		Node (E data, Node next) {
			this.data = data;
			this.next = next;
		}

	}
	private Node head, tail;

	// LinkedList () {
	// 	head = new Node();
	// }
	//
	public void addAtHead(E data) {
		Node node = new Node();
		// if ()
		node.data = data;
		node.next = head;
		if (head == null) {
			head = node;
			tail = head;
			return;
		}

		head = node;
	}

	public E popAtHead() {
		E data = head.data;
		head = head.next;
		return data;
	}

	public void addAtTail(E data) {
		// Node thead = head;
		// while (thead != null &&  thead.next != null)
		// 	thead = thead.next;
		// thead.next = new Node(data);
		tail.next = new Node(data);
		tail = tail.next;
	}

	public E popAtTail() {
		E data = tail.data;
		Node thead = head;
		while (thead.next != tail)
			thead = thead.next;
		thead.next = null;
		tail = thead;
		return data;
	}

	public void insertAfter(int index, E data) {
		Node thead = head;
		for (int i = 0; i < index && thead != null; i++) {
			thead = thead.next;
		}
		Node node = new Node(data, thead.next);
		thead.next = node;
	}

	public void removeAfter(int index){
		Node thead = head;
		for (int i = 0; i < index && thead != null; i++) {
			thead = thead.next;
		}
		thead.next = thead.next.next;
	}

	void print() {
		Node thead = head;
		while (thead != null){
			System.out.print(thead.data + " -> ");
			thead = thead.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		l.addAtHead(1);
		l.addAtHead(2);
		l.addAtHead(3);
		l.addAtTail(65);

		l.print();
		System.out.println("--------");
		// System.out.println(l.popAtHead());
		System.out.println("--------");

		l.print();
		System.out.println("--------");

		// System.out.println(l.popAtTail());
		System.out.println("--------");
		l.print();
		System.out.println("--------");
		// System.out.println(l.popAtTail());
		System.out.println("--------");
		l.print();
		System.out.println("---------");
		l.insertAfter(0, 5);
		l.print();
		l.insertAfter(2, 6);
		l.print();
	}

}