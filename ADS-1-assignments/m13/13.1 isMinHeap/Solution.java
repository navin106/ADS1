import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for is minimum heap.
 *
 * @param      <E>   { parameter_description }
 */
class IsMinHeap<E> {
    /**
     * Constructs the object.
     */
    IsMinHeap() {

    }
    /**
     * checkminheap.
     * complexity is N
     *
     * @param      array  The array
     *
     * @return     { description_of_the_return_value }
     */
    public boolean checkminheap(final Comparable[] array) {
       /* boolean flag = true;
        if (array.length == 0) {
            return false;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (!(array[i].compareTo(array[i + 1]) <= 0)) {
                flag = false;
                return flag;
            }

        }
        return flag;
    }
*/
    for (int i = 0; i < array.length; i++) {
            if (2 * i + 1 < array.length && 2 * i + 2 < array.length) {
                if (array[i].compareTo(array[2 * i + 1]) > 0
                 || array[i].compareTo(array[2 * i + 2]) > 0) {
                    return false;
                }
            }

        }
        return true;
    }
}
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
        String k = sc.next();
        int no = sc.nextInt();
        sc.nextLine();
        while (no > 0) {
            String inp1 = sc.nextLine();
            String[] inp = inp1.split(",");
            if (inp1.length() > 0) {
                switch (k) {
                case "String" :
                    IsMinHeap
                    <String> datatype = new IsMinHeap<>();
                    System.out.println(datatype
                        .checkminheap(inp));
                    break;
                case "Double":
                    IsMinHeap
                    <Double> ddatatype = new IsMinHeap<>();
                    Double[] dinp = Arrays.stream(inp)
                    .map(Double::valueOf)
                    .toArray(Double[]::new);
                    System.out.println(ddatatype
                        .checkminheap(dinp));
                    break;
                case "Integer":
                    IsMinHeap
                    <Integer> idatatype = new IsMinHeap<>();
                    Integer[] iinp = Arrays.stream(inp)
                    .map(Integer::valueOf)
                    .toArray(Integer[]::new);
                    System.out.println(idatatype
                        .checkminheap(iinp));
                    break;
                case "Float":
                    IsMinHeap
                    <Float> fdatatype = new IsMinHeap<>();
                    Float[] finp = Arrays.stream(inp)
                    .map(Float::valueOf)
                    .toArray(Float[]::new);
                    System.out.println(fdatatype
                        .checkminheap(finp));
                    break;
                default:
                    break;
                }
            } else {
                System.out.println("false");
            }
            no--;
        }
    }
}
