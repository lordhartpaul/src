import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.text.*;
public class moneymanager extends Applet{

	public static void mangerframe() {
	JFrame.setDefaultLookAndFeelDecorated(true);
	JFrame frame = new JFrame("Money Manger");

        Container content = frame.getContentPane();
	SpringLayout layout = new SpringLayout();
	content.setLayout(layout);
	

	JLabel bank = new JLabel("Money in Bank: $");
        content.add(bank);
	layout.putConstraint(SpringLayout.WEST, bank, 5, SpringLayout.WEST, content);
	layout.putConstraint(SpringLayout.NORTH, bank, 10, SpringLayout.NORTH, content);

	final JTextField banktxt = new JTextField("", 8);
	content.add(banktxt);
	layout.putConstraint(SpringLayout.WEST, banktxt, 7, SpringLayout.EAST, bank);
	layout.putConstraint(SpringLayout.NORTH, banktxt, 10, SpringLayout.NORTH, content);
     
	JLabel pay = new JLabel("Monthly pay: $");
	content.add(pay);
	layout.putConstraint(SpringLayout.WEST, pay, 5, SpringLayout.WEST, content);
	layout.putConstraint(SpringLayout.NORTH, pay, 10, SpringLayout.SOUTH, bank);

	final JTextField paytxt = new JTextField("", 8);
	content.add(paytxt);
	layout.putConstraint(SpringLayout.WEST, paytxt, 22, SpringLayout.EAST, pay);
	layout.putConstraint(SpringLayout.NORTH, paytxt, 5, SpringLayout.SOUTH, banktxt);

	JLabel car = new JLabel("Car Payments: $");
	content.add(car);
 	layout.putConstraint(SpringLayout.WEST, car, 5, SpringLayout.WEST, content);
	layout.putConstraint(SpringLayout.NORTH, car, 15, SpringLayout.SOUTH, pay);
	
	final JTextField cartxt = new JTextField("", 8);
	content.add(cartxt);
 	layout.putConstraint(SpringLayout.WEST, cartxt, 9, SpringLayout.EAST, car);
	layout.putConstraint(SpringLayout.NORTH, cartxt, 10, SpringLayout.SOUTH, paytxt);

	JLabel credit = new JLabel("Credit Card: $");
	content.add(credit);
 	layout.putConstraint(SpringLayout.WEST, credit, 5, SpringLayout.WEST, content);
	layout.putConstraint(SpringLayout.NORTH, credit, 13, SpringLayout.SOUTH, car);

	final JTextField credittxt = new JTextField("", 8);
	content.add(credittxt);
 	layout.putConstraint(SpringLayout.WEST, credittxt, 25, SpringLayout.EAST, credit);
	layout.putConstraint(SpringLayout.NORTH, credittxt, 10, SpringLayout.SOUTH, cartxt);

	JLabel util = new JLabel("Utilities: $");
	content.add(util);
 	layout.putConstraint(SpringLayout.WEST, util, 5, SpringLayout.WEST, content);
	layout.putConstraint(SpringLayout.NORTH, util, 14, SpringLayout.SOUTH, credit);

	final JTextField utiltxt = new JTextField("", 8);
	content.add(utiltxt);
 	layout.putConstraint(SpringLayout.WEST, utiltxt, 47, SpringLayout.EAST, util);
	layout.putConstraint(SpringLayout.NORTH, utiltxt, 10, SpringLayout.SOUTH, credittxt);

	JLabel other = new JLabel("Other Expense: $");
	content.add(other);
 	layout.putConstraint(SpringLayout.WEST, other, 5, SpringLayout.WEST, content);
	layout.putConstraint(SpringLayout.NORTH, other, 15, SpringLayout.SOUTH, util);

	final JTextField othertxt = new JTextField("", 8);
	content.add(othertxt);
 	layout.putConstraint(SpringLayout.WEST, othertxt, 5, SpringLayout.EAST, other);
	layout.putConstraint(SpringLayout.NORTH, othertxt, 10, SpringLayout.SOUTH, utiltxt);

	JLabel head = new JLabel("don't enter anything in this row, its calulated for you");
	content.add(head);
	layout.putConstraint(SpringLayout.WEST, head, 5, SpringLayout.EAST, banktxt);
	layout.putConstraint(SpringLayout.NORTH, head, 2, SpringLayout.NORTH, content);
	
	
	JLabel texpense = new JLabel("Total Expense:");
	content.add(texpense);
	layout.putConstraint(SpringLayout.WEST, texpense, 10, SpringLayout.EAST, banktxt);
	layout.putConstraint(SpringLayout.NORTH, texpense, 20, SpringLayout.NORTH, content);
	
	final JTextField texp = new JTextField("", 8);
	content.add(texp);
	layout.putConstraint(SpringLayout.WEST, texp, 5, SpringLayout.EAST, texpense);
	layout.putConstraint(SpringLayout.NORTH, texp, 20, SpringLayout.NORTH, content);

	JLabel save = new JLabel("Savings(10% of pay):");
	content.add(save);
	layout.putConstraint(SpringLayout.WEST, save, 10, SpringLayout.EAST, paytxt);
	layout.putConstraint(SpringLayout.NORTH, save, 5, SpringLayout.SOUTH, texpense);

	final JTextField savetxt = new JTextField("", 8);
	content.add(savetxt);
	layout.putConstraint(SpringLayout.WEST, savetxt, 5, SpringLayout.EAST, save);
	layout.putConstraint(SpringLayout.NORTH, savetxt, 5, SpringLayout.SOUTH, texp);

	JLabel saveyr = new JLabel("Saving for year:");
	content.add(saveyr);
	layout.putConstraint(SpringLayout.WEST, saveyr, 5, SpringLayout.EAST, cartxt);
	layout.putConstraint(SpringLayout.NORTH, saveyr, 15, SpringLayout.SOUTH, save);

	final JTextField syrtxt = new JTextField("", 8);
	content.add(syrtxt);
	layout.putConstraint(SpringLayout.WEST, syrtxt, 5, SpringLayout.EAST, saveyr);
	layout.putConstraint(SpringLayout.NORTH, syrtxt, 5, SpringLayout.SOUTH, savetxt);

	JLabel income = new JLabel("Income left over:");
	content.add(income);
	layout.putConstraint(SpringLayout.WEST, income, 5, SpringLayout.EAST, credittxt);
	layout.putConstraint(SpringLayout.NORTH, income, 5, SpringLayout.SOUTH, saveyr);
	
	final JTextField incometxt = new JTextField("",8);
	content.add(incometxt);	
	layout.putConstraint(SpringLayout.WEST, incometxt, 5, SpringLayout.EAST, income);
	layout.putConstraint(SpringLayout.NORTH, incometxt, 5, SpringLayout.SOUTH, syrtxt);
	
	JLabel banktotal = new JLabel("Total in the Bank:");
	content.add(banktotal);
	layout.putConstraint(SpringLayout.WEST, banktotal, 5, SpringLayout.EAST, utiltxt);
	layout.putConstraint(SpringLayout.NORTH, banktotal, 5, SpringLayout.SOUTH, income);

	final JTextField totaltxt = new JTextField("",8);
	content.add(totaltxt);
	layout.putConstraint(SpringLayout.WEST, totaltxt, 5, SpringLayout.EAST, banktotal);
	layout.putConstraint(SpringLayout.NORTH, totaltxt, 5, SpringLayout.SOUTH, incometxt); 

	JButton enter = new JButton("Enter");
	content.add(enter);
	layout.putConstraint(SpringLayout.WEST, enter, 15, SpringLayout.WEST, content);
	layout.putConstraint(SpringLayout.NORTH, enter, 5, SpringLayout.SOUTH, othertxt);	
	
	

	enter.addActionListener(new ActionListener(){ 
	public void actionPerformed(ActionEvent ae) {
	String str=ae.getActionCommand();
	if (str.equals("Enter"));
	{

	NumberFormat cash = NumberFormat.getCurrencyInstance();
	String s1, s2, s3, s4, s5, s6;
	double a,  c , d , e ,f;
	double a1,  a4, a5;
	double a2, b, a3;	
	s1=banktxt.getText();
a=Double.parseDouble(s1);	
	s2=paytxt.getText();
b=Double.parseDouble(s2);
	s3=cartxt.getText();
c=Double.parseDouble(s3);
	s4=credittxt.getText();
d=Double.parseDouble(s4);
	s5=utiltxt.getText();
e=Double.parseDouble(s5);
	s6=othertxt.getText();
f=Double.parseDouble(s6);
	a1 = c + d+ e+ f;
	String b5 = String.valueOf(cash.format(a1));
	texp.setText(b5);
	a2 = b * .1;
String b1 = String.valueOf(cash.format(a2));
	savetxt.setText(b1);
	a3 = a2 * 12;
	String b2 = String.valueOf(cash.format(a3));
	syrtxt.setText(b2);
	a4 = b - a1 - a2;
	String b3 = String.valueOf(cash.format(a4));
	incometxt.setText(b3);
	a5 = a + a4;
	String b4 = String.valueOf(cash.format(a5));
	totaltxt.setText(b4);
	
	
	
	}
	} 
        });

	frame.pack();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(450, 250);
	frame.setVisible(true);
	}
	public static void main(String[] args) {


	javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run() {
			mangerframe();
		}
});
}

 }




