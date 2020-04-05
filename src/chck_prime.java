public class chck_prime {
    public boolean no(int num)
    {
        for(int i=2;i<num/2;i++)
        {
            if(num%i==0)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String args[])
    {
        chck_prime a=new chck_prime();
        System.out.println("is 17 prime no."+a.no(17));
        System.out.println("is 15 prime no."+a.no(15));
    }

}
