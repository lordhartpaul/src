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
    figure(double a, double b)
    {
        dim1=a;
        dim2=b;
    }
 
    figure()
    {
        dim1=-1;
        dim2=1;
    }
  double  rectangle_area()
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
public class Findareas {
   
    public static void main(String args[])
    {
        
        figure r=new figure(9,5) {} ;
        figure t=new figure(10,8) {};
        figure f=new figure() {};
        figure s=new figure(r) {};
       figure figref;
        
        figref=r;
        System.out.println("area is" +figref.rectangle_area());
        figref=t;
        System.out.println("area is" +figref.triangle_area());
        figref=f;
        System.out.println("area is"+figref.rectangle_area());
        figref=s;
        System.out.println("area is"+figref.rectangle_area());
    }

   

  
    }

    

    


