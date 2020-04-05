//  Chatting using Applet 

import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java .applet.*;

public class chat extends Applet 
implements ActionListener
 {
     InetAddress ad;
     ServerSocket se;
     Socket s;
     Socket s1;  
     DataOutputStream da1; 
     DataInputStream da;
     TextField tf;
     String s2="";
     TextArea text=new TextArea(s2,10,30);
     Label l=new Label("CHATTING");
    
     int twist=0;
     
   public void init()
   {
      setBackground(Color.orange);
      tf=new TextField(s2,20);
      
      add(l);add(tf);add(text);
      tf.addActionListener(this);
        
      try{initial();}catch(Exception e){}
   }

 public void initial()throws Exception
  {
    se =new ServerSocket(5001);
    s =se.accept();  
    da = new DataInputStream(s.getInputStream());
    
    ad =InetAddress.getLocalHost();
    s1 =new Socket(ad.getHostName(),5011);       
    da1 = new DataOutputStream(s1.getOutputStream());
    server();
  }

 public void actionPerformed(ActionEvent ae) 
  {
    
   try{
       
         client();   
       }
   catch(Exception e){ }
  }


 public void server() throws Exception
   {  
         
       String c;
       tf.setText("DONOT TYPE:********************"); 
       showStatus("WAIT for Message"); 
       if((c=da.readUTF())!=" ")
        { 
       
       text.append("Yourself:"+c+"\n"); 
       
       if(c.equals("bye"))
        {
         tf.setText("Connection Terminated::Close Window");  
         s.close();
         System.exit(0); 
        }
        for(int i=0;i<3000000;i++)
         showStatus("Please Type ur Message");
        showStatus("Type 'bye' to Terminate");
        tf.setText("");
       }         
   }

public void client() throws Exception
  {
       
       String s2,s3;
       s2=tf.getText(); 
       s3="Myself:"+s2+"\n";
       text.append(s3);
     
       da1.writeUTF(s2);       
       
       if(s2.equals("bye"))
        {
         tf.setText("Connection Terminated::Close Window");
         s.close(); 
         System.exit(0);        
        }

       else
        showStatus("Type 'bye' to Terminate");

       tf.setText(""); server();            
  }


 
} 
  



/*<applet code="chat" width=240 height=240>
  </applet>*/
 
      


   

  
                     