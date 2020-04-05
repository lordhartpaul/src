import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.applet.*;
import java.util.Calendar;
/*<applet code="DigitalClock" height=210 width=400>
</applet>*/
public class DigitalClock extends JApplet implements Runnable,ActionListener
{
	public static Font f,f1;
	public Calendar time;
	public static String msg,msg2;
	public Thread t;
	public static Color c,c1,c2;
	public static int pee=0;
	public int k;
	public Container con;
	public JMenuItem prop,about;
	public JPopupMenu popup;
	public Properties p;
	public static String timefont="Monotype Corsiva",size="28";
	public String[] months={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
	public String[] weekday={"","SUN","MON","TUE","WEN","THU","FRI","SAT"};
	public void init()
	{
		con=getContentPane();
		setLayout(null);
		c1=new Color(0,0,255);
		c2=Color.magenta;
		prop=new JMenuItem("Properties");
		about=new JMenuItem("About");
		popup=new JPopupMenu();
		f=new Font("Monotype Corsiva",Font.BOLD,28);
		time=Calendar.getInstance();
		k=time.get(Calendar.AM_PM);
		if(k==0)
		msg=time.get(Calendar.HOUR)+":"+time.get(Calendar.MINUTE)+":"+time.get(Calendar.SECOND)+":"+time.get(Calendar.MILLISECOND)/100+" AM";
		else
		msg=time.get(Calendar.HOUR)+":"+time.get(Calendar.MINUTE)+":"+time.get(Calendar.SECOND)+":"+time.get(Calendar.MILLISECOND)/100+" PM";
		con.setBackground(Color.white);
		popup.addSeparator();
		popup.add(prop);
		popup.addSeparator();
		popup.add(about);
		popup.addSeparator();
		prop.addActionListener(this);
		about.addActionListener(this);
		addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent me){if(me.isPopupTrigger())
					{popup.show(me.getComponent(),me.getX(),me.getY());}}
				public void mouseReleased(MouseEvent me){if(me.isPopupTrigger())
					{popup.show(me.getComponent(),me.getX(),me.getY());}}});
		con.setVisible(true);
		msg2=weekday[time.get(Calendar.DAY_OF_WEEK)]+","+months[time.get(Calendar.MONTH)]+" "+time.get(Calendar.DATE)+","+time.get(Calendar.YEAR);
		t=new Thread(this);
		t.start();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==about)
		{
			JOptionPane.showMessageDialog(null,"<html>            <u><b>DigitalClock</b></u></html>\n<html>Version : <i>1.0</i></html>\n<html>created by : <i>Joe Oommen</i></html>","DigitalClock",JOptionPane.INFORMATION_MESSAGE);
		}
		if(ae.getSource()==prop)
		{
			pee=1;
			p=new Properties();
		}
	}
	public void run()
	{
		do{
		msg2=weekday[time.get(Calendar.DAY_OF_WEEK)]+","+months[time.get(Calendar.MONTH)]+" "+time.get(Calendar.DATE)+","+time.get(Calendar.YEAR);
		f=new Font(timefont,Font.BOLD,Integer.parseInt(size));
		if(pee==1)
			prop.setEnabled(false);
		else
			prop.setEnabled(true);
		try{
			Thread.sleep(100);
		}catch(InterruptedException ie){}
		time=Calendar.getInstance();
		k=time.get(Calendar.AM_PM);
		if(k==0)
		msg=time.get(Calendar.HOUR)+":"+time.get(Calendar.MINUTE)+":"+time.get(Calendar.SECOND)+":"+time.get(Calendar.MILLISECOND)/100+" AM";
		else
		msg=time.get(Calendar.HOUR)+":"+time.get(Calendar.MINUTE)+":"+time.get(Calendar.SECOND)+":"+time.get(Calendar.MILLISECOND)/100+" PM";
		repaint();
		}while(true);
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.fillRect(0,0,400,210);
		g.setColor(Color.black);
		g.fillRoundRect(85,40,218,70,30,30);
		g.setColor(c1);
		g.fillRoundRect(90,45,210,60,30,30);
		g.setColor(Color.red);
		g.drawString("Digital Clock",160,20);
		g.setColor(c2);
		g.setFont(f);
		g.drawString(msg,100,80);
		c=new Color(121,121,0);
		g.setColor(c);
		f1=new Font("Monotype Corsiva",Font.ITALIC|Font.BOLD,18);
		g.setFont(f1);
		g.drawString("Version 1.0",200,150);
	}
	class Properties extends JFrame implements ActionListener,ItemListener,Runnable
	{
		Container con1;
		JLabel l5,l3,l4,l6;
		JButton fg,bg;
		JComboBox fnt,sizing;
		Color fgcolor=Color.magenta,bgcolor=Color.blue;
		JColorChooser ch;
		JDialog dialog;
		Thread t1;
		String[] sizes={"8","10","12","14","16","18","20","22","24","26","28","30","32"};
		public Properties()
		{
			GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
			String Fontlist[]=ge.getAvailableFontFamilyNames();
			con1=getContentPane();
			con1.setLayout(new GridLayout(4,2));
			l5=new JLabel("Foreground Colour:");
			l3=new JLabel("Background Colour:");
			fg=new JButton("FontColor");
			bg=new JButton("Background");
			l4=new JLabel("Font:");
			fnt=new JComboBox(Fontlist);
			l6=new JLabel("Font Size:");
			sizing=new JComboBox(sizes);
			fnt.setSelectedItem(timefont);
			sizing.setSelectedItem(size);
			con1.add(l3);
			con1.add(bg);
			con1.add(l5);
			con1.add(fg);
			con1.add(l4);
			con1.add(fnt);
			con1.add(l6);
			con1.add(sizing);
			setVisible(true);
			setTitle("Properties");
			setSize(300,150);
			setResizable(false);
			t1=new Thread(this);
			fg.addActionListener(this);
			bg.addActionListener(this);
			l3.setToolTipText(msg2);
			l4.setToolTipText(msg2);
			l5.setToolTipText(msg2);
			l6.setToolTipText(msg2);
			addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent we){t1.stop();pee=0;}});
			t1.start();
		} 
		public void actionPerformed(ActionEvent ae)
		{
			JButton b=(JButton)ae.getSource();	
			if(b==fg)
			{	
				t1.stop();
				c2=JColorChooser.showDialog(null,"Font Color",c2);
				t1=new Thread(this);
				t1.start();
			}
			if(b==bg)
			{	
				t1.stop();
				c1=JColorChooser.showDialog(null,"Font Color",c1);
				t1=new Thread(this);
				t1.start();
			}
		}
		public void run()
		{
			do{
				timefont=(String)fnt.getSelectedItem();
				size=(String)sizing.getSelectedItem();
			}while(true);	
		}
		public void itemStateChanged(ItemEvent ie)
		{
			
		}
	}
}