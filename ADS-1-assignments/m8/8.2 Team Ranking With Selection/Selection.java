import java.util.ArrayList;
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
        } else if (this.getloss() < ptd.getloss()) {
            return 1;
        } else if (this.getloss() > ptd.getloss()) {
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
 * Class for Selection.
 */
public class Selection {
    /**
     * this methood sorts the given arraylist.
     *  according to the reuired specifications.
     *complexity is N^2
     * @param      td    { parameter_description }
     */
    public void sort(ArrayList<Comparable> td) {
        for (int i = 0; i < td.size(); i++) {
            for (int j = i; j < td.size(); j++) {
                if (less(td, i, j)) {
                    swap(td, i, j);
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
    public boolean less(ArrayList<Comparable> td, int i, int j) {
        return td.get(i).compareTo(td.get(j)) < 0;
    }
    /**
     * swap the elements in arraylist of i,j
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
     *returns the sorted elements.
     *complexity for this method is N.
     *
     * @param      td    { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public String results(ArrayList<Comparable> td) {
        sort(td);
        String str = "";
        for (Comparable t : td) {
            // System.out.println(t);
            str += t.toString() + ",";
        }
        return str.substring(0, str.length() - 1);
    }
}
