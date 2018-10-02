import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        TeamDetails td;
        Selection is = new Selection();
        ArrayList<Comparable> team = new ArrayList<Comparable>();
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(",");
            team.add(new TeamDetails(tokens[0],
             Integer.parseInt(tokens[1]),
            Integer.parseInt(tokens[2]),
             Integer.parseInt(tokens[2 + 1])));
            // System.out.println(team);
        }
        System.out.println(is.results(team));
    }
}
