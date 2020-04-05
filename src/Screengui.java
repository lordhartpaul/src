/***************************************************************** 
 *  Screengui.java -- last modified Saturday, February 19, 2007  *
 * This project is Developed for INTERNET PROGRAMMING PROJECT    *
 *																 *
 *																 *
 *																 *
 *        T O BE SUBMITTED TO :SISAY ADUGNA                      *
 *        =================================                      *
 *     					                                         *
 *        Project title:personal diary -TIZITA                   *
 *        ====================================                   *
 *   Authors:													 *
 *         NAME                  ID								 *
 *         =========             =========                       *
 *         Alebachew Ali---------R\1940\97                       *
 *		   Yigebal Genet---------R\2006\97						 *
 *         Yonas Mitike----------R\2008\97                       *
 *                                                               *
 *       YONAS MITIKE AND HIS FRIENDS CAN BE CONTACTED           *                                                  *
 *               AT:yonas.live@yahoo.co.uk                       *
 *                  yonas.secured@gmail.com                      *
 *                                                               * 
 *  HARAMAYA UNIVERSITY DEPARTMENT OF COMPUTER SCIENCE &IT       *
 *					    	                                     *									 
 *					                                             *
 *                                                               *                                  
 *			SUBMITTED TO SISAY ADUGNA(FEBRUARY 19,2007)          *                                   *
 *                                                               *
 *                  										     * 
 *****************************************************************/  
import java.sql.*;// for SQL related 
import java.awt.*;  
import java.awt.event.*;    
import javax.swing.*; 
import javax.swing.border.*; 
public class Screengui extends JFrame implements ActionListener
{
  		Color skyblue = new Color(120,190,180); // preferred GUI color
  		//declare file area components
  		JTextArea outputArea = new JTextArea(33,33);
		//  outputArea.setResizable(true);
  		JScrollPane sourcePane = new JScrollPane(outputArea);
  		JPanel sPanel = new JPanel();
  
  		JPanel fileZone = new JPanel(new GridLayout(1,2,1,2));//(rows,cols,hgap,verticalGap)
  //declare button components
 		JButton WButton = new JButton("Write today's ");
  		 
  		JButton RButton = new JButton("Review Diary"); 
       
  		JButton VButton = new JButton("REMEMBER SPECIFIC EVENt");
         
  		JButton FButton = new JButton("Forget Event");
         
  		JButton aboutButton = new JButton("About TZIZTA");
         
  		JButton exitButton = new JButton("CLOSE TIZITA"); 
        
  		JPanel buttons = new JPanel(new GridLayout(6,1,2,2));
  //main is split into 2 grid regions
  		JPanel main = new JPanel(new BorderLayout());

