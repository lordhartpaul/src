
/* Instruction  :-  When You Increase or Decrease The Size of 
					Applet Window the Ball will move Automatically
*/
   
import java.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

// <applet code="Arc" width=500 height=460> </applet>

public class Arc extends Applet implements Runnable
{
	Random r = new Random();
	
	
	int x = 10, y = 10,sang1 = 0, sang2 = 0, he = 500 , wi = 500;
	public void init()
	{
		Thread t = new Thread(this);
		t.start();	
	}
	public void run()
	{
		while(true)
		{
			try
			{
				repaint();
				Thread.sleep(100);
				if( x < wi - 100)	
					x += 5;
				if( y < he - 100)
					y += 5;
				if( x > wi - 100)
					x = wi - 100;
				if( y > he - 100)
					y = he - 100;
				sang1 += 10;
				sang2 += 10;
			}
			catch(Exception e)
			{	}
		}
	}
	public void paint(Graphics g)
	{	
		Dimension d = getSize();		
		he = d.height;
		wi = d.width;
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.fillArc(x,20,100,100,sang1,90);
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.fillArc(x,20,100,100,sang1 + 90,90);
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.fillArc(x,20,100,100,sang1 + 180,90);
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.fillArc(x,20,100,100,sang1 + 270,90);		
		
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.fillArc(10, y, 100, 100, sang2 ,90);
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.fillArc(10,y,100,100, sang2 + 90,90);
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.fillArc(10,y,100,100,sang2 + 180,90);
		g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
		g.fillArc(10,y,100,100,sang2 + 270,90);		
		
	}
}