import java.awt.*;
import java.applet.*;
import java.awt.event.*;
//Conversion of Decimal values to Hex, Octal and Binary

public class Proj3_3 extends Applet implements ActionListener
{
	Label prompt1;
	TextField input1;
	int number;
	String hexstring, octstring, binstring;
	
	public void init()
	{
		prompt1 = new Label("Enter an interger then press enter: ");
		add(prompt1);
		
		input1 = new TextField(10);
		input1.addActionListener(this);
		add(input1);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		number = Integer.parseInt(input1.getText());
		hexstring = Integer.toHexString(number).toUpperCase();
		octstring = Integer.toOctalString(number);
		binstring = Integer.toBinaryString(number);
		repaint();
	}
	
	public void paint (Graphics g)
	{
		g.drawString("The hexadecimal equivalent of the number you entered is: " + hexstring , 20 , 100);
		g.drawString("The octal equivalent of the number you entered is: " + octstring, 20, 120);
		g.drawString("The binary equivalent of the number you entered is: " + binstring, 20, 140);
	}
}


