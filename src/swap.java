import java.util.Scanner;

class interchange {

	int x=0, y=0;
    int temp=0;

  void swapping(int x, int y)
  {


 // code to interchange the arrangement
 // of values;

   temp = x;
   x = y;
   y = temp;

     System.out.println();
	 System.out.print("After the Arrangement ==> "
                       + x + " and " + y + ".");
	  System.out.println();
	  System.out.println();


}

}



class swap {

	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);

		interchange values = new interchange();

        System.out.print("\t Swapping of Numbers 1.0");
        System.out.println();
        System.out.println();
        System.out.print("Enter a Number    :=> ");
		values.x = scanner.nextInt();
		System.out.print("Enter a Number    :=> ");
		values.y = scanner.nextInt();
        System.out.println();
        System.out.print("Original Arrangement ==> "
                       + values.x + " and " + values.y + ".");

		values.swapping(values.x,values.y);
   }
}
