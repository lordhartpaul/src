import java.util.*;
public class towerofhanoi {

    
  
   private static  void TOH(int d,char tower1,char tower2,char tower3)
    {
        if(d==1)
        {
            System.out.println("shift top disk from tower"+tower1+"to"+tower2);
            return;
        }
        TOH(d-1,tower1,tower3,tower2);
        System.out.println("shift top disk from from tower"+tower1+"to"+tower2);
        TOH(d-1,tower3,tower2,tower1);
    }
public static void main(String args[])
{
    Scanner s=new Scanner(System.in);
    System.out.println("enter the number of disk");
    int disk=s.nextInt();
    if(disk<1)
    {
        System.out.println("there are no disk to shift");
    }
    else
        System.out.println("there are"+disk+"disk in tower1");
    TOH(disk,'1','2','3');
    System.out.println(disk+"disk in tower1 are shifted to tower2");
    return;
    
}
}
