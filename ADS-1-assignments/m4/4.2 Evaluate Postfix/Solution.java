import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split(" ");
		Mystack<Integer> stack = new Mystack<Integer>();
		for (int i = 0; i < s.length; i++) {
			if (s[i] == "*" || s[i] == "/" || s[i] == "+" || s[i] == "-") {
				if (s[i] == "*") {stack.push(stack.pop()*stack.pop());}
				if (s[i] == "/") {stack.push(stack.pop()/stack.pop());}
				if (s[i] == "+") {stack.push(stack.pop()+stack.pop());}
				if (s[i] == "-") {stack.push(stack.pop()-stack.pop());}
			}
			else {
				stack.push(Integer.parseInt(s[i]));
			}
		}
		System.out.println(stack);

	}
}