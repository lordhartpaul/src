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
    private double d1,d2;
    figure(figure ob)
    {
        d1=ob.d1;
        d2=ob.d2;
        
    }
    figure(double a,double b)
    {
        d1=a;
        d2=b;
    }
    figure()
    {
        d1=-1;
        d2=-1;
    }
    double rec_area()
    {
        System.out.println("area for rec");
        return d1*d2;
    }
    double tri_area()
    {
        System.out.println("area for triangle");
        return (d1*d2)/2;
    }
}
public class Without_inheritance {
    public static void main(String args[])
    {
        figure f1=new figure(2,4) {};
        figure f2=new figure(2,4) {};
        figure f3=new figure() {};
        figure ob=new figure(f1) {};
        figure figref;
        figref=f1;
        System.out.println("area is"+figref.rec_area());
        figref=f2;
        System.out.println("area is"+figref.tri_area());
        figref=ob;
        System.out.println("area is"+figref.rec_area());
        figref=f3;
        System.out.println("area is"+figref.rec_area());
    }

}
