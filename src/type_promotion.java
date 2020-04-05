/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sunny
 */
public class type_promotion {
    public static void main(String args[])
    {
        byte b=4;
        char c='a';
        short s=1024;
        int i=56;
        float f=0.12f;
        double d=.1234;
        double result=(f*b)+(i/c)-(d*s);
        System.out.println("result is"+result);
        
    }

}
