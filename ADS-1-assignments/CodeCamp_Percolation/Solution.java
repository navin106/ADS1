// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }
// You can implement the above API to solve the problem

import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Percolation p;
		int a = s.nextInt();
		while (s.nextLine() != null) {
			p = new Percolation(a);
			String[] token = s.nextLine().split(" ");
			p.open(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
		}
	}
}