import java.util.Scanner;
import java.util.Arrays;
class Steque<E> {
	int size = 0;
	private class Node {
		E data;
		Node next;
		/*Node () {}
		Node (E data) {
			this(data, null);
		}
		Node (E data, Node next) {
			this.data = data;
			this.next = next;
		}*/
	}
	private Node head;
	private Node tail;

	public void push(E data) {
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

	public void enqueue(E data) {
		Node node = new Node();
		if (head == null) {
			push(data);
		} else {
			node.data = data;
			node.next = null;
			tail.next = node;
			tail = node;
			size++;
		}
	}

	public E pop() throws Exception {
		if (size <= 0) {
			throw new Exception();
		}
		E data = head.data;
		head = head.next;
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
				str += thead.data + ", ";
				thead = thead.next;
			}
			str += thead.data;

		} else {
			return "Steque is empty.";
		}
		str += "";
		return str;

	}

}
public class Solution {
	public Solution() {
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < no + 1; i++) {
			Steque<String> stq = new Steque<String>();
			while (sc.hasNext()) {
				String t = sc.nextLine();
				if (t.equals("")) {
					break;
				}
				String[] tokens = t.split(" ");
				switch (tokens[0]) {
				case "push":
					stq.push(tokens[1]);
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
				case "enqueue":
					stq.enqueue(tokens[1]);
					System.out.println(stq);
					break;
				default:
					break;
				}
			}
			System.out.println();
		}
	}
}