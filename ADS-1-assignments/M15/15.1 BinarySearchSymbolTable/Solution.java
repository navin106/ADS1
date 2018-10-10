import java.util.Scanner;
public class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		SymbolTable<String, Integer> st = new SymbolTable<String, Integer>();
		Scanner sc = new Scanner(System.in);
		String[] keys = sc.nextLine().split(" ");
		for (int i = 0; i < keys.length; i++) {
			st.put(keys[i], i);
		}
		while (sc.hasNext()) {
			String[] cmd = sc.nextLine().split(" ");
			switch (cmd[0]) {
			case "max":
				System.out.println(st.max());
				break;
			case"floor":
				System.out.println(st.floor(cmd[1]));
				break;
			case "rank":
				System.out.println(st.rank(cmd[1]));
				break;
			case "deleteMin":
				st.deleteMin();
				break;
			case "contains":
				System.out.println(st.contains(cmd[1]));
				break;
			case "keys":
				String[] k = st.keys();
				for (int i=0;i<k.length;i++)
					System.out.println(k[i] + " " + st.get(k[i]));
				break;
			case "get":
				System.out.println(st.get(cmd[1]));
				break;
			default:
				break;

			}

		}
	}
}
class SymbolTable<Key extends Comparable<Key>, Value> {
	private static final int capacity = 10;
	private Key[] keys;
	private Value[] vals;
	private int n = 0;
	public SymbolTable() {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}
	public Key max() {

		return keys[n - 1];
	}
	public Key floor(Key key) {

		int i = rank(key);
		if (i < n && key.compareTo(keys[i]) == 0) return keys[i];
		if (i == 0) return null;
		else return keys[i - 1];
	}
	public int rank(Key key) {


		int lo = 0, hi = n - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if      (cmp < 0) hi = mid - 1;
			else if (cmp > 0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}
	public Key min() {

		return keys[0];
	}
	public void deleteMin() {

		delete(min());
	}
	public boolean contains(Key key) {

		return get(key) != null;
	}
	public Key[] keys() {
		return keys;
	}
	public Value get(Key key) {

		if (isEmpty()) return null;
		int i = rank(key);
		if (i < n && keys[i].compareTo(key) == 0) return vals[i];
		return null;
	}
	public void put(Key key, Value val)  {


		if (val == null) {
			delete(key);
			return;
		}

		int i = rank(key);

		// key is already in table
		if (i < n && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}

		// insert new key-value pair
		if (n == keys.length) resize(2 * keys.length);

		for (int j = n; j > i; j--)  {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
		}
		keys[i] = key;
		vals[i] = val;
		n++;
	}
	private void resize(int capacity) {
		assert capacity >= n;
		Key[]   tempk = (Key[])   new Comparable[capacity];
		Value[] tempv = (Value[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			tempk[i] = keys[i];
			tempv[i] = vals[i];
		}
		vals = tempv;
		keys = tempk;
	}
	public int size() {
		return n;
	}
	public boolean isEmpty() {
		return size() == 0;
	}
	public void delete(Key key) {

		if (isEmpty()) return;

		// compute rank
		int i = rank(key);

		// key not in table
		if (i == n || keys[i].compareTo(key) != 0) {
			return;
		}

		for (int j = i; j < n - 1; j++)  {
			keys[j] = keys[j + 1];
			vals[j] = vals[j + 1];
		}

		n--;
		keys[n] = null;  // to avoid loitering
		vals[n] = null;

		// resize if 1/4 full
		if (n > 0 && n == keys.length / 4) resize(keys.length / 2);
	}
}