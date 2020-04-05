import javax.swing.*;
import java.awt.*;
/*<applet="car"width=300 height=300>
 * </applet>
 */ 
public class car extends JApplet
{
    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        g.setColor(Color.red);
        g.fillRect(100,110,60,10);
        g.setColor(Color.black);
        g.fillOval(110,120,10,10);
        g.fillOval(140,120,10,10);
        int x[]={110,120,140,150 };
        int y[]={110,100,100,110};
        g.setColor(Color.blue);
        g.fillPolygon(x,y,4);
        g.drawString("how do you like it?",80,90);
    }
}
