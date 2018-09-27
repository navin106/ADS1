import java.util.Scanner;
import java.util.Arrays;
public final class Solution {
	private Solution() {
	}
	public static void main(final String[] args) {
		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		Mystack<String> ms = new Mystack<String>();
		int k = sc.nextInt();
		while (sc.hasNext()) {
			String[] expr = sc.nextLine().split("");
			for (int i = 0; i < expr.length; i++) {
				if (expr[i].equals("[")) { ms.push(expr[i]); cnt++; }
				else { if (expr[i] != "]") ms.pop(); else { break; } }
				if (expr[i].equals("(")) { ms.push(expr[i]); cnt++; }
				else { if (expr[i] != ")") ms.pop(); else { break; } }
				if (expr[i].equals("{")) { ms.push(expr[i]); cnt++; }
				else { if (expr[i] != "}") ms.pop(); else { break; } }
			}
			if (cnt == expr.length / 2) { System.out.println("YES"); }
			else { System.out.println("NO"); }
		}
	}
}