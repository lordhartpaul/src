/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sunny
 */
class box
{
    private double d1,d2,d3;
    box(box ob)
    {
        d1=ob.d1;
        d2=ob.d2;
        d3=ob.d3;
    }
    box(double a,double b,double c)
    {
        a=d1;
        b=d2;
        c=d3;
    }
    box()
    {
        d1=-1;
        d2=-1;
        d3=-1;
    }
    double volume()
    {
        return d1*d2*d3;
    }
}
class boxdemo extends box
{
     double d4;
    boxdemo(boxdemo ob)
    {
        super(ob);
        d4=ob.d4;
    }
    boxdemo(double a,double b,double c,double d)
    {
        super(a,b,c);
        d=d4;
    }
    boxdemo()
    {
        super();
        d4=-1;
    }
}
public class demosuper {
    public static void main(String args[])
    {
        boxdemo b1=new boxdemo(1,2,3,4);
        boxdemo b2=new boxdemo(2,4,6,7);
        boxdemo b3=new boxdemo();
        boxdemo ob=new boxdemo(b1);
        double vol=b1.volume();
        System.out.println("area"+vol);
        System.out.println("a"+b1.d4);
    }

}
