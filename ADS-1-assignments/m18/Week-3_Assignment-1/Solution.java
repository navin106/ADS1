import java.util.Scanner;
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
		while (!(sc.next().equals("0"))) {
			MinPQ<CompanyDetails> minpq = new MinPQ<CompanyDetails>(no);
			MaxPQ<CompanyDetails> maxpq = new MaxPQ<CompanyDetails>(no);
			while (no > 0) {
				String sk1 = sc.nextLine();
				// float f = Float.parseFloat(sk[1]);
				if (sk1.length() > 1) {
					String[] sk = sk1.split(",");
					CompanyDetails cd = new CompanyDetails(sk[0], Float.valueOf(sk[1]));
					minpq.insert(cd);
					maxpq.insert(cd);
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
			/*for(CompanyDetails k1: minpq) {
				System.out.println(k1);
			}*/
			/*for (int i=0; i<minpq.size(); i++) {
				System.out.println(minpq.delMin());
			}*/
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
		} else if (this.getpercent() > that.getpercent()) {
			return 1;
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