import java.util.Scanner;
public class Recursvefactorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the number to get factorial");
		int k = sc.nextInt();
		System.out.println(factorial(k));
	}
	static int factorial(int no) {
		if (no == 0) {
			return 1;
		} else {
			return no * factorial(no - 1);
		}
	}
}