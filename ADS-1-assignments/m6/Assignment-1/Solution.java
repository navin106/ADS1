import java.util.Scanner;
class LinkedList<E> {
	int size = 0;
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
	private Node head;
	private Node tail;

	public void pushLeft(E data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		if (head == null) {
			head = node;
			tail = head;
			size++;
			return;
		}
		head = node;
		size++;
	}

	public void pushRight(E data) {
		Node node = new Node();
		node.data = data;
		node.next = head;
		if (head == null) {
			head = node;
			tail = head;
			size++;
			return;
		}
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
		while (thead.next != tail) {
			thead = thead.next;
			// size--;
		}
		thead.next = null;
		tail = thead;
		size--;
		return data;
	}
	public int size() {
		return size;
	}
	public String toString() {
		String str = "";
		Node thead = head;
		if (thead != null) {
			while (thead.next != null) {
				str += thead.data;
				thead = thead.next;
			}
			str += thead.data;

		}
		return str;

	}

}
class AddLargeNumbers {

	public static LinkedList numberToDigits(String number) {
		LinkedList<String> num = new LinkedList<String>();
		String[] numbers = number.split("");
		for (String k : numbers) {
			num.pushRight(k);
		}
		return num;
	}

	public static String digitsToNumber(LinkedList list) {
		return list.toString();
	}

	// public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {

	// }
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String p = sc.nextLine();
		String q = sc.nextLine();
		switch (input) {
		case "numberToDigits":
			LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
			LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
			System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
			System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
			break;

			// case "addLargeNumbers":
			// 	pDigits = AddLargeNumbers.numberToDigits(p);
			// 	qDigits = AddLargeNumbers.numberToDigits(q);
			// 	LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
			// 	System.out.println(AddLargeNumbers.digitsToNumber(result));
			// 	break;
		}
	}

}
