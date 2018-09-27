import java.util.Scanner;
import java.util.Arrays;
public final class Solution {
	private Solution() {
	}
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		Mystack<String> ms = new Mystack<String>();
		int k = sc.nextInt();
		while (sc.hasNext()) {
			int cnt = 0;
			String[] expr = sc.nextLine().split("");
			for (int i = 0; i < expr.length; i++) {
				if (expr[i].equals("[")) { ms.push(expr[i]); cnt++; }
				if (expr[i].equals("]")) { if (ms.peek() != null) {if (ms.peek().equals("[")) { ms.pop(); } else break; } }
				if (expr[i].equals("(")) { ms.push(expr[i]); cnt++; }
				if (expr[i].equals(")")) { if (ms.peek() != null) {if (ms.peek().equals("(")) { ms.pop(); } else break; } }
				if (expr[i].equals("{")) { ms.push(expr[i]); cnt++; }
				if (expr[i].equals("}")) { if (ms.peek() != null) {if (ms.peek().equals("{")) { ms.pop(); } else break; } }
			}
			/*System.out.print(cnt);
			System.out.print("----->");
			System.out.print(expr.length);
			System.out.println();*/
			if (cnt == expr.length / 2) { System.out.println("YES"); }
			else { System.out.println("NO"); }
		}
	}
}