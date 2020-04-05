

import java.applet.Applet;
import java.awt.*;


public class Canvas extends Applet
{
	private Trans2D trans2D = null;
	private int heightCanvas = 0;
	private int widthCanvas = 0;
	private Graphics gp = null;
	
	public void init()
	{
		this.widthCanvas = this.size().width;
		this.heightCanvas = this.size().height;
		trans2D = new Trans2D(10, this.heightCanvas, this.widthCanvas, Color.red, Color.blue);
		
		int i=0;
		
		do
		{
			i++;
			String strX = getParameter("x" + i);
			String strY = getParameter("y" + i);
			
			if(strX==null || strY==null)
			{
				i--;
				break;
			}
			
			try
			{
				trans2D.addVertex(Integer.parseInt(strX), Integer.parseInt(strY));
			}
			catch(Exception e){}
		}while(true);
		
		gp = this.getGraphics();		
	}
	
	public void doTranslate(int xTrans, int yTrans) throws Exception
	{
		trans2D.doTranslate(xTrans, yTrans);
		paint(this.gp);
	}
	
	public void doRotate(int xRef, int yRef, int theta) throws Exception
	{
		trans2D.doRotate(xRef, yRef, theta);
		paint(this.gp);
	}	
	
	public void doScale(int xRef, int yRef, double xScale, double yScale) throws Exception
	{
		trans2D.doScale(xRef, yRef, xScale, yScale);
		paint(this.gp);
	}
	
	public void doReflect(int x1, int y1, int x2, int y2) throws Exception
	{
		trans2D.doReflect(x1, y1, x2, y2);
		paint(this.gp);
	}
	
	public void doReflect(String axis) throws Exception
	{
		if(axis.equals("x"))
		{
			trans2D.doReflect(0, 0, 50, 0);
		}
		else
		{
			trans2D.doReflect(0, 0, 0, 50);
		}
		paint(this.gp);
	}
	
	public void doShear(int xRef, int yRef, double xShear, double yShear) throws Exception
	{
		trans2D.doShear(xRef, yRef, xShear, yShear);
		paint(this.gp);
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, this.widthCanvas, this.heightCanvas);
		g.setColor(Color.black);
		g.drawRect(0, 0, this.widthCanvas-1, this.heightCanvas-1);
		trans2D.draw2D(g);
	}
}