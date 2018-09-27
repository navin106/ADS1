import java.util.Scanner;
public class Solution {
	private Solution() {
	}
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		Mystack<Integer> stack = new Mystack<Integer>();
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("*") || s[i].equals(
				"/") || s[i].equals("+") || s[i].equals("-")) {
				if (s[i].equals("*")) {
					stack.push(stack.pop() * stack.pop());
				}
				if (s[i].equals("/")) {
					stack.push(stack.pop() / stack.pop());
				}
				if (s[i].equals("+")) {
					stack.push(stack.pop() + stack.pop());
				}
				if (s[i].equals("-")) {
					stack.push(stack.pop() - stack.pop());
				}
			} else {
				stack.push(Integer.parseInt(s[i]));
			}
		}
		System.out.println(stack.pop());
	}
}
