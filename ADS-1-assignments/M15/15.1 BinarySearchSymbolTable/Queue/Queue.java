package Queue;
import java.util.Iterator;
/**
 * List of .
 *
 * @param      <E>   { parameter_description }
 */
public class Queue<E> implements Iterable<E> {
    /**
     * Class for node.
     */
    private class Node {
        /**
         * data.
         */
        E data;
        /**
         * node next.
         */
        Node next;
    }
    /**
     * initiated head, tail.
     */
    private Node head, tail;
    /**
     * size.
     */
    private int size = 0;
    /**
     * { function_description }
     *
     * @param      data  The data
     */
    public void enqueue(E data) {
        Node node = new Node();
        node.data = data;
        size++;
        if (tail == null) {
            tail = node;
            head = node;
            return;
        }
        tail.next = node;
        tail = tail.next;
    }
    /**
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public E dequeue() {
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
    public Iterator iterator() {
        return new MyIterator(head);
    }
    /**
     * Class for my iterator.
     */
    private class MyIterator implements Iterator {
        /**
         * { var_description }
         */
        Node current;
        /**
         * Constructs the object.
         *
         * @param      first  The first
         */
        public MyIterator(Node first) {
            current = first;
        }
        /**
         * Determines if it has next.
         *
         * @return     True if has next, False otherwise.
         */
        public boolean hasNext() {
            return current !=  null;
        }
        /**
         * { function_description }
         */
        public void remove() {

        }
        /**
         * { function_description }
         *
         * @return     { description_of_the_return_value }
         */
        public E next() {
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}
