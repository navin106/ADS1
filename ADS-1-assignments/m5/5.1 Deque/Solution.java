import java.util.Scanner;
public class Solution {
	private Solution() {
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyQueue mq =  new MyQueue();
		int k = sc.nextInt();
		while (sc.hasNext()) {
			String[] token = sc.nextLine().split(" ");
			switch (token[0]) {
			case "pushLeft":
			mq.pushLeft(token[1]);
			System.out.println(mq);
				break;
			case "pushRight":
			mq.pushRight(token[1]);
			System.out.println(mq);
				break;
			case "popLeft":
			mq.popLeft();
			System.out.println(mq);
				break;
			case "popRight":
			mq.popRight();
			System.out.println(mq);
				break;
			case "size":
			mq.size();
			System.out.println(mq);
				break;
			default:
				break;

			}

		}
	}
}