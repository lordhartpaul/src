
interface exam
{
    void percent_cal();
    class student
    {
        String name;
        int roll_no,mark1,mark2;
        student(String n,int r,int m1,int m2)
        {
            name=n;
            roll_no=r;
            mark1=m1;
            mark2=m2;
        }
        void display()
        {
            System.out.println("name of the student:"+name);
            System.out.println("roll no. of student:"+roll_no);
            System.out.println("marks of subject 1: "+mark1);
            System.out.println("marks of subject 2: "+mark2);
        }
    }

        class result extends student implements exam
        {
result(String n,int r,int m1,int m2)
{
    super(n,r,m1,m2);
}
public void percent_cal()
{
    int total=(mark1+mark2);
    float percent=total*100/200;
    System.out.println("percentage:"+percent+"%");
}
void display()
{
    super.display();
}

           
            
        }
        
 class multiple_inheritance  {
    public static void main(String args[])
    {
        result rs=new result("ZZ Ward",12,93,84);
        rs.display();
        rs.percent_cal();
    }

}
        
    }
    


