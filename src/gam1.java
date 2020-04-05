import java.awt.*;
import java.applet.Applet;

public class gam1 extends Applet implements Runnable{
int i,j,t,ti=0;
Image la;Label lab;
Thread wheelthread;
Button suspend,resume;

public void init(){la=getImage(getCodeBase(),"BLAST.jpg");lab=new Label("Score: 0");add(lab);
}

public void start(){
		wheelthread=new Thread(this);
		wheelthread.start();
}

public void stop(){
			
	wheelthread.stop();
}

public void run(){
		while(true){
				i++;if(i>280){i=0;j=j+10;}
				if(j>300)j=0;
				repaint();
				try{Thread.sleep(5);}
				catch(InterruptedException e){}
	
			   }
		 }



public void paint(Graphics d)
{
		setBackground(new Color(0,100,100));
		d.setColor(new Color(0,0,150));
		d.fillRect(j,i,10,20);
		d.drawLine(0,300,400,300);
		
		if(t==2){d.drawImage(la,j,i,20,40,this);t=3;try{Thread.sleep(500);}
				catch(InterruptedException e){};i=0;j=j+10;}
		if(i==280){d.setColor(new Color(0,0,150));d.drawRect(j,270,j+10,270);}	
}

public boolean mouseDown(Event evt,int x,int y)
	{
		
		if(x>=j&&x<=j+10&&y>=i&&y<=i+20){
				t=2;
				System.out.println("Score: "+(ti++));	
				lab.setText("Score: "+(ti++));
			
		}


return true;
	}
}


/*
<applet code="gam1" width=400 height=400></applet>
*/
