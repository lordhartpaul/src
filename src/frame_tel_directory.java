import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class frame_tel_directory extends Frame implements ActionListener
{
    String msg="";
    Button b1,b2,b3,b4,b5;
    Label l1,l2,l3;
    TextField txt1,txt2;
    Connection con;
    Statement stmt;
    frame_tel_directory()
    {
        setLayout(null);
        setBackground(Color.yellow);
        setForeground(Color.black);
        l1=new Label("Telephone Directory System");
        l2=new Label("Name");
        l3=new Label("Telephone Number");
        txt1=new TextField(12);
        txt2=new TextField(14);
        b1=new Button("New");
        b2=new Button("Save");
        b3=new Button("Search");
        b4=new Button("Clear");
        b5=new Button("cancel");
        txt1.addActionListener(this);
        txt2.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
 
        l1.setBounds(10,5,200,20);
        l2.setBounds(10,40,100,20);
        txt1.setBounds(240,40,100,20);
        l3.setBounds(10,90,200,20);
        txt2.setBounds(240,90,100,20);
        b1.setBounds(10,150,100,20);
        b2.setBounds(120,150,100,20);
        b3.setBounds(240,150,100,20);
        b4.setBounds(10,220,100,20);
        b5.setBounds(120,220,100,20);
        add(l1);
        add(l2);
        add(txt1);
        add(l3);
        add(txt2);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
setSize(500,450);
setVisible(true);
}
public void actionPerformed(ActionEvent ae)
 {
  try
   {
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tel_directory_system"," root", ""); 
}
catch(Exception ex)
 {}  
 if(ae.getSource()==b1)
 {
     msg="clear";
     txt1.setText(null);
     txt2.setText(null);
     }
 else if(ae.getSource()==b4)
 {
     msg="ready to insert";
     txt1.setText(null);
     txt2.setText(null);
   }
 else if(ae.getSource()==b5)
 {
   System.exit(0);  
 }
 else if(ae.getSource()==b2)
 {
 try
   {
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tel_directory_system","root",""); 
     stmt=con.createStatement(); 
     stmt.executeUpdate("insert into directory values('"+txt1.getText()+"',"+txt2.getText()+")");
     msg="save Success";
     con.close();
     stmt.close();
}
catch(Exception e1)
{
msg+="Error: "+e1.getMessage();
}
 }
 else if(ae.getSource()==b3)
 {
  try
  {
    Class.forName("com.mysql.jdbc.Driver");
   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tel_directory_system","root",""); 
   stmt=con.createStatement();  	
   ResultSet rs=stmt.executeQuery("select * from directory where person_name= '"+txt1.getText()+"' ");
   while(rs.next())
{		
 txt2.setText(rs.getString(2));
}
    }
catch(Exception ex)
   {
    msg+="null"+ex.getMessage();
   }
 }
repaint();
    }
   public void paint(Graphics g)
{
g.drawString(msg,300,400);
} 
public static void main(String[] args)
{
frame_tel_directory ss=new frame_tel_directory();
ss.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent evt){System.exit(0);}});
}
}