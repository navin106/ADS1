import java.util.Scanner;
class Node<E> {
	public E item;
	public Node next;
}
class Steque<E> {
	public Node<E> head;
	public Node<E> tail;
	public int qsize;
	public Steque() {
		head = new Node<E>();
		tail = new Node<E>();
		qsize = 0;
	}
	public void push(E data) {
		Node<E> tnode = new Node<E>();
		if (head.next == null) {
			tnode.item = data;
			tnode.next = null;
			head = tnode;
			tail = head;
			qsize++;
		}
		tnode.item = data;
		tnode.next = head;
		head = tnode;
		qsize++;
	}
	public E pop() {
		if (head.item != null) {
			E data = head.item;
			head = head.next;
			qsize--;
			return data;
		} else {
			return null;
		}

	}
	public void enqueue(E data) {
		Node<E> tnode = new Node<E>();
		if (head.next == null) {
			tnode.item = data;
			tnode.next = null;
			head = tnode;
			tail = head;
			qsize++;
		}
		tnode.item = data;
		tnode.next = null;
		tail.next = tnode;
		tail = tnode;
		qsize++;

	}
	public String toString() {
		Node thead = new Node();
		String str = "";
		while (head.next.next != null) {
			str += head.item + ", ";
			head = head.next;
		}
		str += head.item;
		return str;
	}

}
public class Solution {
	private Solution() {
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Steque<String> stq = new Steque<String>();
		int no = sc.nextInt();
		while (no != 0) {
			String t = sc.nextLine();
			if (t.equals("")) break;
			while (sc.hasNext()) {
				String[] tokens = t.split("-");
				switch (tokens[0]) {
				case "push":
					stq.push(tokens[1]);
					System.out.println(stq);
					break;
				case "pop":
					if (stq.pop() == null) {
						System.out.println("Steque is empty.");
						break;
					}
					System.out.println(stq);
					break;
				case "enqueue":
					stq.enqueue(tokens[1]);
					System.out.println(stq);
					break;
				default:
					break;
				}
			}
			no--;
		}
	}
}