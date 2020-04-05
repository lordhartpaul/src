import java.applet.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics.*;

public class Apm extends Applet implements MouseListener,MouseMotionListener
{
      String msg1,msg2;
	int x,y;
	Color c;
	TextField t;
	public void init()
	{
		setLayout(new FlowLayout());
            msg1="Hai Friends,This is mouse test.";
            msg2="";
            x=250;
            y=250;
		c=new Color(111,111,0);
		setBackground(c);
            addMouseListener(this);
		addMouseMotionListener(this);

	}
	 
	public void mouseMoved(MouseEvent e){}
	public void mouseDragged(MouseEvent e)
	{
		x=e.getX();
		y=e.getY();
            msg2="("+x+","+y+")";
            repaint();
	}
        public void mouseClicked(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mousePressed(MouseEvent e)
        {                  
            x=e.getX();
		y=e.getY();
            msg2="("+x+","+y+")";
            repaint();
	}
        public void paint(Graphics g) 
	{
                        showStatus(msg1);
                        g.drawString(msg2,x,y);
                        g.drawLine(x,y,0,0);
                        g.drawLine(x,y,0,500);
                        g.drawLine(x,y,500,0);
                        g.drawLine(x,y,500,500);
    	}
}
