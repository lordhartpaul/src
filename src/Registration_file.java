import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
/*<applet code="Registration_file"width=300 height=300>
</applet>
*/
public class Registration_file extends Applet implements ActionListener,ItemListener
{
TextField name,pass,j;
TextArea a,sp;
Button km,km1,rgstr;
Choice z1,z2;
CheckboxGroup cbg;
private String in="indian";
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
km=new Button("Print");
 km1=new Button("Clear");
 rgstr=new Button("Register");
Label s=new Label("Address:");
a=new TextArea();
Label s1=new Label("Gender:");
Checkbox c1=new Checkbox("Male",cbg,false);
Checkbox c2=new Checkbox("Female",cbg,false);
Label s2=new Label("Nationality:");
Checkbox c3=new Checkbox("Indian");
Checkbox c4=new Checkbox("Other");
Label s3=new Label("Course:");
 z1=new Choice();
z1.add("B.sc");
z1.add("M.sc");
z1.add("P.hd");
z1.add("M.sc 5 years");
Label s4=new Label("Sem:");
 z2=new Choice();
z2.add("1st");
z2.add("2nd");
z2.add("3rd");
z2.add("4th");
z2.add("5th");
z2.add("6th");
sp=new TextArea();
km1.addActionListener(this);
km.addActionListener(this);
name.addActionListener(this);
pass.addActionListener(this);
j.addActionListener(this);
rgstr.addActionListener(this);
c1.addItemListener(this);
c2.addItemListener(this);
c3.addItemListener(this);
c4.addItemListener(this);
z1.addItemListener(this);
z2.addItemListener(this);
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
sp.setBounds(650,40,400,550);
rgstr.setBounds(750,600,100,20);
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
add(sp);
add(rgstr);
}
public void actionPerformed(ActionEvent ae)
{
String str=ae.getActionCommand();
if(ae.getSource()==km1)
{
name.setText(null);
pass.setText(null);
j.setText(null);
a.setText(null);
}
 else if(ae.getSource()==km)
{
String s11=name.getText();
String s12=pass.getText();
String s13=j.getText();
String s14=a.getText();
String s15=cbg.getSelectedCheckbox().getLabel();
String s16=in;
String s17=z1.getSelectedItem();
String s18=z2.getSelectedItem();
sp.setText("\n\n"+"Name: "+s11+"\n\n"+"Password: "+s12+"\n\n"+"Email ID: "+s13+"\n\n"+"Address: "+s14+"\n\n"+"Gender: "+s15+"\n\n"+"Nationality: "+s16+"\n\n"+"Course: "+s17+"\n\n"+"Semester: "+s18+"\n\n");
}
else if(ae.getSource()==rgstr)
{
try
{
FileOutputStream fos=new FileOutputStream("Output.txt",true);
DataOutputStream dos=new DataOutputStream(fos);
String str2="\n";
String str1=sp.getText();
dos.writeChars(str1+str2);
JOptionPane.showMessageDialog(this, "Register Success");
dos.close();
}
catch(Exception e){}
}

repaint();
}
public void itemStateChanged(ItemEvent ie)
{
repaint();
}
public void paint(Graphics g)
{
g.setColor(Color.blue);
g.drawLine(485,5,485,680);
g.drawLine(490,5,490,680);
}
}

