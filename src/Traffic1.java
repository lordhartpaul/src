import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/* <applet code="Traffic1" width = 600 height = 600>
	</applet>
		*/

public class Traffic1 extends Applet implements Runnable
{
	
	Thread t;
	int i=0,a=0,j=0; //These are used for Time counting
	int b,x1=10,x2=500; //These are used for Car Ploating
	
	public void init()
	{
	Font f = new Font("Comic Sans MS",Font.BOLD,30);

	setFont(f);
	}	

	public void start()
	{
		t = new Thread(this);
		t.start();
	}		
	
	public void run()
	{
	
	do{
		b=0; // nothing but used as flag
		for(i=30;i>=0;i--)
		{	
			try
			{
				Thread.sleep(50);
			}
			catch(InterruptedException e)
			{
				//anything u want
			}
			
			if(i<=30 && i>10)
			{
				a=1;
				repaint();
			}

			else if(i<=10 && i>0)
			{
				a=2;
				repaint();
			}

			else if(i==0)
			{
				for(j=0;j<50;j++)
				{
				   a=3;b=1;
				   try
				   {
					Thread.sleep(50);
				   }
				    catch(InterruptedException e)
				     {
					//anything u want
				     }
				repaint();
			 	}
			 }
		   } 
		}while(j>=50);

	
		}



	public void paint(Graphics g)
		{
			
			
			g.setColor(Color.black);
			g.fillRect(150,150,50,150);
			g.drawRect(150,150,50,150);
	
			g.setColor(Color.black);
			g.fillRect(165,300,20,155);
			g.drawRect(165,300,20,155);
			
			g.drawOval(150,150,50,50);  //red
			g.drawOval(150,200,50,50);  //yellow
			g.drawOval(150,250,50,50);  //green
			
			
			g.setColor(Color.BLUE);
			g.fillRect(x1,500,60,15); //first car

			g.setColor(Color.PINK);
			g.fillRect(x2,520,60,15); //second car
			
			if(a==1)
			 {	
				g.setColor(Color.red);
				g.fillOval(150,150,50,50);
				g.drawString("STOP",240,180);
				
			 }
			
			if(a==2)
			 {	
				g.setColor(Color.yellow);
				g.fillOval(150,200,50,50);
				g.drawString("WAIT",240,230);
				g.setColor(Color.red);	
				
			 }
			
			if(a==3)
			 {	
				g.setColor(Color.green);
				g.fillOval(150,250,50,50);
				g.drawString("GO",240,280);
				
			 }
		
			if(b==1)
			 {	
				x1=x1+15;
				x2=x2-10;
			 }
			
			if(x1>580)
			 {
				x1=0;
			 }
	
			if(x2<0)
			 {
				x2=550;
			 }			

		}
	

}				
				