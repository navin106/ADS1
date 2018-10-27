import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for hash table.
 */
class HashTable {
    /**
     * Class for node.
     */
    class Node {
        /**
         * word as key.
         */
        private String key;
        /**
         * count as value.
         */
        private Student val;
        /**
         * next node.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      k     { parameter_description }
         * @param      v     { parameter_description }
         * @param      n     { parameter_description }
         */
        Node(final String k, final Student v, final Node n) {
            this.key = k;
            this.val = v;
            this.next = n;
        }
        /**
         * { function_description }.
         *
         * @return     { description_of_the_return_value }
         */
        public String getkey() {
            return key;
        }

        /**
         * { function_description }.
         *
         * @param      keyy  The key
         */
        public void setkey(final String keyy) {
            this.key = keyy;
        }
        /**
         * Gets the value.
         *
         * @return     The value.
         */
        public Student getValue() {
            return val;
        }

        /**
         * Sets the value.
         *
         * @param      valu  The value
         */
        public void setValue(final Student valu) {
            this.val = valu;
        }
        /**
         * sets value.
         *
         * @param      v     { parameter_description }
         */
        void setvalue(final Student v) {
            this.val = v;
        }
    }
    /**
     * nodes table.
     */
    private Node[] st;
    /**
     * size.
     */
    private int s = 100;
    /**
     * Constructs the object.
     */
    HashTable() {
        st = new Node[s];
    }
    /**
     * hash.
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    int hash(final String k) {
        final Integer num = 0x7fffffff;
        return (k.hashCode() & num) % s;
    }
    /**
     * resizes.
     */
    public void resize() {
        st = Arrays.copyOf(st, 2 * s);
    }
    /**
     * put.
     * Best case: O(k)
     * Average case: O(K)
     * Worst case: O(logN)
     * @param      k     { parameter_description }
     * @param      v     { parameter_description }
     */
    public void put(final String k, final Student v) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                x.setvalue(v);
                return;
            }
        }
        if (i >= st.length) {
            resize();
        }
        st[i] = new Node(k, v, st[i]);
    }
    /**
     * get.
     * Best case: O(k)
     * Average case: O(K)
     * Worst case: O(logN)
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Student get(final String k) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                /*if (x.getValue() > 0) {
                    x.setvalue(x.getValue() - 1);
                    return true;
                }
                return false;*/
                return x.val;
            }
        }
        return null;
    }
}
class Student {
    /**
     * rollno.
     */
    private int rollNo;
    /**
     * student name.
     */
    private String sName;
    /**
     * total marks.
     */
    private Double tMarks;
    /**
     * get fuction for rollno.
     *
     * @return     { description_of_the_return_value }
     */
    public int getrollNo() {
        return rollNo;
    }

    /**
     * set function for rool no.
     *
     * @param      rollNo  The roll no
     */
    public void setrollNo(int rollNo) {
        this.rollNo = rollNo;
    }
    /**
     * get function for student name.
     *
     * @return     { description_of_the_return_value }
     */
    public String getsName() {
        return sName;
    }

    /**
     * set function for student name.
     *
     * @param      sName  The s name
     */
    public void setsName(String sName) {
        this.sName = sName;
    }
    /**
     * get function for student marks.
     *
     * @return     { description_of_the_return_value }
     */
    public Double gettMarks() {
        return tMarks;
    }

    /**
     * set function for student marks.
     *
     * @param      tMarks  The t marks
     */
    public void settMarks(Double tMarks) {
        this.tMarks = tMarks;
    }
    /**
     * Constructs the object.
     *
     * @param      rl    { parameter_description }
     * @param      sn    The serial number
     * @param      tm    The time
     */
    Student(final int rl, final String sn, final Double tm) {
        this.rollNo = rl;
        this.sName = sn;
        this.tMarks = tm;
    }
}
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
    public static void main(final String[] args) {
        Student st;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();
        HashTable h = new HashTable();
        for (int i = 0; i < a; i++) {
            String[] token = sc.nextLine().split(",");
            h.put(token[0], new Student(
                      Integer.parseInt(token[0]),
                      token[1], Double.parseDouble(
                          token[2])));
        }
        int b = sc.nextInt();
        sc.nextLine();
        for (int j = 0; j < b; j++) {
            String[] token1 = sc.nextLine().split(" ");
            if (token1[2].equals("1")) {
                if (h.get(token1[1]) != null) {
                    System.out.println((h.get(token1[1])).getsName());
                } else {
                    System.out.println("Student doesn't exists...");
                }
            }
            if (token1[2].equals("2")) {
                if (h.get(token1[1]) != null) {
                    System.out.println((h.get(token1[1])).gettMarks());
                } else {
                    System.out.println("Student doesn't exists...");
                }
            }

        }
    }
}