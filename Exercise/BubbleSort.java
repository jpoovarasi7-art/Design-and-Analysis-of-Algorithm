import java.util.*;
public class BubbleSort
{
   public static void main(String args[])
   {
      int temp;
      boolean flag=false;
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter number of elements in an array:");
      int size = scan.nextInt();
      int []arr;
      arr = new int[size];
      System.out.println("Enter Elements:");
      for(int i=0;i<size;i++)
      {
         arr[i]=scan.nextInt();
      }
      for(int i=0;i<size-1;i++)
      {
         for(int j=0;j<size-1-i;j++)
         {
            if(arr[j] > arr[j+1])
            {
               temp=arr[j];
               arr[j]=arr[j+1];
               arr[j+1]=temp;
               flag = true;
            }
         }
         if(!flag)
            break;
      }
      System.out.println("After BubbleSort of array:");
      for(int i=0;i<size;i++)
      {
         System.out.println(arr[i]+"\t");
      }
   }
}
