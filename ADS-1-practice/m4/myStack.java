import java.util.Scanner;
import java.util.Stack;
public final class myStack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<String> stack = new Stack<String>();
		while (sc.hasNext()) {
			String s = sc.nextLine();
			if (!("-".equals(s))) {
				stack.push(s);
				System.out.println(stack);
			} else {
				stack.pop();
				System.out.println(stack);
			}
		}
	}
}