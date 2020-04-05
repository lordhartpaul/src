import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*<applet code = "event_mouse_image.class" width = 1000 height = 1000>
</applet>
*/
public class event_mouse_image extends Applet implements MouseListener
{
	String name = "1.jpg";
	Image img;
	public void init()
	{
		addMouseListener(this);
	}
	public void start()
	{
		name = "1.jpg";
		repaint();
	}
	
	public void mouseClicked(MouseEvent me) 
	{
			name = "2.jpg";
			
			repaint();
			
	}
	public void mouseExited(MouseEvent me)
	{
		name = "3.jpg";
		repaint();
	}
	public void mouseEntered(MouseEvent me)
	{
		name = "4.jpg";
		repaint();
	}
	public void mouseReleased(MouseEvent me)
	{
		name = "5.jpg";
		repaint();
	}
	public void mousePressed(MouseEvent me)
	{
		name = "6.jpg";
		repaint();
	}
	public void paint(Graphics g)
	{
		img = getImage(getCodeBase(),name);
		g.drawImage(img , 0,0,this);
	}
}
		