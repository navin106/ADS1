import java.util.Scanner;
import java.util.Iterator;
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
				for (String s : st.keys())
					System.out.println(s + " " + st.get(s));
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
		// if (isEmpty()) throw new Exception("called max() with empty symbol table");
		return keys[n - 1];
	}
	public Key floor(Key key) {
		// if (key == null) throw new Exception("argument to floor() is null");
		int i = rank(key);
		if (i < n && key.compareTo(keys[i]) == 0) return keys[i];
		if (i == 0) return null;
		else return keys[i - 1];
	}
	public int rank(Key key) {
		// if (key == null) throw new Exception("argument to rank() is null");

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
		// if (isEmpty()) throw new Exception("called min() with empty symbol table");
		return keys[0];
	}
	public void deleteMin() {
		// if (isEmpty()) throw new Exception("Symbol table underflow error");
		delete(min());
	}
	public boolean contains(Key key) {
		// if (key == null) throw new Exception("argument to contains() is null");
		return get(key) != null;
	}

	public Value get(Key key) {
		// if (key == null) throw new Exception("argument to get() is null");
		if (isEmpty()) return null;
		int i = rank(key);
		if (i < n && keys[i].compareTo(key) == 0) return vals[i];
		return null;
	}
	public void put(Key key, Value val)  {
		// if (key == null) throw new Exception("first argument to put() is null");

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
		// if (key == null) throw new Exception("argument to delete() is null");
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
	public Iterable<Key> keys() {
		return keys(min(), max());
	}

	public Iterable<Key> keys(Key lo, Key hi) {
		// if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
		// if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

		Queue<Key> queue = new Queue<Key>();
		if (lo.compareTo(hi) > 0) return queue;
		for (int i = rank(lo); i < rank(hi); i++)
			queue.enqueue(keys[i]);
		if (contains(hi)) queue.enqueue(keys[rank(hi)]);
		return queue;
	}
}

class Queue<E> implements Iterable<E> {
	private class Node {
		E data;
		Node next;
	}
	private Node head, tail;
	private int size = 0;

	public void enqueue(E data) {
		Node node = new Node();
		node.data = data;
		size++;
		if (tail == null) {
			tail = node;
			head = node;
			return;
		}
		tail.next = node;
		tail = tail.next;
	}

	public E dequeue() {
		E data = head.data;
		head = head.next;
		size--;
		return data;
	}

	public Iterator iterator() {
		return new MyIterator(head);
	}

	private class MyIterator implements Iterator {
		Node current;

		public MyIterator(Node first) {
			current = first;
		}

		public boolean hasNext() {
			return current !=  null;
		}

		public void remove() {

		}

		public E next() {
			E data = current.data;
			current = current.next;
			return data;
		}
	}
}