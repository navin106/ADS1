import java.util.Scanner;
public class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		sc.nextLine();
		int k = no;
		while (sc.hasNext()) {
			while (no > 0) {
				String sk = sc.nextLine();
				System.out.println(sk);
				// System.out.println();
				no--;
			}
			System.out.println();
			no = k;
		}
	}
}