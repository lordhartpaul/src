import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;
/*<applet code="Registration"width=300 height=300>
</applet>
*/
public class Registration_form extends Applet implements ActionListener,ItemListener
{
    String msg="";
TextField name,pass,j;
TextArea a;
CheckboxGroup cbg;
Checkbox c1,c2;
Checkbox c3,c4;
Choice z1,z2;
Button km,km1;
Connection con;
Statement stmt;
private String in="indian";
private String out="other";
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
 km=new Button("Register");
 km1=new Button("Clear");
Label s=new Label("Address:");
a=new TextArea();
Label s1=new Label("Gender:");
 c1=new Checkbox("Male",cbg,false);
 c2=new Checkbox("Female",cbg,false);
Label s2=new Label("Nationality:");
c3=new Checkbox("Indian");
 c4=new Checkbox("Other");
Label s3=new Label("Course:");
 z1=new Choice();
z1.add("B.sc");
z1.add("M.sc");
z1.add("P.hd");
z1.add("M.sc5yrs");
Label s4=new Label("Sem:");
 z2=new Choice();
z2.add("1st");
z2.add("2nd");
z2.add("3rd");
z2.add("4th");
z2.add("5th");
z2.add("6th");
km1.addActionListener(this);
km.addActionListener(this);
name.addActionListener(this);
pass.addActionListener(this);
j.addActionListener(this);
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
    try
   {
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration_form"," root", ""); 
}
catch(Exception ex)
 {}  
if(ae.getSource()==km1)
{
name.setText(null);
pass.setText(null);
j.setText(null);
a.setText(null);
}
 else if(ae.getSource()==km)
 {
     
 try
   {
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration_form","root",""); 
     stmt=con.createStatement(); 
      stmt.executeUpdate("insert into registration(name,passwd,email,addrss,gndr,ntnlty,crse,sem) values('"+name.getText()+"', "+pass.getText()+" ,'"+j.getText()+" ','"+a.getText()+"','"+cbg.getSelectedCheckbox().getLabel()+"',' "+in+" ','"+z1.getSelectedItem()+" ','"+z2.getSelectedItem()+" '   )");
     msg="save Success";
     con.close();
     stmt.close();
}
catch(Exception e1)
{
msg+="Error: "+e1.getMessage();
}
 }
repaint();

}
public void itemStateChanged(ItemEvent ie)
{
     
     repaint();
}
public void paint(Graphics g)
{
    
    g.drawString(msg,340,250);
}
}

