import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*<applet code="username_email"width=300 height=300>
</applet>
*/
public class username_email extends Applet implements ActionListener
{
TextField name,pass;
public void init()
{
setLayout(null);
setBackground(Color.yellow);
setForeground(Color.black);
Label n=new Label("Name:");
Label p=new Label("Password:");
Label e=new Label("Email ID:");
name=new TextField(12);
pass=new TextField(8);
pass.setEchoChar('*');
TextField j=new TextField(12);
Button km=new Button("Log In");
n.setBounds(10,40,100,20);
name.setBounds(120,40,100,20);
p.setBounds(10,90,100,20);
pass.setBounds(120,90,100,20);
e.setBounds(10,150,100,20);
j.setBounds(120,150,100,20);
km.setBounds(10,220,100,20);
add(n);
add(name);
add(p);
add(pass);

add(e);
add(j);
add(km);


}
public void actionPerformed(ActionEvent ae)
{
repaint();

}
}

