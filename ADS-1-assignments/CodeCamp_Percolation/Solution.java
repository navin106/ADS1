// public class Percolation {
//    public Percolation(int n)
// create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)
// open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)
// is site (row, col) open?
//    public boolean isFull(int row, int col)
// is site (row, col) full?
//    public     int numberOfOpenSites()
// number of open sites
//    public boolean percolates()
// does the system percolate?
// }
// You can implement the above API to solve the problem

import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		Percolation p = new Percolation(a);
		while (s.hasNext()) {
			p.open(s.nextInt(), s.nextInt());
		}
		System.out.println(p.percolates());
	}
}
