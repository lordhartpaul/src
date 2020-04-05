import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;
/*<applet code="robot_chatting_system"width=300 height=300>
  </applet>
 */
 public class robot_chatting_system extends Applet implements ActionListener
 {
    String msg="";
    Button b1,b2,b3;
    Label l1,l2,l3;
    TextField txt1;
    TextArea txt2;
    Connection con;
    Statement stmt;
     public void init()
    {
        setLayout(null);
        setBackground(Color.yellow);
        setForeground(Color.black);
        l1=new Label("BIONIC WOMAN");
        l2=new Label("User");
        l3=new Label("Bot");
        txt1=new TextField(100);
        txt2=new TextArea();
        b1=new Button("Send");
        b2=new Button("Reply");
        b3=new Button("Cancel");
        txt1.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        l1.setBounds(10,5,250,30);
        l2.setBounds(10,40,100,20);
        txt1.setBounds(220,40,200,40);
        l3.setBounds(10,90,200,20);
        txt2.setBounds(220,90,280,60);
        b1.setBounds(10,180,100,20);
        b2.setBounds(120,180,100,20);
        b3.setBounds(240,180,100,20);
        add(l1);
        add(l2);
        add(txt1);
        add(l3);
        add(txt2);
        add(b1);
        add(b2);
        add(b3);
     }
     public void actionPerformed(ActionEvent ae)
 {
  try
   {
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/robot_chatmanager"," root", ""); 
}
catch(Exception ex)
 {}  
  if(ae.getSource()==b1)
 {
  try
  {
    Class.forName("com.mysql.jdbc.Driver");
   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/robot_chatmanager","root",""); 
   stmt=con.createStatement();  	
  ResultSet rs=stmt.executeQuery("select * from chatmanager where user= '"+txt1.getText()+"' ");
   while(rs.next())
{		
 txt2.setText(rs.getString(2));
 msg="Sended";
}
    }
 catch(Exception ex)
   {
    msg+="null"+ex.getMessage();
    }
 }
  else if(ae.getSource()==b2)
  {
      txt1.setText(null);
      txt2.setText(null);
      msg="Textfield clear";
  }
  else if(ae.getSource()==b3)
  {
      System.exit(0);
  }
  repaint();
     }
     public void paint(Graphics g)
{
    
    g.drawString(msg,340,250);
}
 }