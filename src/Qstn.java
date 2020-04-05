import java.awt.event.*;
import java.awt.*;
import java.applet.*;
/*<applet code="Qstn"width=300 height=300>
</applet>
*/
public class Qstn extends Applet implements ActionListener,ItemListener
{
String msg;
Checkbox c1,c2,c3,c4;
TextField tf,tf1;
Label k1,k2,k3;
Button k4,k5;
public void init()
{
setBackground(Color.yellow);
setForeground(Color.black);
setLayout(null);
c1=new Checkbox("C");
c2=new Checkbox("C++");
c3=new Checkbox("Java");
c4=new Checkbox("VB.Net");
tf=new TextField(12);
tf1=new TextField(12);
k1=new Label("Question:");
k2=new Label("What Programming Language in 5th sem?");
k3=new Label("Your Answer:");
k4=new Button("Correct Answer:");
k5=new Button("Clear");
c1.addItemListener(this);
c2.addItemListener(this);
c3.addItemListener(this);
c4.addItemListener(this);
k4.addActionListener(this);
k5.addActionListener(this);
k1.setBounds(10,40,100,20);
k2.setBounds(120,40,300,20);
c1.setBounds(10,90,100,20);
c2.setBounds(120,90,100,20);
c3.setBounds(10,150,100,20);
c4.setBounds(120,150,100,20);
k3.setBounds(10,220,100,20);
tf.setBounds(120,220,100,20);
k4.setBounds(10,300,100,20);
tf1.setBounds(120,300,100,20);
k5.setBounds(10,390,100,20);
add(k1);
add(k2);
add(c1);
add(c2);
add(c3);
add(c4);
add(k3);
add(tf);
add(k4);
add(tf1);
add(k5);
}
public void itemStateChanged(ItemEvent ie)
{
String str=(String)ie.getItem();
if(str.equals("C"))
{
tf.setText("C");
}
else if(str.equals("C++"))
{
tf.setText("C++");
}
else if(str.equals("Java"))
{
tf.setText("Java");
}
else if(str.equals("VB.Net"))
{
tf.setText("VB.Net");
}
repaint();
}
public void actionPerformed(ActionEvent ae)
{
String tr=ae.getActionCommand();
if(tr.equals("Correct Answer:"))
{
tf1.setText("Java");
}
else if(tr.equals("Clear"))
{
tf.setText(null);
tf1.setText(null);
}
repaint();
}
}
