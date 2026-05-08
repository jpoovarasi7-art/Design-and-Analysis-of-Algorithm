import java.util.*;
class Point
{
   double x,y;
   Point(double x,double y)
   {
      this.x=x;
      this.y=y;
   }
}
public class ClosestPair
{
   protected static double distance;
   protected static int no_points;
   protected static int x_axis;
   protected static int y_axis;
   protected static double n1,n2,n3,n4;
   public static Point []points;
   public static double findClosest(Point []points)
   {
      double min_distance = Double.MAX_VALUE;

      for(int i=0;i<no_points;i++)
      {
         for(int j=i+1;j<no_points;j++)
         {
            double dx = points[i].x-points[j].x;
            double dy = points[i].y-points[j].y;
            distance = Math.sqrt(dx*dx+dy*dy);
            System.out.println("Pair are ("+points[i].x+","+points[i].y+" and ("+points[j].x+","+points[j].y+")\t Distance is "+distance);
         if(distance<min_distance) {
            min_distance=distance;
            n1=points[i].x;
            n2=points[i].y;
            n3=points[j].x;
            n4=points[j].y;
         }
         }
      }
      return min_distance;
   }
   public static void main(String args[])
   {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter the number of the points:");
      no_points = scan.nextInt();
      points = new Point[no_points];
      for(int i=0;i<no_points;i++)
      {
          System.out.println("Enter the x-coordinates for the point "+i);
          x_axis = scan.nextInt();
          System.out.println("Enter the y-coordinates for the point "+i);
          y_axis = scan.nextInt();
          points[i] = new Point(x_axis,y_axis);
      }
      double result = findClosest(points);
      System.out.println("The shortest path");
      System.out.println("The first x & y coordinates:"+n1+","+n2);
      System.out.println("the second x & y coordinates:"+n3+","+n4);
       System.out.println("Shortest path is "+Math.round(result));
}
}
