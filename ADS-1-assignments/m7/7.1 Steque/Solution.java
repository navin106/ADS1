import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for steque.
 *
 * @param      <E>   { parameter_description }
 */
class Steque<E> {
    /**
     * { var_description }.
     */
    int size = 0;
    /**
     * Class for node.
     */
    private class Node {
        E data;
        Node next;
    }
    /**
     * { var_description }.
     */
    private Node head;
    /**
     * { var_description }.
     */
    private Node tail;
    /**
     * { function_description }.
     *
     * @param      data  The data
     */
    public void push(E data) {
        Node node = new Node();
        node.data = data;
        node.next = head;
        if (head == null) {
            head = node;
            tail = head;
            size++;
            return;
        }
        head = node;
        size++;
    }
/**
 * { function_description }.
 *
 * @param      data  The data
 */
    public void enqueue(E data) {
        Node node = new Node();
        if (head == null) {
            push(data);
        } else {
            node.data = data;
            node.next = null;
            tail.next = node;
            tail = node;
            size++;
        }
    }
/**
 * { function_description }.
 *
 * @return     { description_of_the_return_value }
 *
 * @throws     Exception  { exception_description }
 */
    public E pop() throws Exception {
        if (size == 0) {
            throw new Exception();
        }
        E data = head.data;
        head = head.next;
        size--;
        return data;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        Node thead = head;
        if (thead != null) {
            while (thead.next != null) {
                str += thead.data + ", ";
                thead = thead.next;
            }
            str += thead.data;

        } else {
            return "Steque is empty.";
        }
        str += "";
        return str;

    }

}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    public Solution() {
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < no + 1; i++) {
            Steque<String> stq = new Steque<String>();
            while (sc.hasNext()) {
                String t = sc.nextLine();
                if (t.equals("")) {
                    break;
                }
                String[] tokens = t.split(" ");
                switch (tokens[0]) {
                case "push":
                    stq.push(tokens[1]);
                    System.out.println(stq);
                    break;
                case "pop":
                    try {
                        stq.pop();
                        System.out.println(stq);
                    } catch (Exception e) {
                        System.out.println("Steque is empty.");
                    }
                    break;
                case "enqueue":
                    stq.enqueue(tokens[1]);
                    System.out.println(stq);
                    break;
                default:
                    break;
                }
            }
            System.out.println();
        }
    }
}
