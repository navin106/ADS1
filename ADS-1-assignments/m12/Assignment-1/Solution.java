import java.util.Scanner;
import java.util.Arrays;
class Student implements Comparable<Student> {
	private String sname;
	private String dateofbirth;
	private String mark1;
	private String mark2;
	private String mark3;
	private String totalmark;
	private String reservation;
	public String getsname() {
		return sname;
	}

	public void setsname(String sname) {
		this.sname = sname;
	}
	public String getdateofbirth() {
		return dateofbirth;
	}

	public void setdateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getmark1() {
		return mark1;
	}

	public void setmark1(String mark1) {
		this.mark1 = mark1;
	}
	public String getmark2() {
		return mark2;
	}

	public void setmark2(String mark2) {
		this.mark2 = mark2;
	}
	public String getmark3() {
		return mark3;
	}

	public void setmark3(String mark3) {
		this.mark3 = mark3;
	}
	public String gettotalmark() {
		return totalmark;
	}

	public void settotalmark(String totalmark) {
		this.totalmark = totalmark;
	}
	public String getreservation() {
		return reservation;
	}

	public void setreservation(String reservation) {
		this.reservation = reservation;
	}
	public Student(String nm, String db, String m1, String m2, String m3, String tm, String rc) {
		this.sname = nm;
		this.dateofbirth = db;
		this.mark1 = m1;
		this.mark2 = m2;
		this.mark3 = m3;
		this.totalmark = tm;
		this.reservation = rc;
	}
	public int compareTo(Student that) {
		if (Integer.parseInt(this.gettotalmark()) > Integer.parseInt(that.gettotalmark())) {
			return 1;
		} else if (Integer.parseInt(this.getmark3()) < Integer.parseInt(that.getmark3())) {
			return -1;
		} else if (Integer.parseInt(this.getmark2()) < Integer.parseInt(that.getmark2())) {
			return -1;
		} else if (Integer.parseInt(this.getmark1()) < Integer.parseInt(that.getmark1())) {
			return -1;
		} else {
			return 0;
		}
	}
	public String toString() {
		String str = "";
		str += this.sname + "," + this.totalmark + "," + this.reservation;
		return str;
	}
}
class Insertion {
	/**
	 * this methood sorts the given arraylist.
	 *  according to the reuired specifications.
	 *
	 * @param      td    { parameter_description }
	 */
	public void sort(Comparable[] td) {
		for (int i = 0; i < td.length; i++) {
			for (int j = i; j > 0; j--) {
				if (more(td, j, j - 1)) {
					swap(td, j, j - 1);
				}

			}

		}

	}
	/**
	 * return true or false after comparing the objects.
	 *
	 * @param      td    { parameter_description }
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean more(Comparable[] td, int i, int j) {
		return td[i].compareTo(td[j]) > 0;
	}
	/**
	 * swap the elements in arraylist of i,j
	 *
	 * @param      td    { parameter_description }
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 */
	public void swap (Comparable[] td, int i, int j) {
		Comparable temp = td[i];
		td[i] = td[j];
		td[j] = temp;
	}
	public String results(Student[] td, int noOfVacancies, int noOfUnRes, int noBC, int noSC, int noST) {
		/*System.out.println(noBC);
		System.out.println(noSC);
		System.out.println(noST);*/
		sort(td);
		int i = 0;
		int bc = 0;
		int sc = 0;
		int st = 0;
		String str = "";
		String nstr = "";
		for (int z = 0; z < td.length; z++) {
			str += td[z].toString() + "\n";
			if (i < noOfVacancies) {
				if (z < noOfUnRes) {
					nstr += td[z].toString() + "\n";
				} else if (bc < noBC) {
					// System.out.println(td[z].getreservation());
					if (td[z].getreservation().equals("BC")) {
						nstr += td[z].toString() + "\n";
						bc++;
					}else{
						i--;
					}
				} else if (sc < noSC) {
					// System.out.println(td[z].getreservation());
					if (td[z].getreservation().equals("SC")) {
						nstr += td[z].toString() + "\n";
						sc++;
					}else{
						i--;
					}
				} else if (st < noST) {
					// System.out.println(td[z].getreservation());
					if (td[z].getreservation().equals("ST")) {
						nstr += td[z].toString() + "\n";
						st++;
					} else{
						i--;
					}
				} else {
					i--;
				}

			}
			i++;
		}
		str += "\n" + nstr;
		return str;
	}
}


public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// MergeSort ms = new MergeSort();
		Insertion ms = new Insertion();
		int noOfStudents = sc.nextInt();
		int noOfVacancies = sc.nextInt();
		int noOfUnRes = sc.nextInt();
		int noBC = sc.nextInt();
		int noSC = sc.nextInt();
		int noST = sc.nextInt();
		// sc.nextLine();
		Student[] student = new Student[noOfStudents];
		int ssize = 0;
		while ( ssize < 23) {
			String[] tokens = sc.nextLine().split(",");
			student[ssize++] = new Student(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
		}
		ms.sort(student);
		System.out.println(ms.results(student, noOfVacancies, noOfUnRes, noBC, noSC, noST));
	}
}