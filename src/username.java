import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*<applet code="username"width=300 height=300>
</applet>
*/
public class username extends Applet implements ActionListener
{
TextField name,pass;
public void init()
{
setBackground(Color.yellow);
setForeground(Color.black);
Label n=new Label("Name:",Label.RIGHT);
Label p=new Label("Password:",Label.RIGHT);
name=new TextField(12);
pass=new TextField(8);
pass.setEchoChar('*');
add(n);
add(name);
add(p);
add(pass);
name.addActionListener(this);
pass.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
repaint();
}
public void paint(Graphics g)
{
g.drawString("Name :"+name.getText(),6,60);
g.drawString("Selected text in name :"+name.getSelectedText(),6,80);
g.drawString("Password :"+pass.getText(),6,100);
}
}

