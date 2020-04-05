/*
****************************************************************
****************************************************************
******* 						    *****
******* 	PROGRAMMER: SYED S. NIZAMUDEEN  	    *****
******* 	CONTACT NUMBER: +919994244805		    *****
******* 	E-MAIL ADDRESS: AMS_MAZIN@YAHOO.COM 	    *****
******* 	WEBSITE: HTTP://WWW.MCIN.WEBS.COM   	    *****
******* 						    *****
*******	FOR PROGRAMMING SOLUTIONS IN CORE JAVA 	    *****
*******	ANY COMMERCIAL APPLICATION DEVELOPMENT      *****
******* 	CONTACT ME 			            *****
*******                                                    *****
****************************************************************
****************************************************************
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class ExcelReading extends javax.swing.JFrame {


public static 	String excelQuery = "SELECT * FROM [Sheet1$]";
public static 	String ColumnHeaderName[] = {"BadgeNumber", "FirstName", "LastName"};
public 		JTable NewTable;
public static 	int rowNum = 0;
public static 	int total = 0;
public static 	String Content[][];
public static 	Connection conn = null;
public static 	Statement stmt = null;
public static 	ResultSet rs = null;


public ExcelReading() {


runApplication();
initComponents();  

}

public static Connection getConnection() throws Exception {

String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
String url = "jdbc:odbc:Excel Files";//data source name
String username = "Admin";
String password = "";
Class.forName(driver);
return DriverManager.getConnection(url, username, password);

}

public void runApplication(){

try {
total = 0;
conn = getConnection();
stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
rs = stmt.executeQuery(excelQuery);
rs.afterLast(); 
if(rs.previous())total = rs.getRow();
rs.beforeFirst();
Content = new String[total][4];	

while (rs.next()) {

String s1 = rs.getString("BadgeNumber"), s2 = rs.getString("FirstName"), s3 = rs.getString("LastName");
//System.out.println(s1 + "\t" + s2 + "\t"+ s3);
Content[rowNum][0] = s1;
Content[rowNum][1] = s2;
Content[rowNum][2] = s3;
rowNum++;

}

NewTable = new JTable (Content,ColumnHeaderName)
{
public boolean isCellEditable (int iRows, int iCols)
{return false;}
};  
} catch (Exception e) {
System.err.println(e.getMessage());
} finally {
try {
rs.close();
stmt.close();
conn.close();

} catch (SQLException e) {
e.printStackTrace();
}
}
}

private void initComponents() {

ExcelReaderTabbedPane = new JTabbedPane();
ExcelReaderPanel = new JPanel();
ExcelReaderScrollPane = new JScrollPane();
ExcelReaderTable = new JTable();
btnexit = new JButton();
btnrefresh = new JButton();
AboutPanel = new JPanel();
jLabel1 = new JLabel();
jLabel2 = new JLabel();
jLabel3 = new JLabel();
jLabel4 = new JLabel();
jLabel5 = new JLabel();
jLabel6 = new JLabel();
jLabel7 = new JLabel();
jLabel8 = new JLabel();
jLabel9 = new JLabel();

setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
setMinimumSize(new Dimension(400, 330));
setResizable(false);
setTitle("Excel Reader");
getContentPane().setLayout(null);

ExcelReaderPanel.setLayout(null);
ExcelReaderTable = NewTable;
ExcelReaderScrollPane.setViewportView(ExcelReaderTable);

ExcelReaderPanel.add(ExcelReaderScrollPane);
ExcelReaderScrollPane.setBounds(10, 10, 370, 180);

btnexit.setText("Exit");
btnexit.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
btnexitActionPerformed(evt);
}
});
ExcelReaderPanel.add(btnexit);
btnexit.setBounds(301, 230, 60, 23);

btnrefresh.setText("Refresh");
btnrefresh.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
btnrefreshActionPerformed(evt);
}
});
ExcelReaderPanel.add(btnrefresh);
btnrefresh.setBounds(223, 230, 80, 23);

ExcelReaderTabbedPane.addTab("Excel Sheet1", ExcelReaderPanel);

AboutPanel.setLayout(null);

jLabel1.setFont(new java.awt.Font("Calibri", 1, 14));  
jLabel1.setForeground(new java.awt.Color(0, 0, 204));
jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
jLabel1.setText("Programmer");
AboutPanel.add(jLabel1);
jLabel1.setBounds(10, 30, 80, 30);

jLabel2.setFont(new java.awt.Font("Calibri", 1, 14));  
jLabel2.setForeground(new java.awt.Color(0, 0, 204));
jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
jLabel2.setText("Contact No");
AboutPanel.add(jLabel2);
jLabel2.setBounds(10, 60, 80, 30);

jLabel3.setFont(new java.awt.Font("Calibri", 1, 14));  
jLabel3.setForeground(new java.awt.Color(0, 0, 204));
jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
jLabel3.setText("Email");
AboutPanel.add(jLabel3);
jLabel3.setBounds(10, 90, 80, 30);

jLabel4.setFont(new java.awt.Font("Calibri", 1, 14));  
jLabel4.setForeground(new java.awt.Color(0, 0, 204));
jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
jLabel4.setText("Website");
AboutPanel.add(jLabel4);
jLabel4.setBounds(10, 120, 80, 30);

jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));  
jLabel5.setForeground(new java.awt.Color(153, 153, 0));
jLabel5.setText("<html><body>For Programming Solutions in Core JAVA and any Commercial Application Development for Online and Offline Bussiness Contact ME. </body></html>");
AboutPanel.add(jLabel5);
jLabel5.setBounds(40, 180, 310, 80);

jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18));  
jLabel6.setForeground(new java.awt.Color(204, 0, 51));
jLabel6.setText("SYED S.NizaMudeen");
AboutPanel.add(jLabel6);
jLabel6.setBounds(100, 30, 300, 30);

jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18));  
jLabel7.setForeground(new java.awt.Color(204, 0, 51));
jLabel7.setText("+919994244805");
AboutPanel.add(jLabel7);
jLabel7.setBounds(100, 60, 300, 30);

jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18));  
jLabel8.setForeground(new java.awt.Color(204, 0, 51));
jLabel8.setText("ams_mazin@yahoo.com");
AboutPanel.add(jLabel8);
jLabel8.setBounds(100, 90, 300, 30);

jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18));  
jLabel9.setForeground(new java.awt.Color(204, 0, 51));
jLabel9.setText("http://www.mcin.webs.com/");
AboutPanel.add(jLabel9);
jLabel9.setBounds(100, 120, 300, 30);

ExcelReaderTabbedPane.addTab("About", AboutPanel);

getContentPane().add(ExcelReaderTabbedPane);
ExcelReaderTabbedPane.setBounds(0, 0, 390, 300);

pack();
}

private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {

System.exit(0);
}

private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {

}

public static void main(String args[]) {
java.awt.EventQueue.invokeLater(new Runnable() {
public void run() {
new ExcelReading().setVisible(true);
}
});
}


JPanel AboutPanel;
JPanel ExcelReaderPanel;
JScrollPane ExcelReaderScrollPane;
JTabbedPane ExcelReaderTabbedPane;
JTable ExcelReaderTable;
JButton btnexit;
JButton btnrefresh;
JLabel jLabel1;
JLabel jLabel2;
JLabel jLabel3;
JLabel jLabel4;
JLabel jLabel5;
JLabel jLabel6;
JLabel jLabel7;
JLabel jLabel8;
JLabel jLabel9;


}
