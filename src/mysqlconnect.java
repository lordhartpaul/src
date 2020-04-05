import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

/* Name: Simple mySQL Connection
 * Written by: Tony Porter
 * Date: Sept 15th 2006
 * 
 * Description of Mysql/J Connection:
 * No sissy "MDB" files and databases in the program . Real code, Real Database.
 * This little program shows you the basics of connecting to a mysql database. Also
 * shows you how to set your connections and make the calls to the jdbc:mysql class.
 * You should learn how to set arrays, call an array for data, get data from memory/textboxes,
 * setup your queries, calling other classes and functions 
 * and even setup a window using EXACT COORDINATES WITH YOUR COMPONENTS!
 * 
 * This is not a "Tech Headed" program so the first timers will for sure know how to do this and learn.
 * The logic of this java file is to teach you what does what, not how good it looks and how smooth
 * it looks.  If you want to learn how to progam, first thing to learn about coding is (GETTING IT TO WORK).
 * 
 */


class mysqlconnect {
/* The declaractions code below is not nessessarily the way to code but for new comers,
 * I have placed all of the main variables here so it can be called whenever you
 * need it.  If this were a real program, I would have placed the varibales when I
 * need them inside whatever class but hey new comers, you gotta start somewhere.
*/ 
	
	//SQL Method Contruct
	private static Connection cn;
	private static ResultSet rs;
	private static Statement st;
	
	//Lets hold some data into memory
	private static String logindata[] = new String[4];;
	
