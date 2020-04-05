/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sunny
 */
abstract class rectangle
{
   final private double dim1,dim2;
    rectangle(double a,double b)
    {
        dim1=a;
        dim2=b;
    }
   final double area_of_rectangle(rectangle ob)
    {
        System.out.println("area of rectangle");
        return dim1*dim2;
    }
}
public class Object_as_parameter {
    public static void main(String args[])
    {
        rectangle ob=new rectangle(10,8) {};
        rectangle fig;
        fig=ob;
        System.out.println("area is"+ fig.area_of_rectangle(ob));
        
    }

   
}
