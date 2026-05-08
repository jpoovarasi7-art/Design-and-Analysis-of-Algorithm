import java.util.*;
public class Searching
{
   protected static String []text;
   protected static String []pattern;
   protected static String text1;
   protected static String pattern1;
   protected static int size_text;
   protected static int size_pattern;
   public static void main(String args[])
   {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the Text:");
      text1 = scan.nextLine();
      int size_text = text1.length();
      text = new String[size_text];
      text = text1.split("");
      System.out.println("Enter the Pattern:");
      pattern1 = scan.nextLine();
      int size_pattern = pattern1.length();
      pattern = new String[size_pattern];
      pattern = pattern1.split("");
      System.out.println("After Searching of the pattern in text:");
      int result = Matching(text,pattern,size_text,size_pattern);
      if(result==-1)
      {
          System.out.println("Sorry,Pattern is not found in the text");
      }
      else
      {
          System.out.println("Pattern is found at "+result+" Position in text");
      }
   }
   public static int Matching(String text[],String pattern[],int size_text,int size_pattern)
   {
      System.out.println(text1);
           for(int i=0;i<=size_text-size_pattern;i++)
              {
                  int j=0;
                  for(int k=0;k<i;k++)
                  {
                     System.out.print(" ");
                  }
                  System.out.println(pattern1);
                  while (j<size_pattern && pattern[j].equals(text[j+i]))
                  {
                          j=j+1;
                  }
                  if (j==size_pattern)
                  {
                          return i;
                  }
              }
              return -1;
   }
}
