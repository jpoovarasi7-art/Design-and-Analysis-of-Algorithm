import java.util.*;
public class SelectionSort
{
   public static void main(String args[])
   {
      int min_element,temp;
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the size of the array:");
      int size = scan.nextInt();
      int []arr;
      arr = new int[size];
      System.out.println("Enter Elements:\t");
      for(int i=0;i<size;i++)
      {
         arr[i] = scan.nextInt();
      }
      for(int i=0;i<size-1;i++)
      {
         min_element = i;
         for(int j=i+1;j<size;j++)
         {
            if(arr[min_element]>arr[j])
            {
               min_element = j;
            }
         }
         if (min_element!=i) {
         temp = arr[min_element];
         arr[min_element]=arr[i];
         arr[i]=temp; }
      }
      System.out.println("After Selection Sort of the given array:\t");
      for(int i=0;i<size;i++)
      {
         System.out.println(arr[i]);
      }
   }
}
