import java.util.Scanner;
 
class program_9
{
   public static void main(String args[])
   {
      int n, num = 1, i, j;
      Scanner in = new Scanner(System.in);
 
      System.out.println("Enter the number of rows of floyd's triangle you want");
      n = in.nextInt();
 
      System.out.println("Floyd's triangle :-");
 
      for ( i = 1 ; i <= n ; i++ )
      {
         for ( j = 1 ; j <= i ; j++ )
         {
            System.out.print(num+" ");
            num++;
         }
 
         System.out.println();
      }
   }
}
