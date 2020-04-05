import java.applet.Applet;
import java.awt.*;
/*
<applet code="Rainbow"width=300 height=300>
</applet>
*/
public class Rainbow extends Applet
{
   private final int NUM_COLORS = 5;
   private final int NUM_ARCS = 20;

   private final int START_WIDTH = 50;
   private final int START_HEIGHT = 40;
   private final int START_X = 150 - START_WIDTH/2;
   private final int START_Y = 200 - START_HEIGHT/2;

   //-----------------------------------------------------------------
   //  Paints a rainbow.
   //-----------------------------------------------------------------
   public void paint(Graphics page)
   {
      int x = START_X, y = START_Y;
      int width = START_WIDTH, height = START_HEIGHT;

      setBackground (Color.black);

      for (int color=1; color <= NUM_COLORS; color++)
      {
         switch (color)
         {
            case 1:
               page.setColor (Color.cyan);
               break;
            case 2:
               page.setColor (Color.red);
               break;
            case 3:
               page.setColor (Color.yellow);
               break;
            case 4:
               page.setColor (Color.green);
               break;
            case 5:
               page.setColor (Color.blue);
         }

         for (int arcs = 1; arcs <= NUM_ARCS; arcs++)
         {
            page.drawArc (x, y, width, height, 0, 180);
            x--;
            y--;
            width += 2;
            height += 2;
         }
      }
   }
}
