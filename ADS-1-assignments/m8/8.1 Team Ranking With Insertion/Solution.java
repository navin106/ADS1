import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
	}
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TeamDetails td;
		Insertion is = new Insertion();
		ArrayList<Comparable> team = new ArrayList<Comparable>();
		while (sc.hasNextLine()) {
			String[] tokens = sc.nextLine().split(",");
			team.add(new TeamDetails(tokens[0], Integer.parseInt(tokens[1]),
			                         Integer.parseInt(tokens[2]), Integer.parseInt(tokens[2 + 1])));
			// System.out.println(team);
		}
		System.out.println(is.results(team));
	}
}
/**
 * Class for team details.
 */
class TeamDetails implements Comparable<TeamDetails> {
	/**
	 * { var_description }
	 */
	private String name;
	/**
	 * { function_description }.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String getname() {
		return name;
	}
	/**
	 * { function_description }
	 *
	 * @param      name  The name
	 */
	public void setname(String name) {
		this.name = name;
	}
	/**
	 * { var_description }.
	 */
	private int wins;
	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int getwins() {
		return wins;
	}

	/**
	 * { function_description }
	 *
	 * @param      wins  The wins
	 */
	public void setwins(int wins) {
		this.wins = wins;
	}
	/**
	 * { var_description }
	 */
	private int loss;

	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int getloss() {
		return loss;
	}

	/**
	 * { function_description }
	 *
	 * @param      loss  The loss
	 */
	public void setloss(int loss) {
		this.loss = loss;
	}
	/**
	 * { var_description }.
	 */
	private int draw;

	/**
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int getdraw() {
		return draw;
	}

	/**
	 * { function_description }
	 *
	 * @param      draw  The draw
	 */
	public void setdraw(int draw) {
		this.draw = draw;
	}
	/**
	 * Constructs the object.
	 *
	 * @param      nm    { parameter_description }
	 * @param      w     { parameter_description }
	 * @param      l     { parameter_description }
	 * @param      d     { parameter_description }
	 */
	public TeamDetails(String nm, int w, int l, int d) {
		this.name = nm;
		this.wins = w;
		this.loss = l;
		this.draw = d;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		return this.name;
	}
	/**
	 * { function_description }
	 *
	 * @param      ptd   The ptd
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int compareTo(TeamDetails ptd) {
		if (this.getwins() > ptd.getwins()) {
			return 1;
		} else if (this.getwins() < ptd.getwins()) {
			return -1;
		} else if (this.getloss() > ptd.getloss()) {
			return 1;
		} else if (this.getloss() < ptd.getloss()) {
			return -1;
		} else if (this.getdraw() > ptd.getdraw()) {
			return 1;
		} else if (this.getdraw() < ptd.getdraw()) {
			return -1;
		} else {
			return 0;
		}

	}

}
/**
 * Class for insertion.
 */
class Insertion {
	/**
	 * Constructs the object.
	 *
	 * @param      td    { parameter_description }
	 */
	public void sort(ArrayList<Comparable> td) {
		for (int i = 1; i < td.size(); i++) {
			for (int j = i-1; j > 0; j--) {
				if (more(td, i, j)) {
					swap(td, i, j);
				}

			}

		}

	}
	/**
	 * { function_description }
	 *
	 * @param      td    { parameter_description }
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean more(ArrayList<Comparable> td, int i, int j) {
		return td.get(i).compareTo(td.get(j)) > 0;
	}
	/**
	 * { function_description }
	 *
	 * @param      td    { parameter_description }
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 */
	public void swap (ArrayList<Comparable> td, int i, int j) {
		Comparable temp = td.get(i);
		td.set(i, td.get(j));
		td.set(j, temp);
	}
	/**
	 * { function_description }
	 *
	 * @param      td    { parameter_description }
	 */
	public String results(ArrayList<Comparable> td) {
		sort(td);
		String str = "";
		for (Comparable t : td) {
			str += t.toString() + ",";
		}
		return str.substring(0, str.length() - 1);
	}
}