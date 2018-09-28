import java.util.Scanner;
public final class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyQueue mq = new MyQueue();
		int k = sc.nextInt();
		while (sc.hasNext()) {
			String[] token = sc.nextLine().split(" ");
			int cnt = 1;
			for (int i = 0; i < token.length; i++) { mq.pushLeft(token[i]); }
			for (int i = 0; i < token.length; i++) {
				if (cnt % 2 == 0) { System.out.println(mq.popRight());}
				else mq.pushLeft(mq.popRight());
			}
		}
	}
}