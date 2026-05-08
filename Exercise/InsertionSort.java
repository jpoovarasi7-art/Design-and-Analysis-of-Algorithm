import java.util.*;
public class InsertionSort
{
   protected static int size;
   protected static int[] arr;
   protected static int v,j;
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the size of the array:");
      size = scan.nextInt();
      if (size<=0)
      {
         System.out.println("Only postive number");
         System.exit(0);
      }
      arr = new int[size];
      System.out.print("Enter the elements:");
      for(int i=0;i<size;i++)
      {
         arr[i]=scan.nextInt();
         if(arr[i]<=0)
         {
            System.out.println("Only postive number");
            System.exit(0);
         }
      }
      for(int i=1;i<size;i++)
      {
         v=arr[i];
         j=i-1;
         while(j>=0 && arr[j]>v)
         {
            arr[j+1]=arr[j];
            j=j-1;
         }
         arr[j+1]=v;
      }
      System.out.println("After Insertion Sort:");
      for(int i=0;i<size;i++)
      {
         System.out.println(arr[i]);
      }
   }
}
