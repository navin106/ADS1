import java.util.Scanner;
class Steque<E> {
	private int size = 0;
	public Steque() {

	}
	class Node {
		private E value;
		private Node next;
		public E getvalue() {
			return value;
		}

		public void setvalue(E value) {
			this.value = value;
		}
		public Node getnext() {
			return next;
		}

		public void setnext(Node next) {
			this.next = next;
		}
	}
	private Node head;
	private Node tail;
	public Node gethead() {
		return head;
	}

	public void sethead(Node head) {
		this.head = head;
	}
	public Node gettail() {
		return tail;
	}

	public void settail(Node tail) {
		this.tail = tail;
	}
	public void push(E item) {
		Node add = new Node();
		if (head.getvalue() == null) {
			add.setvalue(item);
			add.setnext(null);
			head = add;
			tail = head;
			size++;
		} else {
			add.setvalue(item);
			add.setnext(head);
			head = add;
			size++;
		}
	}
	public E pop() {
		if (head.getvalue() != null) {
			System.out.println("Steque is empty");
			return null;
		} else {
			E data = head.getvalue();
			head.setnext(head.getnext());
			size--;
			return data;
		}
	}
	public void enqueue(E item) {
		Node add = new Node();
		if (tail.getvalue() == null) {
			add.setvalue(item);
			add.setnext(null);
			head = add;
			tail = head;
			size--;
		} else {
			add.setvalue(item);
			add.setnext(null);
			tail.setnext(tail);
			tail = add;
			size--;
		}
	}
	public String toString() {
		Node add = new Node();
		add.setnext(head);
		String str = "";
		while (head.getnext().getvalue() != null) {
			str += add.getvalue() + ", ";
			add = head.getnext();
		}
		str += add.getvalue();
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
					stq.pop();
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
		}
	}
}