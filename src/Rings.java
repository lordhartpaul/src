import java.awt.Graphics;       // Java API components
import java.awt.Color;          // needed by this applet
import javax.swing.JApplet;
/*
<applet code="Rings"width=300 height=300>
</applet>
*/
public class Rings extends JApplet
{
    public void paint(Graphics g)
    {
        // Call superclass version of method paint

        super.paint(g);

        // Draw five interlocking rings of different colours
        // See documentation for Java Graphics API for info

        g.setColor(Color.red);
        g.drawOval(20, 20, 150, 150);
        g.setColor(Color.blue);
        g.drawOval(130, 20, 150, 150);
        g.setColor(Color.green);
        g.drawOval(80, 120, 150, 150);
        g.setColor(Color.yellow);
        g.drawOval(245, 20, 150, 150);
        g.setColor(Color.black);
        g.drawOval(180, 120, 150, 150);

        // Label the drawing

        g.drawString("Olympic Rings", 170, 300);
    }
}

