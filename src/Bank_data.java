import java.util.*;
 class bnk
{
   
    int num;
    
    float bal;
    private String name;
    private String type;
    public void assign()
    {
      System.out.println("enter name");
      Scanner s=new Scanner(System.in);
        name=s.next();
       System.out.println("enter the account type");
        type=s.next();
       System.out.println("enter the balance amount in the account");
       bal=s.nextFloat();
       
    }
    public void deposit()
    {
        int depositt;
        System.out.println("balance amount is"+bal);
        System.out.println("enter the amount to be deposited");
         Scanner s=new Scanner(System.in);
        depositt=s.nextInt();
        bal=bal+depositt;
        System.out.println("after deposit,balance is"+bal);
        
    }
    public void withdraw()
    {
        int wthrdw;
        System.out.println("balance amount is"+bal);
        System.out.println("enter the amount to be withdrawn");
          Scanner s=new Scanner(System.in);
          wthrdw=s.nextInt();
          bal=bal-wthrdw;
            System.out.println("after withdraw,balance is"+bal);
          
        
    }
    public void display()
    {
       
        System.out.println("name"+name);
        System.out.println("account number"+num);
        System.out.println("account type"+type);
        System.out.println("balance is"+bal);
        
    }
    
}
public class Bank_data extends bnk {
    public static void main(String args[])
    {
     Bank_data obj=new Bank_data();
     int choice;
     do
     {
         System.out.println("\nchoice list: \n1.to assign initial value\n2.to deposit an amount\n3.to withdraw an amount after checking the balance\n4.to display name and balance\n5.exit\nenter choice");
          Scanner s=new Scanner(System.in);
          choice=s.nextInt();
          switch(choice)
          {
              case 1:
                  obj.assign();
                  break;
              case 2:
                  obj.deposit();;
                  break;
              case 3:
                  obj.withdraw();;
                  break;
              case 4:
                  obj.display();;
                  break;
              case 5:
                  exit(0);
                  
          }
     }
     while(true);
    }

    private static void exit(int i) {
        System.out.println("You Are Exit,Just Close It Now");
    }

   

  

   

}
