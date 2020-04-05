import java.awt.*;
import java.applet.*;
/*<applet="candle"width=300 height=300>
 * </applet>
 */
public class candle extends Applet implements Runnable
{
    int i=0,j=0,r1=0,r2=0,r3=0,z=0;
    Thread t1=null;
    boolean threadsuspend;
    public void init()
    {
        
    }
    public void paint(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRoundRect(100,100,50,200,20,20);
        g.setColor(Color.green);
        g.fillRoundRect(150,120,50,200,20,20);
        g.setColor(Color.blue);
        g.fillRoundRect(200,80,50,200,20,20);
        g.setColor(Color.yellow);
        g.fillOval(112,55,25,50*r1/10);
        g.fillOval(162,75,25,50*r2/10);
        g.fillOval(212,35,25,50*r3/10);
        g.setColor(Color.black);
        g.drawLine(125,100,125,70);
        g.drawLine(175,120,175,95);
        g.drawLine(225,80,225,50);
        g.setColor(Color.green);
        g.fillOval(180,310,60,10);
        g.fillOval(125,310,60,10);
        g.setColor(Color.red);
        g.fillOval(70,290,60,10);
        g.setColor(Color.blue);
        g.fillOval(235,270,60,10);
        while(z<3 && z>=1)
        {
            g.drawOval(249,80*z,10,20);
        }
    }
    public void start()
    {
        if(t1==null)
        {
            Thread t1=new Thread(this);
            threadsuspend=false;
            t1.start();
            
        }
    }
    public void run()
    {
        try
        {
            while(true)
            {
                r1=((int)(Math.random()*10) );
                r2=( (int)(Math.random()*10));
                r3=( (int)(Math.random()*10));
                z=( (int)(Math.random()*10));
                repaint();
                t1.sleep(100);
                
            }
        }
        catch(InterruptedException e){}
    }
    //<editor-fold defaultstate="collapsed"  desc="Generated code">
    private void initComponents()
    {
        setLayout(new java.awt.BorderLayout());
        
    }//</editor-fold>
    
}