import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MergeSort st = new MergeSort();
		while (sc.hasNext()) {
			String[] tokens = sc.nextLine().split(",");
			st.sort(tokens);
			String str = "[";
            int i;
            for (i = 0; i < tokens.length - 1; i++) {
                str += tokens[i] + ", ";
            }
            str += tokens[i] + "]";
            System.out.println(str);
            System.out.println();
		}
	}
}
