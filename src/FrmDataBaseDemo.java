
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FrmDataBaseDemo extends JFrame  implements ActionListener,KeyListener
{
	JPanel jp1,jp2;
	JLabel lblRno,lblNm,lblPer;
	JButton btnNew,btnSave,btnEdit,btnDel,btnSearch,btnFst,btnPre,btnNxt,btnLst;
	JTextField txtRno,txtNm,txtPer;
	Connection con=null;
	Statement stmt;
	ResultSet rs=null,rsNavigate=null;
	int f=0;
	int recpos=0;
   	public FrmDataBaseDemo()
   	{
   		setSize(453,308);
   		setLocation(200,150);
   		setLayout(null);
   		Font f1=new Font("Verdana",1,10);
   		
   		jp1=new JPanel();
		jp1.setBounds(75,25,273,143);
		jp1.setBorder(BorderFactory.createEtchedBorder());
		add(jp1);
		jp1.setLayout(null);
		
   		jp2=new JPanel();
   		jp2.setBounds(12,187,414,71);
		jp2.setBorder(BorderFactory.createEtchedBorder());
		add(jp2);
		jp2.setLayout(null);
		
		lblRno=new JLabel("Roll No. :");
		lblRno.setBounds(30,23,83,13);
		jp1.add(lblRno);
		
		lblNm=new JLabel("Name :");
		lblNm.setBounds(37,58,47,13);
		jp1.add(lblNm);
		
		lblPer=new JLabel("Percentage :");
		lblPer.setBounds(8,93,80,13);
		jp1.add(lblPer);
		
		txtRno=new JTextField();
		txtRno.setBounds(100,21,73,20);
		jp1.add(txtRno);
		txtRno.addKeyListener(this);
		
		txtNm=new JTextField();
		txtNm.setBounds(100,56,157,20);
		jp1.add(txtNm);
		txtNm.addKeyListener(this);
		
		txtPer=new JTextField();
		txtPer.setBounds(100,91,73,20);
		jp1.add(txtPer);
		txtPer.addKeyListener(this);
		
		btnNew=new JButton("New");
		btnNew.setBounds(4,4,75,23);
		jp2.add(btnNew);
		btnNew.addActionListener(this);
		
   		btnSave=new JButton("Save");
		btnSave.setBounds(85,4,75,23);
		jp2.add(btnSave);
		btnSave.addActionListener(this);
	
		btnEdit=new JButton("Edit");
		btnEdit.setBounds(166,4,75,23);
		jp2.add(btnEdit);  
		btnEdit.addActionListener(this);
			
		btnDel=new JButton("Delete");
		btnDel.setBounds(247,4,75,23);
		jp2.add(btnDel);
		btnDel.addActionListener(this);
		
		btnSearch=new JButton("Search");
		btnSearch.setBounds(328,4,75,23);
		jp2.add(btnSearch); 
		btnSearch.addActionListener(this);
			
		btnFst=new JButton("|<");
		btnFst.setBounds(210,32,45,23);
		jp2.add(btnFst);	
		btnFst.addActionListener(this);
	
		btnPre=new JButton("<");
		btnPre.setBounds(259,32,43,23);
		jp2.add(btnPre);	
		btnPre.addActionListener(this);
	
		btnNxt=new JButton(">");
		btnNxt.setBounds(308,32,43,23);
		jp2.add(btnNxt);
		btnNxt.addActionListener(this);	
	
		btnLst=new JButton(">|");
		btnLst.setBounds(357,32,45,23);
		jp2.add(btnLst);
		btnLst.addActionListener(this);	
			
		disableText();
		setVisible(true);
		refreshdata();
   	
   }
   void disableText()
   {
   		txtRno.enable(false);
   		txtNm.enable(false);
   		txtPer.enable(false);
   }
   
   void enableText()
   {
   		txtRno.enable(true);
   		txtNm.enable(true);
   		txtPer.enable(true);
   }
   void clearText()
   {
   			txtRno.setText("");
    		txtNm.setText("");
    		txtPer.setText("");
   }
   void refreshdata()
   {
   	    try
    	{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String myDB1 ="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=d:\\DemoDB.accdb ";
			con = DriverManager.getConnection(myDB1," ", ""); 
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		 	rsNavigate=stmt.executeQuery("select * from Stud");
		 	rsNavigate.next();
	    	recpos=0;
	   
	    }
	    catch(Exception ex)
	    {}
	        		
	    
   }
    public void actionPerformed(ActionEvent e)
    {
    	try
    	{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String myDB1 ="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=d:\\DemoDB.accdb ";
			con = DriverManager.getConnection(myDB1," ", ""); 
	    }
	    catch(Exception ex)
	    {}
    	
    	if(e.getSource()==btnNew)
    	{
    			f=1;
    			enableText();
    			clearText();
    			try
				{
					rs=stmt.executeQuery("Select Max(rno) From Stud");
					if(rs.next())
						txtRno.setText(""+(rs.getInt(1)+1));
					else
						txtRno.setText("1");		
					txtRno.setEditable(false);
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,""+ex);
				}
				if(txtRno.getText()==null)
						txtRno.setText("1");	
				txtNm.requestFocus();
    	}
    	if(e.getSource()==btnEdit)
    	{
    			f=2;
    	}
    	if(e.getSource()==btnSave)
    	{
    		if(f==1)
    		{
    			try
    			{
    	    		stmt=con.createStatement(); 
	        		stmt.executeUpdate("insert into Stud values("+txtRno.getText()+",'"+txtNm.getText()+"',"+txtPer.getText()+")");
	        		JOptionPane.showMessageDialog(null,"record saved");
	        		f=0; 
	        		disableText();
    			}
    			catch(Exception ex)
    			{
    				 JOptionPane.showMessageDialog(null,ex);
    			}
    		}
    		else
    			if(f==2)
    			{
    						try
    						{
	        					stmt=con.createStatement(); 
	        					stmt.executeUpdate("update Stud set nm='"+txtNm.getText()+"',per="+txtPer.getText()+" where rno="+txtRno.getText());
	        					JOptionPane.showMessageDialog(null,"record updated"); 
	        					f=0;
	        					disableText();
    						}
    						catch(Exception ex)
    						{
    				  			JOptionPane.showMessageDialog(null,ex);
    						}
      				}
      		
      			refreshdata();		
    		}
    		if(e.getSource()==btnDel)
    		{
    				try
    				{
	        			stmt=con.createStatement(); 
	        			stmt.executeUpdate("delete from Stud where rno="+txtRno.getText());
	        			JOptionPane.showMessageDialog(null,"record deleted"); 
	        			f=0;
	        			
    				}
    				catch(Exception ex)
    				{
    				  	JOptionPane.showMessageDialog(null,ex);
    				}
    				refreshdata();
    		}
    		if(e.getSource()==btnSearch)
    		{
    				String r;
    				r=JOptionPane.showInputDialog(null,"enter roll no. which you want to search");
    				
    				if(r==null)
    				{
    					JOptionPane.showMessageDialog(null,"please input the rollno");
    					return ;
    				}
    				else
    				{
    					
    				}
    				txtRno.setText(r);
    				
    				try
    				{
	        			stmt=con.createStatement();  	
	        			rs=stmt.executeQuery("select * from Stud where rno="+txtRno.getText());
	        			while(rs.next())
	        			{		
	        		 		txtNm.setText(rs.getString(2));
	        		 		txtPer.setText(rs.getString(3));
	        			}
    				}
    				catch(Exception ex)
    				{
    				  	JOptionPane.showMessageDialog(null,ex);
    				}
    		}
    		if(e.getSource()==btnFst)
			{
				
				try
				{	
			  		if(rsNavigate.first())
			  		{	
			  						txtRno.setText(rsNavigate.getString(1));
			  						txtNm.setText(rsNavigate.getString(2));
			  						txtPer.setText(rsNavigate.getString(3));
			  		}
			  	}
				catch(Exception E)
				{   
					JOptionPane.showMessageDialog(null,E);
			 	}
			}
			if(e.getSource()==btnLst)
			{
				try
				{	
			  		if(rsNavigate.last())
			  		{	
			  						txtRno.setText(rsNavigate.getString(1));
			  						txtNm.setText(rsNavigate.getString(2));
			  						txtPer.setText(rsNavigate.getString(3));
			  		}
			  	}
				catch(Exception E)
				{   
					JOptionPane.showMessageDialog(null,E);
			 	}
			}
			if(e.getSource()==btnPre)
			{
					try
					{		
			  				if(rsNavigate.previous())
			  					{		
			  						JOptionPane.showMessageDialog(null,"5");			
			  						txtRno.setText(rsNavigate.getString(1));
			  						txtNm.setText(rsNavigate.getString(2));
			  						txtPer.setText(rsNavigate.getString(3));
			  					}
					}
					catch(Exception E)
					{
						JOptionPane.showMessageDialog(null,E);	
					}	
       }
       	if(e.getSource()==btnNxt)
			{
					try
					{					
			  				if(rsNavigate.next())
			  					{		
			  						JOptionPane.showMessageDialog(null,"5");			
			  						txtRno.setText(rsNavigate.getString(1));
			  						txtNm.setText(rsNavigate.getString(2));
			  						txtPer.setText(rsNavigate.getString(3));
			  					}			
					}
					catch(Exception E)
					{
						JOptionPane.showMessageDialog(null,E);	
					}	
       }
    }
    public void keyReleased(KeyEvent ke1)
	{
		
	}
	public void keyPressed(KeyEvent ke2)
	{
		
	}
	public void keyTyped(KeyEvent ke3)
	{
		if(ke3.getSource()==txtNm)
		{
					if((ke3.getKeyChar()>='A'&&ke3.getKeyChar()<='Z')||(ke3.getKeyChar()>='a'&&ke3.getKeyChar()<='z')||ke3.getKeyChar()==KeyEvent.VK_BACK_SPACE||ke3.getKeyChar()==KeyEvent.VK_SPACE)
					{}
					else
					{
						JOptionPane.showMessageDialog(null,"Not allowed other symbols");
						ke3.consume();
					}
		}
		if(ke3.getSource()==txtRno)
		{
			if((ke3.getKeyChar()>='0'&&ke3.getKeyChar()<='9')|| ke3.getKeyChar()==KeyEvent.VK_BACK_SPACE)
			{}
			else
			{
					JOptionPane.showMessageDialog(null,"Plz enter only numbers");
					ke3.consume();
			}
		}
		if(ke3.getSource()==txtPer)
		{
			if((ke3.getKeyChar()>='0'&&ke3.getKeyChar()<='9')|| ke3.getKeyChar()==KeyEvent.VK_BACK_SPACE|| ke3.getKeyChar()=='.')
			{}
			else
			{
					JOptionPane.showMessageDialog(null,"Plz enter only numbers");
					ke3.consume();
			}
		}
	}
   
   public static void main(String[] a)
   {
   		new FrmDataBaseDemo();
   }
   
   
   
}