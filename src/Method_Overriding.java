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
     double length,breadth,height;
    box(box ob)
    {
        length=ob.length;
        breadth=ob.breadth;
        height=ob.height;
    }
    box(double l,double b,double h)
    {
        length=l;
        breadth=b;
        height=h;
    }
    box()
    {
        length=-1;
        breadth=-1;
        height=-1;
    }
    double volume()
    {
        return length*breadth*height;
    }
    


    
}
class boxweight extends  box
{
 
      double weight;
      boxweight(boxweight ob)
     {
       super(ob);
       weight=ob.weight;
       
     }
      boxweight(double l,double b,double h,double m)
      {
          super(l,b,h);
          weight=m;
          
      }
      boxweight()
      {
          super();
          weight=-1;
          
      }
     
     
     
}
 class Method_Overriding {
    public static void main(String args[])
    {
        boxweight mybox1=new boxweight(2,3,4,5);
        boxweight mybox2=new boxweight(5,6,7,8);
        boxweight mybox3=new boxweight();
        double vol=mybox1.volume();
        System.out.println("volume is"+vol);
        System.out.println("volume of weight is"+mybox1.weight);
    }

}
