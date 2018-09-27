import java.util.Scanner;
class ThreeSum {
	int cnt = 0;
	int noOfTrips(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				for (int k = j; k < arr.length; k/=2) {
					if (arr[i] + arr[j] + arr[k] == 0) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}
}
class CreateArray {
	private int[] arr;
	ThreeSum ts = new ThreeSum();
	public CreateArray(int k, Scanner sc) {
		arr = new int[k];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (sc.nextInt());
		}
		System.out.println(ts.noOfTrips(arr));
	}
}
public final class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		CreateArray ts = new CreateArray(k, sc);
	}

}