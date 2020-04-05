import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*<applet code="sbdemo"width=300 height=300>
 * </applet>
 */
public class sbdemo extends Applet implements AdjustmentListener,MouseMotionListener
{
    String msg="";
    Scrollbar vertsb,horzsb;
    public void init()
    {
        int width=Integer.parseInt(getParameter("width"));
        int height=Integer.parseInt(getParameter("height"));
        vertsb=new Scrollbar(Scrollbar.VERTICAL,0,1,0,height);
        horzsb=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,width);
        add(vertsb);
        add(horzsb);
        vertsb.addAdjustmentListener(this);
        horzsb.addAdjustmentListener(this);
        addMouseMotionListener(this);
    }
    public void adjustmentValueChanged(AdjustmentEvent ae)
    {
        repaint();
    }
    public void mouseDragged(MouseEvent me)
    {
        int x=me.getX();
        int y=me.getY();
        vertsb.setValue(y);
        horzsb.setValue(x);
        repaint();
        
    }
    public void mouseMoved(MouseEvent me)
    {
        
    }
    public void paint(Graphics g)
    {
        msg="vertical:"+vertsb.getValue();
        msg+=", horizontal:"+horzsb.getValue();
        g.drawString(msg,6,160);
        g.drawString("*",horzsb.getValue(),vertsb.getValue());
    }
}