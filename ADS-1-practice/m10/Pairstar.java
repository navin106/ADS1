import java.util.Scanner;
public class Pairstar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a string.");
		String k = sc.nextLine();
		System.out.println(pairstar(k));
	}
	static String pairstar(String str) {
		int len = str.length();
		int i = 0;
		String temp = "";
		if (i < len - 1) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				return temp += str.charAt(i) + "*" + pairstar(str.substring(1));
			} else {
				return temp += str.charAt(i) + pairstar(str.substring(1));
			}
		}
		return temp + str.charAt(i);
	}
}