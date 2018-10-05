import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
    private Solution() {}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MergeSort st = new MergeSort();
        while (sc.hasNext()) {
            String[] tokens = sc.nextLine().split(",");
            st.sort(tokens);
            String str = "[";
            int i;
            for (i = 0; i < tokens.length - 1; i++) {
                str += tokens[i] + ", ";
            }
            str += tokens[i] + "]";
            System.out.println(str);
            System.out.println();
        }
    }
}

/**
 * Class for merge sort.
 */
class MergeSort {
    final int cutoff = 7;
    /**
     * Constructs the object.
     */
    MergeSort() {}
    public void sort(Comparable[] arr) {
        Comparable[] aux = new Comparable[arr.length];
        for (int i = 0; i < arr.length; i++) {
            aux[i] = arr[i];
        }
        sort(aux, arr, 0, arr.length - 1);
    }
    public void sort(final Comparable[] arr, final Comparable[] aux, int lo, int high) {
        if (high <= lo + cutoff) {
            insertionSort(aux, lo, high);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid =  lo + (high - lo) / 2;
        sort(aux, arr, lo , mid);
        sort(aux, arr, mid + 1, high);
        if (!less(arr[mid + 1], arr[mid])) {
            for (int i = lo; i <= high; i++) {
                aux[i] = arr[i];
            }
            System.out.println("Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(arr, aux, lo, mid, high);
    }
    public boolean isSorted(final Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    public boolean isSorted(final Comparable[] a,
                            final int lo, final int high) {
        for (int i = lo + 1; i <= high; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
    public void merge(final Comparable[] arr, final Comparable[] aux,
                      final int lo, final int mid, final int high) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= high; k++) {
            if (i > mid) {
                aux[k] = arr[j++];
            } else if (j > high) {
                aux[k] = arr[i++];
            } else if (less(arr[j], arr[i])) {
                aux[k] = arr[j++];
            } else {
                aux[k] = arr[i++];
            }
        }
    }
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
    public void insertionSort(final Comparable[] a,
                              final int lo, final int high) {
        for (int i = lo; i <= high; i++) {
            for (int j = i; j > lo; j--) {
                if (less(a[j], a[j - 1])) {
                    swap(a, j, j - 1);
                }
            }
        }
    }
    public void swap(final Comparable[] a,
                     final int i, final int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

}
