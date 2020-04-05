//created by pml in (5-3-2005)
//<Applet code=p012FilesThread width=640 height=480> </Applet>
import java.applet.*;
import java.awt.*;
import java.io.*;

public class p012FilesThread extends Applet
{
	TextArea ta;
	Label getLabel = new Label("Enter File Name:");
	TextField fname = new TextField(100);
	Button read = new Button("Read");
	Button clear = new Button("Clear");
	Button quit = new Button("Quit");
	readFile c;

	public void init()
	{
		setLayout(new BorderLayout());
		Panel p = new Panel();
		p.add(getLabel);
		p.add(fname);
		p.add(read);
		p.add(clear);
		p.add(quit);
		add("North", p);

		ta = new TextArea();
		p.add(ta);
		add("Center", p);

		resize(640, 480);
	}

	public void paint(Graphics g)
	{ }

	public boolean action(Event e, Object o)
	{
		if(e.target instanceof Button)
		{
			if(o=="Read")
			{
				if(fname.getText().length()==0)
				{
					ta.setText("Empty Textbox...");
					return true;
				}
				else
				{
					c = new readFile(fname.getText());
				}
			}
			else if(o=="Clear")
			{
				c.stop();
				ta.setText("");
			}
			else if(o=="Quit")
			{
				System.exit(0);
				destroy();
			}
		}
		return true;
	}

	protected class readFile implements Runnable
	{
		int i;
		FileInputStream fin;
		Thread t;
		String name;

		readFile(String fileName)
		{
			name = "Read: "+fileName;
			t = new Thread(this, name);
			t.start();
		}

		public void stop()
		{
			try
			{
				fin.close();
			}
			catch(Exception e) { }
			t.stop();
		}

		public void run()
		{
			try
			{
				
				ta.setText("");
				fin = new FileInputStream(fname.getText());
				do
				{
					i = fin.read();
					if(i != -1)
					{
						char chr = (char)(i);
						ta.appendText(""+chr);
					}
				} while(i != -1);
				fin.close();
			}
			catch(FileNotFoundException fnfe)
			{
				System.out.println("File Not Found...");
			}
			catch(IOException ioe)
			{
				System.out.println("An I/O Error Occured...");
			}
			catch(Exception e1)
			{
				System.exit(1);
			}
		}
	}

	public static void main(String args[])
	{
		Frame f = new Frame("File Demo using Threads");
		p012FilesThread f1 = new p012FilesThread();
		f1.init();
		f.add("Center", f1);
		f.pack();
		f.setSize(640, 480);
		f.show();
	}
}