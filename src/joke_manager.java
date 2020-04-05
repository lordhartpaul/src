import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;
/*<applet code="joke_manager"width=300 height=300>
  </applet>
 */
public class joke_manager extends Applet implements ActionListener
{
    String msg="";
    Button b1,b2,b3,b4;
    Label l1,l2,l3,l4;
    TextField txt1,txt2;
    TextArea txt3;
    Connection con;
    Statement stmt;
    
    public void init()
    {
        setLayout(null);
        setBackground(Color.yellow);
        setForeground(Color.black);
        l1=new Label("Joke Manager Database");
        l2=new Label("Serial No.");
        l3=new Label("Joke Type");
        l4=new Label("Joke");
        txt1=new TextField(3);
        txt2=new TextField(8);
        txt3=new TextArea();
        b1=new Button("New/Clear");
        b2=new Button("Save");
        b3=new Button("Search");
        b4=new Button("cancel");
        txt1.addActionListener(this);
        txt2.addActionListener(this);
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
        txt3.setBounds(120,150,150,60);
        b1.setBounds(10,220,100,20);
        b2.setBounds(120,220,100,20);
        b3.setBounds(240,220,100,20);
        b4.setBounds(120,300,100,20);
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
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/joke_manager_system"," root", ""); 
}
catch(Exception ex)
 {}  
 if(ae.getSource()==b1)
 {
     msg="Enter new data to insert";
     txt1.setText(null);
     txt2.setText(null);
     txt3.setText(null);
     
 } 
 else if(ae.getSource()==b2)
 {
     try
   {
     Class.forName("com.mysql.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/joke_manager_system","root",""); 
     stmt=con.createStatement(); 
     stmt.executeUpdate("insert into joke_manager values("+txt1.getText()+",'"+txt2.getText()+"','"+txt3.getText()+"')"  );
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
   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/joke_manager_system","root",""); 
   stmt=con.createStatement();  	
  ResultSet rs=stmt.executeQuery("select * from joke_manager where srl= "+txt1.getText()+" ");
   while(rs.next())
{		
 txt2.setText(rs.getString(2));
 txt3.setText(rs.getString(3));
}
    }
 catch(Exception ex)
   {
    msg+="null"+ex.getMessage();
    }
 }
 else if(ae.getSource()==b4)
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
      