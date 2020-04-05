import java.io.*;
class ntw
{
	String wrd;
	int num,qut,rem;
	String [] arr1 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Tweleve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	String [] arr2 = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	
	public int chk(int num1)
	{
		int counter=0;
		while(num1!=0)
		{
			counter++;
			num1 = num1/10;
		}
		return counter;
	}
	public String calc(int x,int number)
	{
		int number1=number;
		wrd = "";
		if(number == 0)
		{
			return "Zero";
		}
		if(x==7 || x==6)
		{
			qut = number1/100000;
			number1 = number1%100000;
			x = chk(number1);
			if(qut > 19)
			{
				wrd = arr2[qut/10] + " " + arr1[qut%10] + " Lakh";	
			}
			else
			{
				wrd = arr1[qut] + " Lakh";
			}
			
			
		}
		if(x==5 || x==4)
		{
			qut = number1/1000;
			number1 = number1%1000;
			x = chk(number1);
			if(qut > 19)
			{
				wrd = wrd + " " + arr2[qut/10] + " " + arr1[qut%10] + " Thousand";	
			}
			else
			{
				wrd =wrd + " " + arr1[qut] + " Thousand";
			}
			
			
		}
		if(x==3)
		{
			qut = number1/100;
			number1 = number1%100;
			x = chk(number1);
			wrd = wrd + " " + arr1[qut] + " Hundred";
		}
		if(x==2)
		{
			qut = number1;
			number1 = number;
			x = chk(number1);
			if(qut > 19)
			{
				wrd = wrd + " " + arr2[qut/10] + " " + arr1[qut%10];	
			}
			else
			{
				wrd = wrd + " " + arr1[qut];
			}
		}
		if(x==1)
		{
			number1 = number1%10;
			x = chk(number1);
			wrd = wrd + " " + arr1[number1];
		}
			
		return wrd+" only";
	}
				
	
	public ntw()throws IOException
	{
		int i;
		String wrd2;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter a number : ");
		num = Integer.parseInt(br.readLine());
		i = chk(num);
		wrd2 = calc(i,num);
		System.out.println(wrd2);
	}
	public static void main(String args[])throws IOException
	{
		ntw n = new ntw();
	}
}

		