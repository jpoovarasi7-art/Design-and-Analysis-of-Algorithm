import java.util.*;
public class HeapSort {
    protected static int size;
    protected static int[] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        size = scan.nextInt();
        if (size <= 0) {
            System.out.println("Only positive numbers allowed.");
            return;
        }
        arr = new int[size + 1];
        System.out.print("Enter the elements: ");
        for (int i = 1; i <= size; i++) {
            arr[i] = scan.nextInt();
        }
        for (int i = size / 2; i >= 1; i--) {
            heapify(i, size);
        }
        for (int i = size; i > 1; i--) {
            int temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;
            heapify(1, i - 1);
        }
        System.out.print("After Heap Sort: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    private static void heapify(int k, int n) {
        int v = arr[k];
        boolean isHeap = false;
        while (!isHeap && 2 * k <= n) {
            int j = 2 * k;
            if (j < n) {
                if (arr[j] < arr[j + 1]) {
                    j = j + 1;
                }
            }
            if (v >= arr[j]) {
                isHeap = true;
            } else {
                arr[k] = arr[j];
                k = j;
            }
        }
        arr[k] = v;
    }
}