	//Login Window Construct
	public static TextField txtuser = new TextField();
	public static TextField txtpass = new TextField();
	public static TextField txturl = new TextField();
	public static TextField txtdb = new TextField();
	public static JFrame loginwin = new JFrame("Login");
	public static JLabel lblnote = new JLabel("Please enter your login");
	public static JLabel lblurlpath = new JLabel("Url:");
	public static JLabel lblusername = new JLabel("Username:");
	public static JLabel lblpassword = new JLabel("Password:");
	public static JLabel lbldatabase = new JLabel("Database:");
	public static JButton btnok = new JButton("ok");
	

	
public static void sqlconnection() throws Exception {
		//Setting "sql" as a String method
		String sql;	
		
		
		System.out.println("\n\n\n\n\n");
		System.out.print("Connecting Driver... ");
		
		//Lets call our connector/jdbc class driver
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		System.out.print("OK!\n");
		
		System.out.print("Connecting To Database... ");
		
		//Lets connect to our database(BE SURE YOU HAVE MADE UP YOUR DATABASE, GRANT PERMISSIONS, ETC.)
		cn = DriverManager.getConnection("jdbc:mysql://" + logindata[0] +"/" + logindata[1], logindata[2],logindata[3]);
		System.out.print("HECK YEAH!\n\n");
		
		System.out.print("Printing Query... \n");
		//Rember our String method? We have binded a select statement to the sql string method
		sql = ("SELECT * FROM product_inventory");
		
		//binded the statement method to our connection 
		st = cn.createStatement();
		
		//our resultset can now excute the "sql" statement and return it results
		rs = st.executeQuery(sql);
		
		
		try {
			System.out.println("----------------------------------------------------");
				
			//While ResultSet Is Running Through The Selected Database, Print out my stuff!
				while(rs.next()) {

					//Repalce rs.getString("DATA") with YOUR databases columns
					System.out.println("ID: " + rs.getString("id") + " " +
									   "Product: " + rs.getString("item_name") + " " +
									   "Desc: " + rs.getString("item_desc") + " " +
									   "Price: " + "$"+ rs.getString("item_price")+ " " +
									   "Qty: " + rs.getString("item_qty") );
				}
			
				System.out.println("----------------------------------------------------");
			//WE ARE DONE SO CLOSE UP!!!
			System.exit(0);
			
		}
		
		
		catch (SQLException sqle1) {
		// sqle1.printStackTrace(); <--- Use that if you want a long list of what went wrong.
		System.out.println("Record Error");	
		}
		//Close out of program because we got messed up.
		System.exit(0);
		
}


//This method is called when we click the "ok" button on the login screen
//AFTER WE HAVE ENTERED OUR DATA TO THE TEXTBOXES...
//Our actions, action is to do login stuff and our name of this method is called "login"
public static Action login = new AbstractAction("login")  {
	
	//Our action event will call the login method below
	public void actionPerformed(ActionEvent login) {
		
		System.out.println("Pulling Data Into Memory...");
		//Remeber the String logindata[]... well here we will start adding our textbox's data into memory
		//When calling the memory, 0 is really 1.  Ever seen an error before like "Error: 0-1"? 
		logindata[0] = txturl.getText();
		logindata[1] = txtdb.getText();
		logindata[2] = txtuser.getText();
		logindata[3] = txtpass.getText();
		
		//Just double checking our data is in memory..Oh yeah it stays in memory until the progam closes
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("DATA IN MEMORY:");
		System.out.println("Url: " + logindata[0] + "\n" + 
						   "Database: " + logindata[1] + "\n" + 
						   "User: " + logindata[2] + "\n" + 
						   "Password: " + logindata[3] + "\n\n");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		
			try {
				//Lets go ahead and connect this baby!
				sqlconnection();
				
			} 
			
			catch (Exception e) {	
				e.printStackTrace();
				System.exit(0);
			}
			
		
	}

};


//This is where the actual fun begins when you need to setup your GUI
//New Comers, now you are using real code so no more saying "Making Windows in my progam"...
//It's... making GUI (Graphical User Interface). Speak of that here's the code below that made
//up the login screen.  It's massivly ugly but if you want code that works then deal with it :-)


public static void loginWin() {
// BOUNDS - y,x,w,h <-- You'll see why I promise, just pay attention

	//Setting up our Panel to hold our components
	JPanel panel = new JPanel(null);
	
	lblurlpath.setBounds(0, 50, 200, 30); //Set up the url label bounds
	txturl.setBounds(70, 40, 200, 30); //Setup the urltextbox bounds
	panel.add(lblurlpath); //add the label to the panel
	panel.add(txturl); // add the textbox to the panel
	
	/* You know what the .add portion means now so I'm not wasting anymore on the rest */
	
	lblusername.setBounds(0, 75, 200, 30); //Set up the username label bounds
	txtuser.setBounds(70, 70, 200, 30); //Set up the username textbox bounds
	panel.add(lblusername);
	panel.add(txtuser);
	
	lblpassword.setBounds(0, 105, 200, 30); //Set up the password label bounds
	txtpass.setBounds(70, 100, 200, 30); //Set up the password textbox bounds
	panel.add(lblpassword);
	panel.add(txtpass);
	
	lbldatabase.setBounds(0, 135, 200, 30); //Set up the database label bounds
	txtdb.setBounds(70 ,130, 200, 30); //Set up the database textbox bounds
	panel.add(lbldatabase);
	panel.add(txtdb);
	
	btnok.setBounds(125, 170, 50, 30); //Set up the ok button bounds
	panel.add(btnok); // Add The ok Button to the panel
	
	btnok.addActionListener(login); // THIS IS HOW ACTIONS ARE CALLED/BINDED
	

	loginwin.getContentPane().add(panel); //Get the contents
	loginwin.setBounds(400, 250, 300, 250); // Setting the bounds, width and height for our login window
	loginwin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // If i click x, CLOSE don;t just sit there
	loginwin.show(); // show the window


}


// ALL JAVA APPS MUST HAVE THIS LINE BELOW IN ORDER TO RUN
public static void main(String[] args) throws Exception {
	
	//DELETE THIS TO PREVENT THAT MESSAGE BOX FROM COMING UP AGAIN
	JOptionPane.showMessageDialog(null,"You must have the mysql connector file for java apps installed.\n" +
										"Don't worry about calling the classpath mess, just add the jar\n" +
										"file into your java's /etc directory and you're all good to go.\n\n" +
										"This program was written in LINUX. Windows users, find the \nclass" +
										"file for running mysql connector/j progams and do like i\nsaid above " +
										"to properly use this progam.\n\n" +
										"This progam uses the 'com.mysql.jdbc.Driver'\n\n" +
										"Questions? Comments? Need custom code?\n" +
										"email: apdesignservices@yahoo.com");
	
	// calling the loginwin method
	loginWin();
	
}

}
