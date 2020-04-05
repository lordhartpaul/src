import java.awt.*;
import java.applet.*;
import java.lang.String;

public class NokiaPhone extends Applet{

	Color PhoneInter=new Color(199,200,204);
	Color whiter=new Color(241,200,204);
	Color myGray=new Color(69,72,77);
	Color myLightgray=new Color(121,126,129);
	Color myLightergray=new Color(196,190,196);
	//Color gr128=new Color(128,128,128); 
		
	 public void init()  //Initialize
  	 { 
	  Color Bgcolor=new Color(154,135,247);
          setBackground(Bgcolor);  //Make window background black
          setSize(500,500);            //Set window size  
     	}

	public void phoneBody( Graphics g){

		g.setColor(PhoneInter);
		g.fillRoundRect(360, 100, 190, 450, 45, 45);

		// draw imbose outline the phone
		int RGBcolor =230;
			for(int i = 0; i<7; i++){
			RGBcolor -=25;		 
			g.setColor(new Color(RGBcolor, RGBcolor, RGBcolor));
			g.drawRoundRect(360 -i, 100 -i, 190 +2*i, 450+2*i, 45, 45);
		} 

		//outline of sceen
		RGBcolor =215;
		for(int i= 0; i<3; i++){
			RGBcolor -=35;
			g.setColor(new Color(RGBcolor, RGBcolor, RGBcolor));
			g.drawRoundRect(370-i, 110-i, 170+2*i, 304+2*i, 40, 40);
		}
		g.setColor(new Color(51,51,51));
		g.fillRoundRect(370+2, 110+2 , 170-4, 304-4, 40, 40);
		g.setColor(new Color(102,102,102));
		g.drawRoundRect(370-1, 430-1, 170+2 ,100+2, 40, 40);
		g.setColor(new Color(102,102,102));
		g.drawRoundRect(370+3, 430+3, 170-6, 100-6, 40, 40); 
	}
	public void phoneButton(Graphics g)
	{

		// the outline	
		g.setColor(Color.black);
		g.drawRoundRect(370, 430, 170,100, 40, 40);
       	  for(int j =0; j<3; j++)
		{ int x = 0;
		switch(j){
			case 0:
			{g.setColor(new Color(153,153,153)); x =-1;
			break;
			}
			case 1:
			{g.setColor(new Color(153,153,153)); x =1;
			break;
			}
			case 2:
			{g.setColor(Color.black); x =0;
			break;
			}
			}
		//the horizontal line
		g.drawLine(426 +x, 430 , 426 +x, 530 );
		g.drawLine(426 +55 +x, 430 , 426+55 +x, 530 );
		
		//the vertical line
		int x1 =370 , y1 =430+25; int x2 = x1+170, y2 =y1;
			for(int i= 1; i< 4; i++){
			g.drawLine(x1 , y1 +x, x2 , y2 +x);
			y1 += 25;
			y2 =y1;
		}
	    }	
		
		//Number on Key
		Font num=new Font("Arial",Font.BOLD,15);
		g.setFont(num);
		g.setColor(Color.BLACK);
		int x =0; int y =0;int m = 0;
		char[] number = {'1','2','3','4','5','6','7','8','9','*','0','#'};
		for(int i = 0;i<12; i++){  m += 1;
			g.drawChars(number,i,1,370+27 +x, 447 +y);
			x += 55; 
			if (m%3 ==0){x =0;y +=25;}
	
		}
		g.setColor(Color.white);
		g.drawString("NOKIA" ,426+6,110+35);
	  }
	
	public void phoneInterface(Graphics g){
		g.setColor(new Color(139,139,51));
		g.fillRect(370+10, 110 + 40,150,190);
		
		g.fillRoundRect(426,110+10, 55, 7 ,4, 4 );
/*.........................Animantion............................................*/
		int R = 20, G= 65, B= 205;
		for(int i=0; i<190; i++){
			R +=0.3; G +=1.5; B -=1; 
			g.setColor(new Color(R, G, B));
			g.drawLine(380 , 150+i, 380 +150/2, 150+ 190/2);
			g.drawLine(380 +150/2, 150+ 190/2,150+380,190+150 -i);
			for(int j=0;j<=12000000;j++);
			repaint();
		}
			
		R = 20; G= 5; B= 205;
		for(int i=0; i<150; i++){
			R +=1; G +=1.8; B -=1; 
			g.setColor(new Color(R, G, B));
			g.drawLine(380+i , 150, 380 +150/2, 150+ 190/2);
			g.drawLine(380 +150/2, 150+ 190/2,150+380-i,190+150);
			for(int j=0;j<=12000000;j++);
			repaint();
		}
/*.................................................................................*/
	}
	public void buttomCall(Graphics g){
		g.setColor(Color.red);
		int x=426;int y=350;
		g.drawRoundRect(x, y,55,55, 30, 30);
		int x1 =0; int y1 =0;
	  for(int i =0; i<4; i++){
		g.setColor(myLightgray);
		 x=382; y=350;
		g.drawRoundRect(x+x1, y+y1, 24,12, 10, 10);
		g.setColor(Color.black);
		x=383; y=351;
		g.fillRoundRect(x+x1, y+y1,23,11, 10, 10);
		changeColor(g, i);
		x=387; y=355;
		g.fillRoundRect(x+x1, y+y1,15,3, 5, 5);
			if(i%2<=0) y1 += 40;
			else
				{x1 +=95+24;y1 =0;}
	  }
		
	}
	public void paint (Graphics g)
	{	
		phoneBody(g);
		
		phoneButton(g);
		buttomCall(g);
		phoneInterface(g);
	}
	public void changeColor(Graphics g, int i){
		if (i == 0 || i==2) g.setColor(new Color(0,255,255));
		if (i == 1) g.setColor(new Color(0,255,0));
		if (i == 3) g.setColor(new Color(230,103,68));
		
	}
	
}