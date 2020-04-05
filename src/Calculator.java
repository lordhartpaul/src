/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sunny
 */
import java.util.*;
public class Calculator {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        System.out.println("welcome to calculator");
        System.out.println("enter 1.addition 2.subtraction 3.multiplication 4.division 5.square root 6.factorial 7.power");
        int n=s.nextInt();
        switch(n)
        {
            case 1:
                System.out.println("enter two no. for addition");
                double a=s.nextDouble();
                double b=s.nextDouble();
                System.out.println("addition is"+(a+b));
                break;
            case 2:
                System.out.println("enter two no. for subtraction");
                double a1=s.nextDouble();
                double b1=s.nextDouble();
                System.out.println("subtraction is"+(a1-b1));
                break;
            case 3:
                System.out.println("enter two no. for multiplication");
                double a2=s.nextDouble();
                double b2=s.nextDouble();
                System.out.println("multiplication is"+(a2*b2));
                break;
            case 4:
                System.out.println("enter two no. for division");
                double a3=s.nextDouble();
                double b3=s.nextDouble();
                System.out.println("division is"+(a3/b3));
                break;
            case 5:
                System.out.println("enter a no.to find square root");
                double sqr=s.nextDouble();
                double squareroot=Math.sqrt(sqr);
                System.out.println("square root is"+squareroot);
                break;
            case 6:
                System.out.println("enter a no. to find factorial");
                int num=s.nextInt();
                int fact=1;
                for(int i=1;i<=num;i++)
                {
                    fact=fact*i;
                }
            case 7:
               int num1,num2;
               double numb;
               System.out.println("enter a number");
               num1=s.nextInt();
               System.out.println("enter a power of the number");
               num2=s.nextInt();
               numb=Math.pow(num1,num2);
               System.out.println("answer is" +numb);
               break;
               
                
        }
    }

}
