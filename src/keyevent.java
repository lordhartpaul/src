import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*<applet code="keyevent"width=300 height=300>
 * </applet>
 */
public class keyevent extends Applet implements KeyListener
{
    String msg="";
    int x=10,y=20;
    public void init()
    {
        addKeyListener(this);
        requestFocus();
    }
    public void keyPressed(KeyEvent ke)
    {
        showStatus("key down");
        }
    public void keyReleased(KeyEvent ke)
    {
        showStatus("key up");
        
    }
    public void keyTyped(KeyEvent ke)
    {
        msg+=ke.getKeyChar();
        showStatus("typing");
        repaint();
    }
    public void paint(Graphics g)
    {
        g.drawString(msg,x,y);
    }
}