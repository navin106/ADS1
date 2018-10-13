import java.util.Scanner;
import java.util.*;
// import java.util.ArrayList;
public class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int no = sc.nextInt();
		sc.nextLine();
		int k = no;
		float percent = 0.0f;
		while (sc.hasNext()) {
			MinPQ<CompanyDetails> minpq = new MinPQ<CompanyDetails>(no);
			MaxPQ<CompanyDetails> maxpq = new MaxPQ<CompanyDetails>(no);
			int nno = 0;
			while (no > 0) {
				if (sc.hasNextLine()) {
					String sk1 = sc.nextLine();
					if (!(sk1.length() == 1)) {
						String[] sk = sk1.split(",");
						if (sk.length == 2) {
							CompanyDetails cd = new CompanyDetails(sk[0], Float.valueOf(sk[1]));
							minpq.insert(cd);
							maxpq.insert(cd);
						} else if (sk1.length() == 3) {
							sk = sk1.split(",");
							switch (sk[0]) {
							case "get":
								if (sk[1].equals("maxST")) {
									System.out.println("0");
								}
								if (sk[1].equals("minST")) {
									System.out.println("0");

								}
								break;
							default:
								break;

							}


						}
					} else if (sk1.length() == 1) {
						nno = Integer.parseInt(sk1);
					}
				}
				// MinPQ mi = new CompanyDetails(sk[0], Float.valueOf(sk[1]));
				// if (f > percent) {
				// } else {
				// }
				// if (maxpq.size() - minpq.size() > 1) {
				// 	CompanyDetails tcd = maxpq.delMax();
				// 	minpq.insert(tcd);
				// }
				// if (minpq.size() - maxpq.size() > 1) {
				// 	CompanyDetails tcd = minpq.delMin();
				// 	maxpq.insert(tcd);
				// }
				no--;
			}

			/*for (int i = 0; i < minpq.size(); i++) {
				System.out.println(minpq.delMin());
			}
			for (int i = 0; i < maxpq.size(); i++) {
				System.out.println(maxpq.delMax());
			}*/
			try {
				int nu = 5;
				while (nu > 0) {
					System.out.println(maxpq.delMax());
					nu--;
				}
				nu = 5;
				System.out.println();
				while (nu > 0) {
					System.out.println(minpq.delMin());
					nu--;
				}
				nu = 5;
				System.out.println();
				no = k;
			} catch (NoSuchElementException e) {
				System.out.println("");

			}

			nno = 0;
		}
	}
}
class CompanyDetails implements Comparable<CompanyDetails> {
	private String companyname;
	private float percent;
	public String getcompanyname() {
		return companyname;
	}

	public void setcompanyname(String companyname) {
		this.companyname = companyname;
	}
	public float getpercent() {
		return percent;
	}

	public void setpercent(float percent) {
		this.percent = percent;
	}
	CompanyDetails(String cn, float pcnt) {
		this.companyname = cn;
		this.percent = pcnt;
	}
	public int compareTo(final CompanyDetails that) {
		if (this.getpercent() < that.getpercent()) {
			return -1;
		}
		if (this.getpercent() > that.getpercent()) {
			return 1;
		}
		if (this.getcompanyname().compareTo(that.getcompanyname()) > 0) {
			return 1;
		}
		if (this.getcompanyname().compareTo(that.getcompanyname()) < 0) {
			return -1;
		} else {
			return 0;
		}

	}
	public String toString() {
		String str = "";
		str += companyname + " " + percent;
		return str;
	}
}