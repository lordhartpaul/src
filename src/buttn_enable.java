import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Button;
import java.awt.Color;
/*<applet code="buttn_enable"width=300 height=300>
 * </applet>
 */ 
public class buttn_enable extends Applet {
    boolean isbutton1enabled;
    boolean isbutton2enabled;
   public void init() {
       Button b1=new Button("ok");
       Button b2=new Button("cancel");
       b1.setBackground(Color.yellow);
       b1.setForeground(Color.BLACK);
       b2.setBackground(Color.LIGHT_GRAY);
       b2.setForeground(Color.BLUE);
       add(b1);
       add(b2);
       b1.setEnabled(false);
       isbutton1enabled=b1.isEnabled();
       isbutton2enabled=b2.isEnabled();
       b1.setVisible(true);
    }
   public void paint(Graphics g)
   {
       g.drawString("is button 1 enabled"+isbutton1enabled,10,50);
       g.drawString("is button 2 is enabled"+isbutton2enabled,10,70);
   }

   
}
