import java.util.Scanner;
class ThreeSum {
	int cnt = 0;
	int noOfTrips(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j=i+2; j<arr.length; j++) {
				if(arr[i] + arr[i+1] == arr[j]) {
					cnt++;
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
			arr[i] = Math.abs((sc.nextInt()));
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