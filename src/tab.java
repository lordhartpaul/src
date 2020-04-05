import javax.swing.*;
import java.awt.*;
import java.applet.*;
/*<applet code="tab"width=400 height=100>
</applet>
*/
public class tab extends JApplet
{
public void init()
{
Container contentPane=getContentPane();
JTabbedPane jtp=new JTabbedPane();
jtp.addTab("Favourite_Colour",new Favourite_ColourPanel());
jtp.addTab("Favourite_Car",new Favourite_CarPanel());
jtp.addTab("Track",new TrackPanel());
contentPane.add(jtp);
}
}
class Favourite_ColourPanel extends JPanel
{
public  Favourite_ColourPanel()
{
JButton b1=new JButton("Black");
add(b1);
JButton b2=new JButton("Green");
add(b2);
JButton b3=new JButton("Red");
add(b3);
JButton b4=new JButton("Grey");
add(b4);
}
}
class Favourite_CarPanel extends JPanel
{
public Favourite_CarPanel()
{
JCheckBox cb1=new JCheckBox("Lamborghini Aventador");
add(cb1);
JCheckBox cb2=new JCheckBox("Ferrari GTS");
add(cb2);
JCheckBox cb3=new JCheckBox("Ford Mustang");
add(cb3);
}
}
class TrackPanel extends JPanel
{
public TrackPanel()
{
JComboBox jcb=new JComboBox();
jcb.addItem("France");
jcb.addItem("Russia");
jcb.addItem("India");
add(jcb);
}
}