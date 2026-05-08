import java.util.Scanner;

public class QuickSort {
        protected static int size,m,n1,n2;
        protected static int[] arr,l_arr,r_arr;
        static int partition(int []arr,int low,int high)
        {
           int pivot = arr [low];
           int i =low-1;
           int j = high +1;
           while(true)
           {
              do{
                 i++;
              }
              while(arr[i]<pivot);
              do{
                 j--;
              }
              while(arr[j]>pivot);
              if(i>=j)
              {
                 return j;
              }
              swap(arr,i,j);
           }
        }
        static void swap (int []arr,int i, int j)
        {
              int temp=arr[i];
              arr[i]=arr[j];
              arr[j]=temp;
        }
        public static void quickSort (int []arr,int l,int m)
        {
              if (l<m)
              {
                 int pi = partition(arr,l,m);
                 quickSort(arr,l,pi);
                 quickSort(arr,pi+1,m);
              }
        }
        public static void main(String args[])
           {
              Scanner scan = new Scanner(System.in);
              System.out.println("Enter the size of the array:");
              size = scan.nextInt();
              arr = new int[size];
              System.out.println("Enter the element:");
              for(int i=0;i<size;i++)
              {
                 arr[i]=scan.nextInt();
              }
              quickSort(arr, 0, size-1);
              System.out.println("After Quick Sort the given array:");
              for(int i=0;i<size;i++)
                 System.out.println(arr[i]);
              System.out.println();
           }
}
