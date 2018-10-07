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
/**
 * List of linkeds.
 */
class LinkedList {
	/**
	 * head.
	 */
	private Node head;
	/**
	 * Class for node.
	 */
	private class Node {
		/**
		 * data.
		 */
		private int data;
		/**
		 * next.
		 */
		private Node next;

		/**
		 * Constructs the object.
		 *
		 * @param      data  The data
		 * @param      next  The next
		 */
		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	/**
	 * function to insert the element at particular place.
	 *
	 * @param      position  The position
	 * @param      data      The data
	 *
	 * @return     { description_of_the_return_value }
	 */
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
	/**
	 * function to help insertat function.
	 * it inserts the element in recursevely
	 *
	 * @param      head  The head
	 * @param      cnt   The count
	 * @param      ele   The ele
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Node insertHelper(final Node thead, final int cnt, final int ele) {
		if (cnt == 0) {
			return new Node(ele, thead);
		}
		thead.next = insertHelper(thead.next, cnt - 1, ele);
		return thead;
	}
	/**
	 * reverse the linkedlist.
	 */
	public void reverse() {
		head = reverseHelper(head);
	}
	/**
	 * function to help reverse the linkedlist.
	 *
	 * @param      thead  The thead
	 *
	 * @return     { description_of_the_return_value }
	 */
	Node reverseHelper(final Node thead) {
		if (thead.next == null) {
			return thead;
		}
		Node nhead = reverseHelper(thead.next);
		thead.next.next = thead;
		thead.next = null;
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
