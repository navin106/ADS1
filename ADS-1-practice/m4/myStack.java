import java.util.Scanner;
public final class myStack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Mystack<String> stack = new Mystack<String>();
		while (sc.hasNext()) {
			String s = sc.nextLine();
			if (!("-".equals(s))) {
				stack.push(s);
				System.out.println(stack);
			} else {
				// System.out.println(stack.pop());
				stack.pop();
				System.out.println(stack);
			}
		}
	}
}