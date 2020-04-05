import java.awt.*;
import java.awt.event.*;

public class Sleep extends Frame{
Label lb,lb2;

	public void sleep1() throws InterruptedException{
	lb=new Label("Loading");
	lb2=new Label(".");
	setVisible(true);
	setSize(400,400);
	setLayout(null);
	String a=".";
	String s;
	lb.setBounds(40,100,600,30);
	add(lb);
	//add(lb2);
	//	int a=40;
	for(int i=1;i<11;i++){
		
	//	a=a+20;
	//	lb2.setBounds(a,600,50,30);
		lb.repaint();
		s=lb.getText()+a;
		lb.setText(s);
		Thread.sleep(1000);	
			
	}
	
	System.exit(0);

	}
	public static void main(String args[]) throws InterruptedException{
	
		Sleep s=new Sleep();
		s.sleep1();
	}
	
}