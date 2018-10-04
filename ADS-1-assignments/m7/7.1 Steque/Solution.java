import java.util.Scanner;
public class Solution {
	private Solution() {
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < k; i++) {
			Steque<String> stq = new Steque<String>();
			while (sc.hasNext()) {
				String t = 	sc.nextLine();
				if (t.equals("")) {
					break;
				}
				String[] token = t.split(" ");
				switch (token[0]) {
				case "push":
					stq.push(token[1]);
					System.out.println(stq);
					break;
				case "enqueue":
					stq.enqueue(token[1]);
					System.out.println(stq);
					break;
				case "pop":
					try {
						stq.pop();
						System.out.println(stq);
					} catch (Exception e) {
						System.out.println("Steque is empty.");

					}
					break;
				default:
					break;
				}

			}
			System.out.println();
		}
	}

}
class Steque<E> {
	Scanner sc = new Scanner(System.in);
	Steque() {

	}
	private class Node {
		E data;
		Node next;
	}
	Node head;
	Node tail;
	int size = 0;
	public void push(E item) {
		Node temp = new Node();
		temp.data = item;
		temp.next = head;
		if (head == null) {
			head = temp;
			tail = head;
			size++;
			return;
		}
		head = temp;
		size++;
	}
	public void enqueue(E item) {
		Node temp = new Node();
		temp.data = item;
		temp.next = null;
		if (head == null) {
			head = temp;
			tail = head;
			size++;
			return;
		}
		tail.next = temp;
		tail = temp;
		size++;
	}
	public E pop() throws Exception {
		E data = head.data;
		if (size == 0) {
			head.data = null;
			head.next = null;
			throw new Exception();
		}
		head = head.next;
		size--;
		return data;
	}
	public String toString() {
		String str = "";
		Node thead = head;
		if (thead != null) {
			while (thead.next != null) {
				str += thead.data + ", ";
				thead = thead.next;
			}
			str += thead.data;

		} else {
			// System.out.println("Steque is empty.");
			sc.nextLine();
		}
		return str;

	}
}