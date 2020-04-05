import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
class donor extends JFrame implements ActionListener
{
	JLabel l1,l2,l3;
	JTextField [] tx;
	JButton b1,b2,b3;
	JPanel p;
	GridBagConstraints gbc;
	JFrame fr;
	Connection con;
	PreparedStatement prst;
	Statement st;
	
	donor()
	{
		fr=new JFrame("DataBase Connectivity");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		l1=new JLabel("Name :");
		l2=new JLabel("Address :");
		l3=new JLabel("Contact :");
		
		b1=new JButton("Save");
		b2=new JButton("Close");
		b3=new JButton("Retrieve");
		
		tx=new JTextField[3];
		for(int i=0;i<=2;++i)
		tx[i]=new JTextField(10);
		
		p=new JPanel(new GridBagLayout());
		additem(p,l1,0,0,GridBagConstraints.WEST);		
		additem(p,tx[0],1,0,GridBagConstraints.WEST);	
		additem(p,l2,0,1,GridBagConstraints.WEST);	
		additem(p,tx[1],1,1,GridBagConstraints.WEST);	
		additem(p,l3,0,2,GridBagConstraints.WEST);	
		additem(p,tx[2],1,2,GridBagConstraints.WEST);	
		
		additem(p,new JLabel("      "),0,4,GridBagConstraints.WEST);	
		additem(p,b1,0,5,GridBagConstraints.WEST);	
		additem(p,b2,1,5,GridBagConstraints.WEST);	
		additem(p,b3,0,6,GridBagConstraints.WEST);		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		this.add(p);
		this.setVisible(true);
		this.setSize(400,400);
		
	}
	public void additem(JPanel p, JComponent c,int x, int y,int align)
	{
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = x;
		gc.gridy = y;
		gc.insets = new Insets(3,3,3,3);
		gc.anchor = align;
		p.add(c, gc);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con = DriverManager.getConnection("jdbc:odbc:abc");
				st = con.createStatement();
				//ResultSet rs1 = st.executeQuery("Select contact from INFO1 where address ='"+str+"'");
				con.close();				
			}
			catch(Exception ss)
			{
			}
		}
		if(e.getSource()==b2)
		{
			try
			{
				System.exit(0);
			}
			catch(Exception sss)
			{
			}
		}
		if(e.getSource()==b3)
		{
			try
			{
				JFrame jj=new JFrame("Retrieve");
				JPanel p=new JPanel();
				JLabel l=new JLabel("   	RETRIEVE");
				p.add(l);
				JPanel p1=new JPanel();
				p1.add(new JLabel("                                                                       "));
				p1.add(new JLabel("jjkj"));
				jj.add(p);
				p1.add(p);
				jj.add(p1);
				jj.setVisible(true);
				jj.setSize(500,500);
				
				
			}
			catch(Exception s1)
			{
			}
			
		}
	}
	public static void main(String agrs[])
	{
		new donor();
	}
}