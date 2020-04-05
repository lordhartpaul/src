import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Loginn extends Frame implements ActionListener {
JFrame f1,f2;
JLabel l1,l2,l3,ty;
TextField t1,t2;
JButton b1,b2;
Choice ch1;
MenuBar mb;
Menu f;
MenuItem n,op,cl;
Font fn;

public static String s1,s2,s3;

	public void loginn1(){
		f1=new JFrame("Login");
		fn=new Font("Arial Black",Font.BOLD,25);		

		l1=new JLabel("User Login");	
		l2=new JLabel("User Name: ");
		l3=new JLabel("Password: ");
		ty=new JLabel("Type:");
		t1=new TextField(30);
		t2=new TextField(30);
		t2.setEchoChar('*');
		ch1=new Choice();

		b1=new JButton("Log in");
		b2= new JButton("Cancel");
		

		f1.setBounds(300,200,400,300);
		f1.setLayout(null);
		f1.add(l1);
		l1.setBounds(100,20,200,50);
		l1.setFont(fn);
		l1.setForeground(Color.red);
		f1.setBackground(Color.green);
		f1.add(l2);
		l2.setBounds(20,90,100,30);	
		//l2.setColor(Color.red);
		f1.add(t1);
		t1.setBounds(130,90,100,30);			
		f1.add(l3);
		l3.setBounds(20,130,100,30);			
		f1.add(t2);
		t2.setBounds(130,130,100,30);			
		
		f1.add(ty);
		ty.setBounds(20,170,100,30);
		f1.add(ch1);
		ch1.add("Normal");
		ch1.add("Admin");
		ch1.setBounds(130,170,100,30);
		f1.add(b2);
		b2.setBounds(200,210,60,30);			
		b2.addActionListener(this);

		f1.add(b1);
		b1.setBounds(130,210,60,30);			
		b1.addActionListener(this);
		f1.setVisible(true);

		f1.setResizable(true);
		f1.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent we)
		{
			System.exit(0);
		}
		});

	}

	public void welcome(){
		
		
		f2=new JFrame("WelCome");
		mb=new MenuBar();
		f=new Menu("file");
		op=new MenuItem("Open");
		n=new MenuItem("new");
		cl=new MenuItem("Terminate");
		
		System.out.print(s3);
		f2.setMenuBar(mb);
		mb.add(f);
		f.add(n);
		f.add(op);
		f.add(cl);

		if(s3.equals("Normal") ) {
		
			op.setEnabled(false);
			cl.setEnabled(false);
		}

		f2.setVisible(true);
		f2.setSize(400,500);
		
		f2.setResizable(true);
	
		//f2.setBounds(300,200,400,400);
		
		
	}

// for normal usr
	public void normal(){
		f2=new JFrame("WelCome to Normal User");
		JLabel wc;
		wc=new JLabel("You are log in as Normal User");
		f2.add(wc);
		f2.setLayout(null);
		wc.setBounds(100,100,300,50);
		f2.setVisible(true);
		f2.setSize(400,500);
		
		f2.setResizable(true);
	
		//f2.setBounds(300,200,400,400);
		
		
	}

	public static void main(String args[]){
		Loginn lg=new Loginn();
		lg.loginn1();

	}
	public void actionPerformed(ActionEvent ae){

		if(ae.getSource()==b1){


			s1=t1.getText();
			s2=t2.getText();
			s3=ch1.getSelectedItem();
			//System.out.println(s3);
			if(s1.equalsIgnoreCase("admin") && s2.equalsIgnoreCase("password") ){
				
					f1.setVisible(false);
					//JOptionPane.showMessageDialog(null,"Wel-come "+ch1.getSelectedItem(),"".WARNING_MESSAGE);
					Loginn lg=new Loginn();
					lg.welcome();
					s3=ch1.getSelectedItem();

					
								
			}
			
		if(ae.getSource()==b2){
			
			System.exit(0);
			}
		}
	}
}
