import  java.awt.*;
import java.applet.Applet;

public class AnimatedImages extends Applet implements Runnable
{
	MediaTracker mt = null;
	Image img[] = new Image[3];
	int index;
	Thread animate = null;

	public void init()
	{
		mt = new MediaTracker( this );
		img[0] = getImage( getCodeBase(), "1.jpg");
		img[1] = getImage( getCodeBase(), "2.jpg");
		img[2] = getImage( getCodeBase(), "3.jpg");

	}

	public void start()
	{
		if ( animate == null)
		{
			animate = new Thread(this);
			animate.start();
		}
	}

	public void stop()
	{
		if(animate != null)
		{
			animate.stop();
			animate = null;
		}
	}

	public void run()
	{
		for ( ; ; )
		{
			repaint();
			if (index < 2)
				index++;
			else
				index = 0;
			try
			{
				animate.sleep(1000);
			}
			catch( Exception ex) { }
		}
	}

	public void paint( Graphics g)
	{
		if( mt.checkID(0,true))
			g.drawImage( img[index], 10,10, 500, 400 , this);
	}

}