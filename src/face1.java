import java.applet.*;
import java.awt.*;
/*<applet code="face1"width=300 height=300>
</applet>
*/
public class face1 extends Applet
{
public void paint(Graphics g)
{
g.drawOval(100,100,100,100);
g.fillOval(120,125,20,20);
g.fillOval(160,125,20,20);
g.drawLine(150,165,150,150);
g.drawLine(130,170,170,170);
}
}