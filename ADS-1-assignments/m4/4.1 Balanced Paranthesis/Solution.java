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
			int flag = 0;
			int cnt = 0;
			String[] expr = sc.next().split("");
			if (expr[0].equals("]") || expr[0].equals(")") || expr[0].equals("}")) System.out.println("NO");
			else {
				for (int i = 0; i < expr.length; i++) {
					if (expr[i].equals("[")) {ms.push(expr[i]); cnt++;}
					if (expr[i].equals("]")) { if (ms.size > 0) {if (ms.peek().equals("[")) ms.pop(); else flag = 1; } }
					if (expr[i].equals("(")) { ms.push(expr[i]); cnt++;}
					if (expr[i].equals(")")) { if (ms.size > 0) {if (ms.peek().equals("(")) ms.pop(); else flag = 1; } }
					if (expr[i].equals("{")) { ms.push(expr[i]); cnt++;}
					if (expr[i].equals("}")) { if (ms.size > 0) {if (ms.peek().equals("{")) ms.pop(); else flag = 1; } }
				}
				if (flag == 0 && cnt == expr.length/2) {
				 System.out.println("YES"); }
				else { System.out.println("NO"); }
			}
		}
	}
}