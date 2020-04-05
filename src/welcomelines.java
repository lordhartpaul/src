import java.awt.Graphics;
import javax.swing.JApplet;
/*
<applet code="welcomelines"width=300 height=300>
</applet>
*/
public class welcomelines extends JApplet
{
public void paint(Graphics g)
{
super.paint(g);
g.drawLine(15,10,210,10);
g.drawLine(15,30,210,30);
g.drawString("welcome to java programming",25,25);
}
} 