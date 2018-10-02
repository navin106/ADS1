import java.util.Scanner;
import java.util.Arrays;
public class Solution {
	Solution() {

	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[] names = new String[10];

		int size = 0;
		while (sc.hasNext()) {
			String[] k = sc.nextLine().split(",");
			// System.out.println(Arrays.toString(k));
			// System.out.println(k[0]);
			names[size++] = k[0];
			
			// System.out.println(Arrays.toString(names));
		}
	}







	void Sort(Comparable[] a) {
		String str = "";
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++)
				if (less(a[j], a[min]))
					min = j;
			exch(a, i, min);
		}
		for (Comparable k : a) {
			str += k + ",";
		}
		System.out.println(str.substring(0,a.length-2));
	}
	private static boolean less(Comparable v, Comparable w)
	{ return v.compareTo(w) < 0; }
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}