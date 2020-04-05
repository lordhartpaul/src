import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ColorChanger{
	public static void main(String args[]){
		new MyClass();


		}
}
class MyClass extends JFrame{
	JSlider js1,js2,js3;
	JLabel jl;

	MyClass(){
		Container cp=getContentPane();
		cp.setLayout(new FlowLayout());
		js1=new JSlider(0,255);
		js2=new JSlider(0,255);
		js3=new JSlider(0,255);

		jl=new JLabel("Here Color Is Changing");

		setSize(300,300);
		setTitle("Colar Changer Module");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Action1 ac=new Action1(this);
		js1.addChangeListener(ac);
		js2.addChangeListener(ac);
		js3.addChangeListener(ac);
		cp.add(js1);
		cp.add(js2);
		cp.add(js3);
		cp.add(jl);

		setVisible(true);
		}
	}
	class Action1 implements ChangeListener{
		MyClass mc;
		Action1(MyClass m){mc=m;}
		public void stateChanged(ChangeEvent e){
			int i,j,k;
			i=mc.js1.getValue();
			j=mc.js2.getValue();
			k=mc.js3.getValue();

			Color obj=new Color(i,j,k);
			mc.jl.setForeground(obj);


			}
		}