/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sunny
 */
abstract class figure
{
    private double dim1,dim2;
    figure(figure ob)
    {
        dim1=ob.dim1;
        dim2=ob.dim2;
    }
    figure(double a,double b)
    {
        dim1=a;
        dim2=b;
    }
    figure()
    {
        dim1=-1;
        dim2=-1;
    }
    double rectangle_area()
    {
        System.out.println("inside area for rectangle");
        return dim1*dim2;
        
    }

   
    double triangle_area()
    {
        System.out.println("inside area for triangle");
        return dim1*dim2/2;
    }
}
public class Findareas1 {
public static void main(String args[])
{
    figure r=new figure(10,8) {};
    figure s=new figure(2,4) {};
    figure t=new figure() {};
    figure v=new figure(r) {};
    figure figref;
    figref=r;
    System.out.println("area is"+figref.rectangle_area());
    figref=s;
    System.out.println("area is"+figref.triangle_area());
    figref=t;
    System.out.println("area is"+figref.rectangle_area());
    figref=v;
    System.out.println("area is"+figref.rectangle_area());
    
}
}
