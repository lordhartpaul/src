import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/* <applet code="mine" width=300 height=300>
 * </applet>
 */
public class mine extends Applet implements ItemListener,ActionListener
{

   String msg1="";
   String msg3="";
   String msg2="";
   CheckboxGroup cbg;
   Checkbox c1,c2,c3,c4;
   Button b1;
   public void init()
   {
     
     
      b1=new Button("view");
      cbg=new CheckboxGroup();
      c1=new Checkbox("indian",cbg,true);
       c2=new Checkbox("other",cbg,true);
        c3=new Checkbox("c");
         c4=new Checkbox("java");
         b1.addActionListener(this);
         c1.addItemListener(this);
         c2.addItemListener(this);
         c3.addItemListener(this);
         c4.addItemListener(this);
         add(b1);
         add(c1);
          add(c2);
           add(c3);
            add(c4);
      
   }
   public void itemStateChanged(ItemEvent ie)
   {
      
       repaint();
   }
           public void actionPerformed(ActionEvent ae)
           {
                if(ae.getSource()==b1 || ae.getSource()==c3)
       {
           msg1+=cbg.getSelectedCheckbox().getLabel();
           msg2+=c3.getLabel();
            
           repaint();
           
       }
                else  
       {
           msg1+=cbg.getSelectedCheckbox().getLabel();
            msg3+=c4.getLabel();
            
           repaint();
           
       }
               repaint();
           }
    public void paint(Graphics g)
    {
        g.drawString(msg1,80,100);
         g.drawString(msg2,400,100);
          g.drawString(msg3,400,100);
    }
}