import java.util.Scanner;
import java.util.Arrays;
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

	public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
		int a = list1.size;
		int b = list2.size;
		LinkedList<String> result =  new LinkedList<String>();
		if (list1.size < list2.size ) {
			while (!(list1.size == list2.size)) {
				list1.pushLeft("0");
			}
		}
		if (list2.size < list1.size ) {
			while (!(list1.size == list2.size)) {
				list2.pushLeft("0");
			}
		}
		int add = 0;
		int carry = 0;
		String k1 = "";
		String[] num1 = digitsToNumber(list1).split("");
		String[] num2 = digitsToNumber(list2).split("");
		for (int i = num1.length - 1; i >= 0; i--) {
			String str = "";
			if (carry == 0) {
				add = Integer.parseInt(num1[i]) + Integer.parseInt(num2[i]);
			} else {
				add = Integer.parseInt(num1[i]) + Integer.parseInt(num2[i]) + carry;
			}
			carry = 0;
			str += add;
			String[] k = str.split("");
			if (k.length == 2) {
				k1 = k[0];
				result.pushLeft(k[1]);
				carry = Integer.parseInt(k[0]);
			} else {
				result.pushLeft(k[0]);
			}
		}
		if (a == b) {
			result.pushLeft(k1);
		}
		return result;
	}
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

		case "addLargeNumbers":
			pDigits = AddLargeNumbers.numberToDigits(p);
			qDigits = AddLargeNumbers.numberToDigits(q);
			LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
			System.out.println(AddLargeNumbers.digitsToNumber(result));
			break;
		}
	}

}
