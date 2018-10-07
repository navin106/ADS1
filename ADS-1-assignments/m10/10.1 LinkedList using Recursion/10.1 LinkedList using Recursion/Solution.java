import java.util.Scanner;
final class Solution {
	private Solution() {}
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList l = new LinkedList();
		int size = 0;
		while (sc.hasNextLine()) {
			String[] tokens = sc.nextLine().split(" ");
			switch (tokens[0]) {
			case "insertAt":
				if (!l.insertAt(Integer.parseInt(tokens[1]),
				                Integer.parseInt(tokens[2]))) {
					size++;
					System.out.println(l.print());
				}
				break;
			case "reverse":
				if (size == 0) {
					System.out.println("No elements to reverse.");
					break;
				}
				l.reverse();
				System.out.println(l.print());
				break;
			default:
				break;
			}
		}
	}
}
class LinkedList {
	private Node head;
	private class Node {
		private int data;
		private Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	public boolean insertAt(int position, int data) {
		boolean flag = false;
		try {
			head = insertHelper(head, position , data);
		} catch (Exception e) {
			System.out.println("Can't insert at this position.");
			flag = true;
		}
		return flag;
	}
	public Node insertHelper(Node head, int cnt, int ele) {
		if (cnt == 0) return new Node(ele, head);
		head.next = insertHelper(head.next, cnt - 1, ele);
		return head;
	}
	public void reverse() {
		head = reverseHelper(head);
	}
	Node reverseHelper(Node head) {
		if (head.next == null) {
			return head;
		}
		Node nhead = reverseHelper(head.next);
		head.next.next = head;
		head.next = null;
		return nhead;
	}
	/**
	 * complexity is O(N).
	 * function used for printing returns string.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String print() {
		Node thead = head;
		String s  = "";
		while (thead != null) {
			s += thead.data + ", ";
			thead = thead.next;
		}

		return s.substring(0, s.length() - 2);
	}
}
