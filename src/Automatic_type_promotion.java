/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sunny
 */
public class Automatic_type_promotion {
    public static void main(String args[])
    {
        byte b=42;
        char c='a';
        short s=1024;
        int i=50000;
        float f=5.76f;
        double d=.1234;
        double result=(f*b)+(i/c)-(d*s);
     System.out.println((f*b)+"+"+(i/c)+"-"+(d*s));
     System.out.println("result="+result);
    }

}
