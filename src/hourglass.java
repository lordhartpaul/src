import java.awt.*;
import java.applet.*;
/*<applet code="hourglass"width=300 height=300>
 * </applet>
 */
public class hourglass extends Applet
{
    public void paint(Graphics g)
    {
        int xpoints[]={30,200,30,200,30};
        int ypoints[]={30,30,200,200,30};
        int num=5;
        g.drawPolygon(xpoints,ypoints,num);
        
    }
}