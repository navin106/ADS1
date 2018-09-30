import java.util.Scanner;
/**
 * List of linkeds.
 *
 * @param      <E>   { parameter_description }
 */
class LinkedList<E> {
	/**
	 * { var_description }.
	 */
	private int size = 0;
	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int getsize() {
		return size;
	}
	/**
	 * { function_description }
	 *
	 * @param      size  The size
	 */
	public void setsize(int size) {
		this.size = size;
	}
	/**
	 * Class for node.
	 */
	private class Node {
		/**
		 * { var_description }.
		 */
		private E data;
		/**
		 * { var_description }.
		 */
		private Node next;
		/**
		 * Constructs the object.
		 */
		Node() {

		}
		/**
		 * Constructs the object.
		 *
		 * @param      data1  The data 1
		 */
		Node(final E data1) {
			this(data1, null);
		}
		/**
		 * Constructs the object.
		 *
		 * @param      data1  The data
		 * @param      next1  The next
		 */
		Node(final E data1, final Node next1) {
			this.data = data1;
			this.next = next1;
		}
	}
	/**
	 * { var_description }.
	 */
	private Node head;
	/**
	 * { var_description }.
	 */
	private Node tail;

	/**
	 * Pushes a left.
	 *
	 * @param      data  The data
	 */
	public void pushLeft(final E data) {
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

	/**
	 * Pushes a right.
	 *
	 * @param      data  The data
	 */
	public void pushRight(final E data) {
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

	/**
	 * { function_description }.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public E popLeft() {
		E data = head.data;
		head = head.next;
		// size--;
		return data;
	}
	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public E popRight() {
		E data = tail.data;
		Node thead = head;
		while (thead.next != tail) {
			thead = thead.next;
			// size--;
		}
		thead.next = null;
		tail = thead;
		// size--;
		return data;
	}
	/**
	 * { function_description }.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int size() {
		return size;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
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
/**
 * Class for add large numbers.
 */
final class AddLargeNumbers {
	/**
	 * Constructs the object.
	 */
	private AddLargeNumbers() {

	}

	/**
	 * { function_description }.
	 *
	 * @param      number  The number
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static LinkedList numberToDigits(final String number) {
		LinkedList<String> num = new LinkedList<String>();
		String[] numbers = number.split("");
		for (String k : numbers) {
			num.pushRight(k);
		}
		return num;
	}

	/**
	 * { function_description }.
	 *
	 * @param      list  The list
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static String digitsToNumber(final LinkedList list) {
		return list.toString();
	}

	/**
	 * Adds large numbers.
	 *
	 * @param      list1  The list 1
	 * @param      list2  The list 2
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static LinkedList addLargeNumbers(
	    final LinkedList list1, final LinkedList list2) {
		int a = list1.getsize();
		int b = list2.getsize();
		LinkedList<String> result =  new LinkedList<String>();
		if (list1.getsize() < list2.getsize()) {
			while (!(list1.getsize() == list2.getsize())) {
				list1.pushLeft("0");
			}
		}
		if (list2.getsize() < list1.getsize()) {
			while (!(list1.getsize() == list2.getsize())) {
				list2.pushLeft("0");
			}
		}
		int add = 0;
		int carry = 0;
		String k1 = "";
		for (int i = 0; i<list2.getsize()	; i++) {
			String str = "";
			add = Integer.valueOf((String)list1.popRight()) + Integer.valueOf((String)list2.popRight()) + carry;
			System.out.println(add);
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
		/*String[] num1 = digitsToNumber(list1).split("");
		String[] num2 = digitsToNumber(list2).split("");
		for (int i = num1.length - 1; i >= 0; i--) {
		    String str = "";
		    if (carry == 0) {
		        add = Integer.parseInt(
		            num1[i]) + Integer.parseInt(num2[i]);
		    } else {
		        add = Integer.parseInt(
		    num1[i]) + Integer.parseInt(num2[i]) + carry;
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
		}*/
		return result;
	}
}

/**
 * Class for solution.
 */
public final class Solution1 {
	/**
	 * Constructs the object.
	 */
	private Solution1() {

	}
	/**
	 * { function_description }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		String p = sc.nextLine();
		String q = sc.nextLine();
		switch (input) {
		case "numberToDigits":
			LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
			LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
			System.out.println(
			    AddLargeNumbers.digitsToNumber(pDigits));
			System.out.println(
			    AddLargeNumbers.digitsToNumber(qDigits));
			break;

		case "addLargeNumbers":
			pDigits = AddLargeNumbers.numberToDigits(p);
			qDigits = AddLargeNumbers.numberToDigits(q);
			LinkedList result =
			    AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
			System.out.println(
			    AddLargeNumbers.digitsToNumber(result));
			break;
		default:
			break;
		}
	}

}
