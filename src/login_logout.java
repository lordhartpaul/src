import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;
/*<applet code="login_logout"width=300 height=300>
  </applet>
 */
public class login_logout extends Applet implements ActionListener
{
    String msg="";
    Button b1,b2,b3,b4;
    Label l1,l2,l3,l4;
    TextField txt1,txt2,txt3;
    Connection con;
    Statement stmt;
    private String out="out";
    private String in="in";
    public void init()
    {
        setLayout(null);
        setBackground(Color.yellow);
        setForeground(Color.black);
        l1=new Label("Student Login Register");
        l2=new Label("Semester");
        l3=new Label("Name");
        l4=new Label("Roll No.");
        txt1=new TextField(3);
        txt2=new TextField(10);
        txt3=new TextField(3);
        b1=new Button("Login");
        b2=new Button("Logout");
        b3=new Button("Clear");
        b4=new Button("Cancel");
        txt1.addActionListener(this);
        txt2.addActionListener(this);
        txt3.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        l1.setBounds(10,5,200,20);
        l2.setBounds(10,40,100,20);
        txt1.setBounds(240,40,100,20);
        l3.setBounds(10,90,200,20);
        txt2.setBounds(240,90,100,20);
        l4.setBounds(10,150,100,20);
        txt3.setBounds(240,150,100,20);
        b1.setBounds(10,220,100,20);
        b2.setBounds(120,220,100,20);
        b3.setBounds(240,220,100,20);
        b4.setBounds(240,300,100,20);
        add(l1);
        add(l2);
        add(txt1);
        add(l3);
        add(txt2);
        add(l4);
        add(txt3);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
     }
     public void actionPerformed(ActionEvent ae)
 {
  try
   {
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_register"," root", ""); 
}
catch(Exception ex)
 {}  
      
 if(ae.getSource()==b3)
 {
     msg="Clear Success";
     txt1.setText(null);
     txt2.setText(null);
     txt3.setText(null);
 }
   else if(ae.getSource()==b4)
 {
   System.exit(0);  
 }
   else if(ae.getSource()==b1)
 {
 try
   {
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_register","root",""); 
     stmt=con.createStatement(); 
     stmt.executeUpdate("insert into regstr(sem,name,roll_no,log_in) values("+txt1.getText()+",'"+txt2.getText()+"',"+txt3.getText()+",'"+in+"' )");
     msg="Login Success";
     con.close();
     stmt.close();
}
catch(Exception e1)
{
msg+="Error: "+e1.getMessage();
}
 }
   else if(ae.getSource()==b2)
 {
 try
   {
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_register","root",""); 
     stmt=con.createStatement(); 
     stmt.executeUpdate("update regstr set regstr.log_out= '"+out+"' where regstr.sem= "+txt1.getText()+" and regstr.roll_no="+txt3.getText()+" ");
     msg="Logout Success";
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
    @Override
     public void paint(Graphics g)
{
    g.drawString(msg,340,250);
}
}
        