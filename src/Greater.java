/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sunny
 */
import java.util.*;
public class Greater {
    public static void main(String args[])
    {
        int a,b;
        Scanner s=new Scanner(System.in);
        System.out.println("enter the values of a and b");
        a=s.nextInt();
        b=s.nextInt();
        if(a>b)
        {
            System.out.println("a is greater than b"+(a>b));
        }
        else
        {
            System.out.println("b is greater than a"+(b>a));
        }
    }
}

        