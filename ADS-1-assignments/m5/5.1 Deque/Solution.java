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
				if (mq.size > 0) {
					mq.popLeft();
					System.out.println(mq);
				} else System.out.println("Deck is empty");
				break;
			case "popRight":
				if (mq.size > 0) {
					mq.popRight();
					System.out.println(mq);
				} else System.out.println("Deck is empty");
				break;
			case "size":
				System.out.println(mq.size());
				break;
			default:
				break;

			}

		}
	}
}