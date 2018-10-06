package percolation.wgtunion;
public class WeightedQuickUnion {
	private int[] parent;
	private int[] size;
	private int count;
	public WeightedQuickUnion(int n) {
		count = n;
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}
	public int count() {
		return count;
	}
	public int find(int p) {
		validate(p);
		while (p != parent[p]) {
			p = parent[parent[p]];
		} return p;
	}
	private void validate(int p) {
		int n = parent.length;
		if (p < 0 || p >= n) {
			System.out.println("index " + p + " is not between 0 and " + (n - 1));
		}
	}
	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}
	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) return;
		if (size[rootP] < size[rootQ]) {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		} else {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		}
		count--;
	}
}