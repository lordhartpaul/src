import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*<applet code="xor"width=300 height=300>
 * </applet>
 */
public class xor extends Applet
{
    int chsx=100,chsy=100;
    public xor()
    {
        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseMoved(MouseEvent me){
                int x=me.getX();
                int y=me.getY();
                chsx=x-10;
                chsy=y-10;
                repaint();
            }
        });
    }
    public add paint(Graphics g)
    {
        g.drawLine(0,0,100,100);
        g.drawLine(0,100,100,0);
        g.setColor(Color.blue);
        g.drawLine(40,25,250,180);
        g.drawLine(75,90,400,400);
        g.setColor(Color.green);
        g.drawRect(10,10,60,50);
        g.fillRect(100,10,60,50);
        g.setColor(Color.red);
        g.drawRoundRect(190,10,60,50,15,15);
        g.fillRoundRect(70,90,140,100,30,40);
        g.setColor(Color.cyan);
        g.drawLine(20,150,400,40);
        g.drawLine(5,290,80,19);
        g.setXORMode(Color.black);
        g.drawLine(chsx-10, chsy, chsx+10, chsy);
        g.drawLine(chsx, chsy-10, chsx, chsy+10);
        g.setPaintMode();
        
    }
}