import java.util.Scanner;
/**
 * Class for bst.
 */
class Bst {
    /**
     * Class for node.
     */
    private class Node {
        /**
         * book key varoiable.
         */
        private String key;
        /**
         * valvariable.
         */
        private Student val;
        /**
         * left node.
         */
        private Node left;
        /**
         * right node.
         */
        private Node right;
        /**
         * count varible.
         */
        private int  count;
        /**
         * Constructs the object.
         *
         * @param      rollno   The rollno
         * @param      student  The student
         * @param      size     The size
         */
        Node(final String rollno, final Student student, final int size) {
            this.key = rollno;
            this.val = student;
            this.left = null;
            this.right = null;
            this.count = size;



        }


    }

    /**
     * root.
     */
    private Node root;
    /**
     * Constructs the object.
     */
    Bst() {
        this.root = null;
    }
    /**
     * size method.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size(root);
    }
    /**
     * size for root.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int size(final Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.count;

        }
    }
    /**
     * put function. complexity of put method in average is log N complexity of
     * put method in worst case is N.
     *
     * @param      rollno  The rollno
     * @param      st      { parameter_description }
     */
    public void put(final String rollno, final Student st) {
        root = put(root, rollno, st);

    }
    /**
     * helper function.
     *
     * @param      x        { parameter_description }
     * @param      rollno   The rollno
     * @param      student  The student
     *
     * @return     { description_of_the_return_value }
     */
    private Node put(final Node x, final String rollno,
                     final Student student) {

        if (x == null) {
            return new Node(rollno, student, 1);
        }
        int cmp = rollno.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, rollno, student);

        } else if (cmp > 0) {
            x.right = put(x.right, rollno, student);

        } else {
            x.val = student;
        }
        x.count = 1 + size(x.left) + size(x.right);
        return x;

    }
    /**
     * get method.
     * complexity of get method in average is log N
     * complexity of get method in worst case is N.
     *
     *
     * @param      book  The book
     *
     * @return     { description_of_the_return_value }
     */
    public String get(final Double m1, final Double m2) {
        return (get(root, m1, m2));

    }
    /**
     * gethelp.
     *
     * @param      x     { parameter_description }
     * @param      book  The book
     *
     * @return     { description_of_the_return_value }
     */
    private String get(final Node x, final Double m1, final Double m2) {
        String temp = "";
        if (x == null) {
            return null;
        }
        Double cmp = (x.val).gettMarks();
        get(x.left, m1, m2);
        get(x.right, m1, m2);
        if (true) {
            temp += (x.val).getsName();
        }
        return temp;
    }
}

/**
 * Class for student.
 */
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
     * @param      rn    { parameter_description }
     */
    public void setrollNo(final int rn) {
        this.rollNo = rn;
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
     * @param      sn    The serial number
     */
    public void setsName(final String sn) {
        this.sName = sn;
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
     * @param      tm    The time
     */
    public void settMarks(final Double tm) {
        this.tMarks = tm;
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
 * { item_description }
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
        Student st;
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();
        Bst h = new Bst();
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
            if (token1[0].equals("BE")) {
                System.out.println(h.get(Double.parseDouble(token1[1]), Double.parseDouble(token1[2])));
            }
            // if (token1[0].equals("LE")) {
            //     System.out.println(h.get(Double.parseDouble(token1[1])));
            // }
            // if (token1[0].equals("GE")) {
            //     System.out.println(h.get(Double.parseDouble(token1[1])));
            // }
        }
    }
}