import java.awt.*;
import java.applet.*;
import java.awt.event.*;

//Conversion of Any Currency to dollars
//Check the Newspaper for today's money exchanges
public class Proj3_2 extends Applet implements ActionListener
{
	Float forgnCurr, xRate;
	float dollars;
	Label forgnAmt, forgnName, forgnRate;
	TextField txtFC, txtName, txtRate;
	
	public void init()
	{
		forgnAmt = new Label("Enter the amount of foreign currency you have: ");
		add(forgnAmt);
		
		txtFC = new TextField(10);
		add(txtFC);
		
		forgnName = new Label("Enter the name of the foreign currency: ");
		add(forgnName);
		
		txtName = new TextField(10);
		add(txtName);
		
		forgnRate = new Label("Enter today's exchange rate for this currency: ");
		add(forgnRate);
		
	txtRate = new TextField(10);
	txtRate.addActionListener(this);
		add(txtRate);
	}
	public void actionPerformed(ActionEvent e)
	{
forgnCurr = Float.valueOf(txtFC.getText());
txtName.getText();
xRate = Float.valueOf(txtRate.getText());
dollars = forgnCurr.floatValue() / xRate.floatValue();
repaint();
}
public void paint (Graphics g)
{
	g.drawString("This amount of " + txtName.getText() + " convers to " + dollars + " dollars.", 20, 150);
   }
}