  public Screengui() // the gui constructor and initializer
  { //start with framework
    super("PERSONAL Diary by Yig ,Ale ,Yo");
	setBounds(100,10,750,750); setResizable(false);  
	
	{
		///////AUTHENTICATE USER///////// 
		String pw,password="sisay";
		pw=JOptionPane.showInputDialog("Hello SISAY please enter your Entry code ","Are you SISAY");
		
		if(!(pw.equals(password)))
		{JOptionPane.showMessageDialog(null," I think you are not Siasay:\nThis is to secure your Diary\nPlease Restart the program","password inconsistency",JOptionPane.WARNING_MESSAGE);
		System.exit(0);
		}
		///////////////////////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	    /////////////////////////////////
		
	  }	 
	setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    //construct files/io zone
    outputArea.setBackground(Color.white);
    String s="\n\t=======================================\n\t";
    outputArea.setFont(new Font("Arial",Font.BOLD|Font.ITALIC,16));
    outputArea.setText("\n\tWelcome to TIZITA PERSONAL DIARY\n"+s+"Use controls in the right box according to your options.");
    sPanel.add(sourcePane); sPanel.setBackground(skyblue);
    sPanel.setBorder(new TitledBorder("Query Result")); 
    fileZone.add(sPanel);
    //****************************************
    	fileZone.setBackground(skyblue); 
    	fileZone.setBorder(new TitledBorder("Diary"));
    //construct controls zone
    buttons.add(WButton);           buttons.add(RButton);
    buttons.add(VButton);           buttons.add(FButton);
    buttons.add(aboutButton);       buttons.add(exitButton);
    buttons.setBackground(skyblue);
   
   //***adding tooltips***
    	WButton.setToolTipText ("Click here to write to Diary");
    	RButton .setToolTipText("Click here to review past history"); 
    	VButton.setToolTipText("Click here Read of specific Date");
    	FButton.setToolTipText("Click here to Erase History of specific Date");
    	aboutButton.setToolTipText("Click here to About project"); 
    	exitButton .setToolTipText("Closes the Software"); 
    
    //appendfromdbase
  //  while(rs.next()){outputArea.append(rs.getString(1)+""+rs.getString(2)+""+rs.getString(3)+"\n");}
    
    
    
    
    buttons.setBorder(new TitledBorder(" Options"));
    //complete the panel assembly
    main.add("Center",fileZone); main.add("East",buttons);
    //add The panel containing others to this 
    this.getContentPane().add("Center",main); setVisible(true);
    //add the listeners
    WButton.addActionListener(this);
    RButton.addActionListener(this); VButton.addActionListener(this);
    FButton.addActionListener( this); aboutButton.addActionListener(this);
    exitButton.addActionListener(this); 
  }
  	 
  	 
//*********************************THE METHODS DOING REAL WORK**********************************/
  			public void actionPerformed(ActionEvent event) // action event handler
  				{
   				 Object source = event.getSource();    
    				if (source == WButton)
     					 {
 //////////////////////////////////////////////HANDLE WRITE TO dBASE////////////////////////////
     					 	
	     			
	                 
	                   
	                   try{	 	  
   			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			String connURL="jdbc:odbc:;DRIVER=Microsoft Access Driver (*.mdb);DBQ=diary.mdb;PWD=";
			String login="sisay"; //if you don't have login name and password for the database, empty string ("") works 
			String password="sisay"; 
			Connection conn =DriverManager.getConnection(connURL,login,password);
			Statement command = conn.createStatement();
				String Etime=JOptionPane.showInputDialog("Enter Event identifier e.g. Aproximate Time","");
				String Edate=JOptionPane.showInputDialog("Enter Date please input as 21-01-07","00-00-00");
			    String Eevent=JOptionPane.showInputDialog("Enter Event","Nothing New Happnened");
			    if(Edate.equals("00-00-00")||Edate.equals(""))
			        {
			    	JOptionPane.showMessageDialog(null,"You had To Enter Date\nPlease try again","DATE REQUIRED",JOptionPane.ERROR_MESSAGE);
			    	}
			   else
			       { command.execute("insert into diarytable values('" + Etime + "','" + Edate +"','" + Eevent+"')");
			    JOptionPane.showMessageDialog(null,"Record Inserted","Insert",JOptionPane.WARNING_MESSAGE);
			    	command.close();
	             	conn.close();
	               }
	 	
   				}catch(Exception e){   JOptionPane.showMessageDialog(null,"YIRROR WOCCURED","Insert",JOptionPane.WARNING_MESSAGE);;}	  
   					  ///////////////////////////////
   		 			  sPanel.setVisible(false);} 
    				 
	  				
   					
   					  //////////////////////////// // 
////////////////////////////////REVIEW  DATABASE////////////////////////////////////////////////// 
   		    if (source == RButton)
   					  {outputArea.setVisible(true); 
   					  outputArea.setText("");  
   			try{		  
   			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			String connURL="jdbc:odbc:;DRIVER=Microsoft Access Driver (*.mdb);DBQ=diary.mdb;PWD=";
			String login="sisay"; //if you don't have login name and password for the database, empty string ("") works 
			String password="sisay"; 
			Connection conn =DriverManager.getConnection(connURL,login,password);
			Statement command = conn.createStatement();
			 	//Font BI=new Font("serif",Font.BOLD|Font.ITALIC,24); 
			   	Font OI=new Font("courier",Font.ITALIC,16); 
			   	 
			   	ResultSet rs1; 
			    command.execute("select * FROM diarytable ");
			    	 rs1=command.getResultSet();
			    	 String a="\n______________________________\n";
			    	  while(rs1.next())
			    	  {
			     	   
			    	  	//outputArea.append(rs1.getString(1));+"\t"+rs1.getString(2)+a+"\t"+rs1.getString(3)+"\n");
	                   	outputArea.setFont(OI);
	                     outputArea.append(" "+rs1.getString(1));
			    	  //	outputArea.setFont(BI);
			    	  	outputArea.append("\t"+rs1.getString(2)+"\n\t"+rs1.getString(3)+a+"\n");
			    	  	
			    	  	}
       
			    	command.close();
	             	conn.close();
	 	
   				}catch(Exception e){   JOptionPane.showMessageDialog(null,"ERROR OCCURED"+e,"Insert",JOptionPane.WARNING_MESSAGE);;}	  
   					  ///////////////////////////////
   		 			  sPanel.setVisible(true);}    
   		 			  
   		 			   
   		 			   
  /***************************SELECT SPECIFIC DATE**********************************/  
  		if (source == VButton) 
      				
    		{	outputArea.setText("");     
   					  //////////////////////////// // 
   			  		  //////////////SELECT SPECIFIC FROM  DATABASE//////////////// 
   			try{		  
   			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			String connURL="jdbc:odbc:;DRIVER=Microsoft Access Driver (*.mdb);DBQ=diary.mdb;PWD=";
			String login="sisay"; //if you don't have login name and password for the database, empty string ("") works 
			String password="sisay"; 
			Connection conn =DriverManager.getConnection(connURL,login,password);
			Statement command = conn.createStatement();
			 //	Font BI=new Font("serif",Font.BOLD|Font.ITALIC,24); 
			   	Font OI=new Font("courier",Font.ITALIC,16); 
			   	String Ekey=JOptionPane.showInputDialog("Enter DATE:");
			   	ResultSet rs1; 
			    command.execute("select * FROM diarytable where Date='"+Ekey+"'" );
			    	 rs1=command.getResultSet();
			    	 String a="\n______________________________\n";
			    	  while(rs1.next())
			    	  {
			     	   
			    	  	//outputArea.append(rs1.getString(1));+"\t"+rs1.getString(2)+a+"\t"+rs1.getString(3)+"\n");
	                   	outputArea.setFont(OI);
	                     outputArea.append(" "+rs1.getString(1));
			    	  //	outputArea.setFont(BI);
			    	  	outputArea.append("\t"+rs1.getString(2)+"\n\t"+rs1.getString(3)+a+"\n");
			    	  	
			    	  	}
       
			    	command.close();
	             	conn.close();
	 	
   				}catch(Exception e){   JOptionPane.showMessageDialog(null,"YIRROR WOCCURED"+e,"Insert",JOptionPane.WARNING_MESSAGE);;}	  
   					  ///////////////////////////////
   		 			  sPanel.setVisible(true);		}		   
    				   
    				///////////////////////////////
  /**************************DEletion AREA**********************************/  				
    				
    				////////////////////delete from database///////////
    				if (source == FButton)  
      				{    
      						try{		  
   			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
			String connURL="jdbc:odbc:;DRIVER=Microsoft Access Driver (*.mdb);DBQ=diary.mdb;PWD=";
			String login="sisay"; //if you don't have login name and password for the database, empty string ("") works 
			String password="sisay"; 
			Connection conn =DriverManager.getConnection(connURL,login,password);
			Statement command = conn.createStatement();
				String ekey=JOptionPane.showInputDialog("Enter Date where event occured:","00-00-00");
				if(ekey.equals("00-00-00")||ekey.equals(""))
				
					//	ekey holds EventKey in Dbase
				{JOptionPane.showMessageDialog(null,"You had To Enter Date\nPlease try again","DATE REQUIRED",JOptionPane.ERROR_MESSAGE);}
		
	else{
		  command.execute("DELETE FROM diarytable where Date='"+ekey+"'");
		  //command.execute("delete from diarytable where Etime="+ekey);
			    JOptionPane.showMessageDialog(null,"RECORD DELETED SUCCESSFULLY","Forget Event",JOptionPane.INFORMATION_MESSAGE);
			   	outputArea.setText("");   
			    	command.close();
	            	conn.close();}
		
   				}catch(Exception e){   JOptionPane.showMessageDialog(null,"ERROR OCCURED"+e,"Insert",JOptionPane.WARNING_MESSAGE);;}	  
   				
   					  ///////////////////////////////
   				
      					
      				 	 
      					
      					//////////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@//////////
      					JOptionPane.showMessageDialog(null,
      			  		"Contatct YIgaleyo", 
       					 "Message Dialog",JOptionPane.PLAIN_MESSAGE);}
    				if (source == aboutButton)
       						 {JOptionPane.showMessageDialog(null,
       						 "TIZITA Diary version 0.1\nSUBMITTED TO SISAY ADUGNA:::\nAuthors:Yig Ale YO\nyonas.secured@gmail.com",
       		 		 		 "About the Proect",JOptionPane.INFORMATION_MESSAGE);}
    				if (source == exitButton)  
           
    	 			 			{
    	 			 				sPanel.setVisible(false);
    	 			 				JOptionPane.showMessageDialog(null,"THANK YOU FOR TESTING OUR PROJECT","HAVE A NICE DAY,ciao",JOptionPane.INFORMATION_MESSAGE);
    	 			 				System.exit(0);}
  }

  		public static void main(String[] args)
  		{
  			try {new Screengui();}
  			catch (Exception e) 
  			
  			{;JOptionPane.showMessageDialog(null,"We ask your apology Some ERROR OCCURED \nERROR: "+e,"ERROR",JOptionPane.ERROR_MESSAGE);} 
   		}
}   		
   		
   		
   		
   	