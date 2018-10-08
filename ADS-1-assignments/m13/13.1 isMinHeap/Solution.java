import java.util.*;
import java.util.Scanner;
import java.util.Arrays;
class IsMinHeap<E> {
	public IsMinHeap() {

	}
	public boolean checkminheap(Comparable[] array) {
		boolean flag = true;
		if (array.length == 0) {
			return false;
		}
		for (int i = 0; i < array.length - 1; i++) {
			if (!(array[i].compareTo(array[i + 1]) <= 0)) {
				flag = false;
				return flag;
			}

		}
		return flag;
	}

}
public class Solution {
	private Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String k = sc.next();
		int no = sc.nextInt();
		sc.nextLine();
		while (no>0) {
			String[] inp = sc.nextLine().split(",");
			if (inp.length>0) {
			switch (k) {
			case "String" :
				IsMinHeap<String> datatype = new IsMinHeap<>();
				System.out.println(datatype.checkminheap(inp));
				break;
			case "Double":
				IsMinHeap<Double> ddatatype = new IsMinHeap<>();
				Double[] dinp = Arrays.stream(inp).map(Double::valueOf).toArray(Double[]::new);
				System.out.println(ddatatype.checkminheap(dinp));
				break;
			case "Integer":
				IsMinHeap<Integer> idatatype = new IsMinHeap<>();
				Integer[] iinp = Arrays.stream(inp).map(Integer::valueOf).toArray(Integer[]::new);
				System.out.println(idatatype.checkminheap(iinp));
				break;
			case "Float":
				IsMinHeap<Float> fdatatype = new IsMinHeap<>();
				Float[] finp = Arrays.stream(inp).map(Float::valueOf).toArray(Float[]::new);
				System.out.println(fdatatype.checkminheap(finp));
				break;
			default:
				break;
			}
		} else {
			System.out.println("false");
			no--;
		}
		}
	}
}