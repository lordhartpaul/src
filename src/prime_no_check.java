import java.util.*;
public class prime_no_check {
    public static void main(String args[])
    {
        int n,i,flag=0;
        System.out.println("enter a positive integer:");
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        for(i=2;i<=n/2;++i)
        {
            if(n%i==0)
            {
                flag=1;
                break;
            }
        }
        if(flag==0)
            System.out.println(n+"is a prime number.");
        else
            System.out.println(n+"is not a prime number.");
        return;
    }

}
