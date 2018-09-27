import java.util.Scanner;
import java.util.Arrays;
public final class Solution {
	private Solution() {
	}
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		Mystack<String> ms = new Mystack<String>();
		int k = sc.nextInt();
		// System.out.println();
		while (sc.hasNext()) {
			int cnt = 0;
			String[] expr = sc.next().split("");
			/*System.out.print(expr[0]);
			System.out.print("------>");*/
			if (expr[0].equals("]") || expr[0].equals(")") || expr[0].equals("}")) System.out.println("NO");
			else {
				for (int i = 0; i < expr.length; i++) {
					if (expr[i].equals("[")) { ms.push(expr[i]); cnt++; }
					// System.out.println(ms);
					if (expr[i].equals("]")) { if (ms.size > 0) {if (ms.peek().equals("[")) {ms.pop(); cnt--;} else break; } }
					if (expr[i].equals("(")) { ms.push(expr[i]); cnt++; }
					// 
					if (expr[i].equals(")")) { if (ms.size > 0) {if (ms.peek().equals("(")) {ms.pop(); cnt--;}else break; } }
					if (expr[i].equals("{")) { ms.push(expr[i]); cnt++; }
					// 
					if (expr[i].equals("}")) { if (ms.size > 0) {if (ms.peek().equals("{")) {ms.pop(); cnt--;}else break; } }
				}
				// System.out.print("---->");
				// System.out.print(expr.length/2);
				// System.out.println();
				if (cnt == 0) { System.out.println("YES"); }
				else { System.out.println("NO"); }
			}
			// System.out.println(cnt);
		}
	}
}