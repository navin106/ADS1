import java.util.Scanner;
public class Solution {
	private Solution() {
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			Steque<String> stq = new Steque<String>();
			while (sc.hasNext()) {
				String[] token = sc.nextLine().split(" ");
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
					stq.pop();
					System.out.println(stq);
					break;
				default:
					break;
				}

			}
		}
	}

}
class Steque<E> {
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
		tail.next = new Node();
		tail.next.data = item;
		tail.next.next = null;
		if (head == null) {
			head = tail;
			tail = head;
			size++;
		}
		tail = tail.next;
		size++;
	}
	public E pop() {
		E data = head.data;
		head = head.next;
		size++;
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

		} else{
			System.out.println("Steque is empty.");
		}
		return str;

	}
}