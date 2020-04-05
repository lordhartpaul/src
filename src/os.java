import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*<applet code="os"width=300 height=300>
</applet>
*/
public class os extends Applet implements ItemListener
{
String msg=" ";
Checkbox winxp,win7,win8,mint;
CheckboxGroup cbg;
public void init()
{
cbg=new CheckboxGroup();
winxp=new Checkbox("Windows xp",cbg,true);
win7=new Checkbox("Windows 7",cbg,false);
win8=new Checkbox("Windows 8",cbg,false);
mint=new Checkbox("Linux mint",cbg,false);
add(winxp);
add(win7);
add(win8);
add(mint);
winxp.addItemListener(this);
win7.addItemListener(this);
win8.addItemListener(this);
mint.addItemListener(this);
}
public void itemStateChanged(ItemEvent ae)
{
repaint();
}
public void paint(Graphics g)
{
msg="selected operating system is:";
msg +=cbg.getSelectedCheckbox().getLabel();
g.drawString(msg,6,100);
}
}