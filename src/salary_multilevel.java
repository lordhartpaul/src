interface sal3
{
   
    class sal
{
       
    public sal()
    {
        double basic;
        double da;
        double hra;
    }
    int i=1;
    public void display1()
    {
        
        
      
         
        System.out.println("salary of"+i+"st person");
       

        i++;
    
    
}
 
}
class sal1 extends sal implements sal3
{
    double net;
    public void cal(double basic)
    {
        double da,hra;
        da=0.90*basic;
        hra=0.35*basic;
        net=basic+da+hra;
        
    }
    public void display()
    {
        System.out.println("salary is"+net);
    }
}
public class salary extends sal1 implements sal3{
    public static void main(String args[])
    {
        salary obj=new salary();
        System.out.println("salary of the person");
        obj.cal(11000);
        obj.display();
        salary obj1=new salary();
        obj1.display1();
        obj1.cal(90000);
        obj1.display();
        salary a=new salary();
        a.display1();
        a.cal(4000);
        a.display();
        salary b=new salary();
        b.display1();
        b.cal(70000);
        b.display();
        salary c=new salary();
        c.display1();
        c.cal(78520);
        c.display();
        
        
    }

}

}