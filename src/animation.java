import java.awt.*;
import java.applet.*;

public class animation extends Applet implements Runnable{
	static int Lx=0;
	static int Ly=0;
	static int pX=0;
	static int pY=0;
	static int line=1;
	static int Lwidth=80;
	static int Lheight=80;
	static int Swidth=80;
	static int Sheight=80;
	static int Sx=0;
	static int Sy=0;
	static int sleepfor=200;
	int temp=1;
	boolean states=false;
	boolean reverse=false;
	boolean up=false;
	Thread t;

	public void init(){
		//create animation thread and start it
		t=new Thread(this);
		t.start();
	}
	public void paint(Graphics g){
		int count=1;
		states=false;
		Lx=0;
		Ly=0;
	
		//draw the background
		while(count<=25){
			if(states==false){
				g.setColor(Color.WHITE);
			}
			else{
				g.setColor(Color.RED);
			}
			g.fillRect(Lx,Ly,Lwidth,Lheight);
			states=!states;
			Lx+=80;
			if(Lx>320){
				Lx=0;
				Ly+=80;
			}
			count++;
		}

		//draw the moving blue square
		g.setColor(Color.BLUE);
		g.fillRect(Sx,Sy,Swidth,Sheight);

	}

	public void run(){
        	int count=1;
	  	while(1>0){//makes the animation run forever, I used an idiotic expression to make the condition to true
			count=1;
			pX=Sx;
			pY=Sy;
			
			//If up==true, then the blue square starts to move to its starting position diagonally
			if(up==true){
				for(count=1;count<=4;count++){
					Sx-=80;
					Sy-=80;
					repaint();
					try{
						t.sleep(sleepfor);
					}
					catch(Exception e){
	
					}
				}
				up=false;
				line=1;
				reverse=false;	
				count=1;
			}

			//if up==false, then check whether the blue square has to move forward or backwards. if reverse==false, move forward
			else{
				if(reverse==false){
					Sx+=80;
					if(Sx>320){
						Sx=320;
						Sy+=80;
						line++;
						if(line!=6){
							reverse=true;
						}
						else{
							line--;
							Sy-=80;
							up=true;
						}
					}
				}

				//if reverse==true, move the blue square backwards
				else{
					Sx-=80;
					if(Sx<0){
						Sx=0;
						Sy+=80;
						line++;
						reverse=false;
					}
				}
			}

			//show the blue square in its new position
			repaint();

			//wait for 250 milliseconds before going for the next iteration
			try{
				t.sleep(sleepfor);
			}
			catch(Exception e){

			}
		}
	}

	public void update(Graphics g){
//temp and re is used to figure out, which colour to be filled for the white square which was left by g.clearRect()

		int re = temp%2;

//If you don't clear the footsteps of the blue square, you won't see any animation, for sure!
		g.clearRect(pX,pY,Swidth,Sheight);
		if(re==0){
			g.setColor(Color.RED);
		}
		else{
			g.setColor(Color.WHITE);
		}

//when you clear the footsteps, it will be displayed as a white square, so fill it up with the appropriate position colour
		g.fillRect(pX,pY,Swidth,Sheight);
		temp++;

//if blue square is in the starting position, reset temp to 1
		if((pX==0)&&(pY==0)){
			temp=1;
		}
		else if(up==true){
			temp-=2;
		}

//draw the background and blue square's new position
		paint(g);
	}

}
//<applet code=animation width=400 height=400>
//</applet>