import javax.swing.JOptionPane;

/*
          Stack Class Written By Sanchit Karve (born2c0de@hotmail.com)
          You can freely modify this code and distribute it if and as you wish.
                                                         -Sanchit Karve
                                                       born2c0de@hotmail.com
*/

class Stack
{
   private  int MAX=10;   // Change this for MAximum number of items
   private int arr[];
   private int top;

   public Stack()
   {
   	   arr=new int[MAX];
           for(int i=0;i<MAX;i++)
   	        arr[i]=0;

   	top=-1;
   }

   public void push(int data)
   {
   	top++;
   	if(top<MAX)
   	{
   		arr[top]=data;
   	}
       else
       {
JOptionPane.showMessageDialog(null,"STACK IS FULL!","STACK WARNING",JOptionPane.INFORMATION_MESSAGE);
       top--;
       }
   }

   public int pop()
   {
   	if(top==-1)
   	{
                JOptionPane.showMessageDialog(null,"STACK IS EMPTY!","STACK WARNING",JOptionPane.INFORMATION_MESSAGE);
                return 0;
        }
        else
        {
        	int data=arr[top];
        	arr[top]=0;
        	top--;
        	return data;
        }
   }
}
