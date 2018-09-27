import java.util.Scanner;
class Pair {
	int pairCount(int[] nums) {
		
	}
}

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner();
		Pair p = new Pair();
		int size = sc.nextInt();
		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = sc.nextInt();
		}
		System.out.println(p.pairCount(nums));

	}
}