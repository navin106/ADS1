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
        private Integer val;
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
        Node(final String k, final Integer v, final Node n) {
            this.key = k;
            this.val = v;
            this.next = n;
        }
        /**
         * { function_description }
         *
         * @return     { description_of_the_return_value }
         */
        public String getkey() {
            return key;
        }

        /**
         * { function_description }
         *
         * @param      key   The key
         */
        public void setkey(String key) {
            this.key = key;
        }
        /**
         * Gets the value.
         *
         * @return     The value.
         */
        public Integer getValue() {
            return val;
        }

        /**
         * Sets the value.
         *
         * @param      val   The value
         */
        public void setValue(Integer val) {
            this.val = val;
        }
        /**
         * sets value.
         *
         * @param      v     { parameter_description }
         */
        void setvalue(final Integer v) {
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
    private int s = 2;
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
    public void put(final String k, final Integer v) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                x.setvalue(x.getValue() + 1);
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
    public boolean get(final String k) {
        int i = hash(k);
        for (Node x = st[i]; x != null; x = x.next) {
            if (k.equals(x.getkey())) {
                if (x.getValue() > 0) {
                    x.setvalue(x.getValue() - 1);
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
/**
 * Solution class.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused.
    }
    /**
     * main.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        String[] tokens1 = sc.nextLine().split(" ");
        String[] tokens2 = sc.nextLine().split(" ");
        HashTable h = new HashTable();
        for (int i = 0; i < m; i++) {
            h.put(tokens1[i], 1);
        }
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (!h.get(tokens2[i])) {
                flag = false;
                System.out.println("No");
                break;
            }
        }
        if (flag) {
            System.out.println("Yes");
        }
    }
}
