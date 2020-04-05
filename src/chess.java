import java.awt.*;
import java.applet.*;
/*<applet code="chess"width=300 height=300>
 * </applet>
 */
public class chess extends Applet
{
  public void paint(Graphics g)
    {
        int row;
        int col;
        int x,y;
        for(row=0;row<8;row++)
        {
            for(col=0;col<8;col++)
            {
                x=col*20;
                y=row*20;
                if((row%2)==(col%2))
                {
                    g.setColor(Color.white);
            }
                else
                {
                    g.setColor(Color.black);
                    g.fillRect(x,y,20,20);
                }
        }
    }
}
}