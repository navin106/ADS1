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
        private Book key;
        /**
         * valvariable.
         */
        private Integer val;
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
         * @param      book   The book
         * @param      value  The value
         * @param      size   The size
         */
        Node(final Book book, final Integer value, final int size) {
            this.key = book;
            this.val = value;
            // this.left = null;
            // this.right = null;
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
     * put function.
     * complexity of put method in average is log N
     * complexity of put method in worst case is N.
     *
     * @param      book    The book
     * @param      quantity  The volume
     */
    public void put(final Book book, final Integer quantity) {
        root = put(root, book, quantity);

    }
    /**
     * helper function.
     *
     * @param      x       { parameter_description }
     * @param      book    The book
     * @param      quantity  The volume
     *
     * @return     { description_of_the_return_value }
     */
    private Node put(final Node x, final Book book,
                     final Integer quantity) {

        if (x == null) {
            return new Node(book, quantity, 1);
        }
        int cmp = book.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, book, quantity);

        } else if (cmp > 0) {
            x.right = put(x.right, book, quantity);

        } else {
            x.val = quantity;
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
    public Integer get(final Book book) {
        return (get(root, book));

    }
    /**
     * gethelp.
     *
     * @param      x     { parameter_description }
     * @param      book  The book
     *
     * @return     { description_of_the_return_value }
     */
    private Integer get(final Node x, final Book book) {
        if (x == null) {
            return null;
        }
        int cmp = book.compareTo(x.key);
        if (cmp < 0) {
            return  get(x.left, book);

        } else if (cmp > 0) {
            return  get(x.right, book);

        }
        return x.val;
    }

    /**
     * minimum function method.
     *
     * @return     { description_of_the_return_value }
     */
    public Book min() {
        return min(root).key;

    }
    /**
     * min function.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Node min(final Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);

    }
    /**
     * minimum function method.
     *
     * @return     { description_of_the_return_value }
     */
    public Book max() {
        return max(root).key;

    }
    /**
     * max function.
     *
     * @param      x     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Node max(final Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);

    }

    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Book select(final int k) {
        if (k < 0 || k >= size()) {
        throw new IllegalArgumentException(
                "argument  is invalid: " + k);
        }
        Node x = select(root, k);
        return x.key;
    }

    /**
     * select method.
     *
     * @param      x     { parameter_description }
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private Node select(final Node x, final int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if      (t > k) {
            return select(x.left,  k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else  {
            return x;
        }
    }
    /**
     * Returns the largest key less than or equal to key .
     *
     * @param  key the key
     * @return the largest key in the symbol table less than
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Book floor(final Book key) {
        if (key == null) {
            throw new IllegalArgumentException(
                "argument to floor() is null");
        }
        Node x = floor(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * floor function.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node floor(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp <  0) {
            return floor(x.left, key);
        }
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }
    /**
     * Returns the smallest key greater than or equal to key.
     *
     * @param  key the key
     * @return the smallest key in the symbol table greater than or equal.
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Book ceiling(final Book key) {
        if (key == null) {
            throw new IllegalArgumentException("argument is null");
        }
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        } else {
            return x.key;
        }
    }
    /**
     * ceiling function.
     *
     * @param      x     { parameter_description }
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */
    private Node ceiling(final Node x, final Book key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) {
                return t;
            } else {
                return x;
            }
        }
        return ceiling(x.right, key);
    }
}
/**
 * Class for book.
 */
class Book {
    /**
     * { var_description }.
     */
    private String bookName;
    /**
     * { var_description }.
     */
    private String bookAuthor;
    /**
     * { var_description }.
     */
    private double bookPrice;
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String getbookName() {
        return bookName;
    }

    /**
     * { function_description }.
     *
     * @param      bName  The book name
     */
    public void setbookName(final String bName) {
        this.bookName = bName;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String getbookAuthor() {
        return bookAuthor;
    }

    /**
     * { function_description }.
     *
     * @param      bAuthor  The book author
     */
    public void setbookAuthor(final String bAuthor) {
        this.bookAuthor = bAuthor;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public double getbookPrice() {
        return bookPrice;
    }

    /**
     * { function_description }.
     *
     * @param      bPrice  The book price
     */
    public void setbookPrice(final double bPrice) {
        this.bookPrice = bPrice;
    }
    /**
     * Constructs the object.
     *
     * @param      nm    { parameter_description }
     * @param      an    { parameter_description }
     * @param      pr    { parameter_description }
     */
    Book(final String nm, final String an,
         final double pr) {
        this.bookName = nm;
        this.bookAuthor = an;
        this.bookPrice = pr;
    }
    /**
     * { function_description }.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Book that) {
        if (this.getbookName().compareTo(that.getbookName()) > 0) {
            return 1;
        }
        if (this.getbookName().compareTo(that.getbookName()) < 0) {
            return -1;
        }
        if (this.getbookAuthor().compareTo(that.getbookAuthor()) > 0) {
            return 1;
        }
        if (this.getbookAuthor().compareTo(that.getbookAuthor()) < 0) {
            return -1;
        }
        if (this.getbookPrice() > that.getbookPrice()) {
            return 1;
        }
        if (this.getbookPrice() < that.getbookPrice()) {
            return -1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
return this.getbookName()
+ ", " + this.getbookAuthor() + ", "
+ this.getbookPrice();
    }
}
/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object for checkstyle.
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
        Bst bst = new Bst();
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(",");

            switch (tokens[0]) {
            case"put":
                bst.put(
new Book(tokens[1], tokens[2],
Double.parseDouble(tokens[2 + 1])),
Integer.parseInt(tokens[2 + 2]));
                break;
            case"get":
                System.out.println(
bst.get((new Book(tokens[1],
tokens[2], Double.parseDouble(tokens[2 + 1])))));
                break;
            case"min":
                System.out.println(bst.min());
                break;
            case"max":
                System.out.println(bst.max());
                break;
            case"select":
                System.out.println(
bst.select(Integer.parseInt(tokens[1])));
                break;
            case"floor":
                System.out.println(
bst.floor(new Book(tokens[1], tokens[2],
Double.parseDouble(tokens[2 + 1]))));
                break;
            case"ceiling":
                System.out.println(
bst.ceiling(new Book(tokens[1], tokens[2],
Double.parseDouble(tokens[2 + 1]))));
                break;
            default:
                break;
            }
        }
    }
}