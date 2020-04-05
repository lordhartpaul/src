import java.applet.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.*;

public class banner extends JApplet implements Runnable,ActionListener
{
	Thread t;
	String msg="String will be scrolling here                                                                                                                ";
	int state;
	boolean stopflag;
	JLabel l1,l2;
	JButton b1;
	JTextField t1;
	Container con;
	public void init()
	{
		con=getContentPane();
		con.setLayout(new FlowLayout());
		l1=new JLabel("BANNER");
		l2=new JLabel("Enter the string to be shown as banner");
		t1=new JTextField(25);
		b1=new JButton("Apply");
		t1.setForeground(Color.magenta);
		con.add(l1);
		con.add(l2);
		con.add(t1);
		con.add(b1);
		b1.addActionListener(this);
		con.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1){
			msg=t1.getText()+"                                                                                                                                            ";
			t.start();}
	}
	public void start()
	{
		t=new Thread(this);
		stopflag=false;
		t.start();
	}
	public void run()
	{
		char ch;
		repaint();
		while(true)
		{
			try{
			repaint();
			Thread.sleep(300);
			ch=msg.charAt(0);
			msg=msg.substring(1,msg.length());
			msg+=ch;
			if(stopflag)
				break;
			}catch(InterruptedException e)
			{}
	
				
		}
	}
	public void stop()
	{
		stopflag=true;
		t=null;
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.green);
		g.fillRect(0,0,500,20);
		g.setColor(Color.blue);
		g.drawString(msg,0,15);
		g.drawString("VERSION : 1.0",100,100);
	}
}
