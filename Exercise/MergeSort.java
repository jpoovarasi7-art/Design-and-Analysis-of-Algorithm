import java.util.*;

public class MergeSort {
    protected static int size;
    protected static int[] arr;

    public static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] l_arr = new int[n1];
        int[] r_arr = new int[n2];
        for (int i = 0; i < n1; ++i)
            l_arr[i] = arr[l + i];
        for (int i = 0; i < n2; ++i)
            r_arr[i] = arr[m + 1 + i];
        int num1 = 0, num2 = 0, num3 = l;
        while (num1 < n1 && num2 < n2) {
            if (l_arr[num1] <= r_arr[num2]) {
                arr[num3] = l_arr[num1];
                num1++;
            } else {
                arr[num3] = r_arr[num2];
                num2++;
            }
            num3++;
        }
        while (num1 < n1) {
            arr[num3] = l_arr[num1];
            num3++;
            num1++;
        }
        while (num2 < n2) {
            arr[num3] = r_arr[num2];
            num3++;
            num2++;
        }
    }

    public static void mergesort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergesort(arr, l, m);
            mergesort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        size = scan.nextInt();
        arr = new int[size];

        System.out.println("Enter the elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scan.nextInt();
        }

        mergesort(arr, 0, size - 1);

        System.out.println("Sorted array:");
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        scan.close();
    }
}
