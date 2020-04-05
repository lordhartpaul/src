public class palindrm {
    public static void main(String args[])
    {
        int numbers[]=new int[]{121,13,34,11,22,54};
        for(int i=0;i<numbers.length;i++)
        {
            int number= numbers[i];
            int reversednumber=0;
            int temp=0;
            while(number>0)
            {
                temp=number%10;
                number=number/10;
               reversednumber= reversednumber*10+temp;
                
            }
            if(numbers[i]==reversednumber)
                System.out.println(numbers[i]+"is a palindrome number");
            else
                System.out.println(numbers[i]+"is not a palindrome number");
        }
    }

}
