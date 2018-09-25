public class Percolation {
	private boolean[][] opened;
	private int top = 0;
	private int bottom;
	private int size;
	private WeightedQuickUnion qf;
	private int count = 0;

	public Percolation(int N) {
		size = N;
		bottom = (N * N) + 1;
		qf = new WeightedQuickUnion((N * N) + 2);
		opened = new boolean[N][N];
	}

	public void open(int row, int col) {
		if (!isOpen(row, col)) {
			opened[row - 1][col - 1] = true;
			count++;
		}
		if (row == 1) {
			qf.union(getQFIndex(row, col), top);
		}
		if (row == size) {
			qf.union(getQFIndex(row, col), bottom);
		}
		if (row > 1 && isOpen(row - 1, col)) {
			qf.union(getQFIndex(row, col), getQFIndex(row - 1, col));
		}
		if (row < size && isOpen(row + 1, col)) {
			qf.union(getQFIndex(row, col), getQFIndex(row + 1, col));
		}
		if (col > 1 && isOpen(row, col - 1)) {
			qf.union(getQFIndex(row, col), getQFIndex(row, col - 1));
		}
		if (col < size && isOpen(row, col + 1)) {
			qf.union(getQFIndex(row, col), getQFIndex(row, col + 1));
		}
	}
	public boolean isOpen(int row, int col) {
		return opened[row - 1][col - 1];
	}
	public boolean isFull(int row, int col) {
		if (0 < row && row <= size && 0 < col && col <= size) return qf.connected(top, getQFIndex(row, col));
		return false;
	}
	public int numberOfOpenSites() {
		return count;
	}
	public boolean percolates() {
		return qf.connected(top, bottom);
	}
	private int getQFIndex(int row, int col) {
		return size * (row - 1) + col;
	}
}