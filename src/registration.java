import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*<applet code="Registration"width=300 height=300>
</applet>
*/
public class registration extends Applet implements ActionListener,ItemListener
{
TextField name,pass,j;
TextArea a;
CheckboxGroup cbg;
    @Override
public void init()
{
setLayout(null);
cbg=new CheckboxGroup();
setBackground(Color.yellow);
setForeground(Color.black);
Label n1=new Label("STUDENT  REGISTRATION  FORM");
Label n=new Label("Name:");
Label p=new Label("Password:");
Label e=new Label("Email ID:");
name=new TextField(12);
pass=new TextField(8);
pass.setEchoChar('*');
j=new TextField(12);
Button km=new Button("Register");
Button km1=new Button("Clear");
Label s=new Label("Address:");
a=new TextArea();
Label s1=new Label("Gender:");
Checkbox c1=new Checkbox("Male",cbg,false);
Checkbox c2=new Checkbox("Female",cbg,false);
Label s2=new Label("Nationality:");
Checkbox c3=new Checkbox("Indian");
Checkbox c4=new Checkbox("Other");
Label s3=new Label("Course:");
Choice z1=new Choice();
z1.add("B.sc");
z1.add("M.sc");
z1.add("P.hd");
z1.add("M.sc 5 years");
Label s4=new Label("Sem:");
Choice z2=new Choice();
z2.add("1st");
z2.add("2nd");
z2.add("3rd");
z2.add("4th");
z2.add("5th");
z2.add("6th");
km1.addActionListener(this);
n1.setBounds(10,5,200,20);
n.setBounds(10,40,100,20);
name.setBounds(120,40,100,20);
p.setBounds(10,90,100,20);
pass.setBounds(120,90,100,20);
e.setBounds(10,150,100,20);
j.setBounds(120,150,100,20);
s.setBounds(10,220,100,20);
a.setBounds(120,220,150,60);
s1.setBounds(10,300,100,20);
c1.setBounds(120,300,100,20);
c2.setBounds(240,300,100,20);
s2.setBounds(10,390,100,20);
c3.setBounds(120,390,100,20);
c4.setBounds(240,390,100,20);
s3.setBounds(10,490,100,20);
z1.setBounds(120,490,100,20);
s4.setBounds(10,600,100,20);
z2.setBounds(120,600,100,20);
km.setBounds(10,680,100,20);
km1.setBounds(240,680,100,20);
add(n1);
add(n);
add(name);
add(p);
add(pass);
add(e);
add(j);
add(s);
add(a);
add(s1);
add(c1);
add(c2);
add(s2);
add(c3);
add(c4);
add(s3);
add(z1);
add(s4);
add(z2);
add(km);
add(km1);
}
public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(str.equals("Clear"))
{
name.setText(null);
pass.setText(null);
j.setText(null);
a.setText(null);
}
repaint();

}
public void itemStateChanged(ItemEvent ie)
{
repaint();
}
}

