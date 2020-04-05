/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sunny
 */
import java.util.*;
public class Odd_even {
    public static void main(String args[])
    {
        int num;
        Scanner s=new Scanner(System.in);
        System.out.println("enter the number");
        num=s.nextInt();
        if((num%2)==0)
        {
            System.out.println("the input no.is really even");
        }
        else
        {
            System.out.println("the input no. is damn odd");
        }
    }

}
