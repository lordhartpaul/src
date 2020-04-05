import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class lek2 extends Applet
   implements MouseListener, MouseMotionListener {

	int my, mx, x = 0, y = 0;  
	String s = "";  
   	int width, height;
   	Image backbuffer;
   	Graphics bufferg;
   	int t=0;
	
public void init() {
	Font f1 = new Font("Arial",Font.BOLD,100);
      	width = getSize().width;
      	height = getSize().height;

	setBackground(Color.white);
	//DRAW THE COLOR BAR AND FRAME!!!	
      	backbuffer = createImage( width, height );
      	bufferg = backbuffer.getGraphics();
      		bufferg.setColor( Color.black );
      	bufferg.fillRect( 0, 0, 50, 40);
      		bufferg.setColor( Color.white );
      	bufferg.fillRect( 50, 0, 50, 40);
      		bufferg.setColor( Color.green );
      	bufferg.fillRect( 100, 0, 50, 40);
      		bufferg.setColor( Color.red );
      	bufferg.fillRect( 150, 0, 50, 40);
      		bufferg.setColor( Color.blue );
      	bufferg.fillRect( 200, 0, 50, 40);
      		bufferg.setColor( Color.yellow );
      	bufferg.fillRect( 250, 0, 50, 40);
      		bufferg.setColor( Color.gray );
      	bufferg.fillRect( 300, 0, 50, 40);
      		bufferg.setColor( Color.pink );
      	bufferg.fillRect( 350, 0, 50, 40);
      		bufferg.setColor( Color.lightGray );
      	bufferg.fillRect( 400, 0, 50, 40);
      		bufferg.setColor( Color.darkGray );
      	bufferg.fillRect( 450, 0, 50, 40);
      		bufferg.setColor( Color.cyan );
      	bufferg.fillRect( 500, 0, 50, 40);
      		bufferg.setColor( Color.magenta );
      	bufferg.fillRect( 550, 0, 50, 40);
      		bufferg.setColor( Color.orange );
      	bufferg.fillRect( 600, 0, 50, 40);
		Color knapp = new Color(146,26,114);
		bufferg.setColor(knapp);
      	bufferg.fillRect( 650, 0, 50, 40);
	for (int ram=0; ram<5; ram++) {

		bufferg.drawRect( ram, ram, 695, 35);

		
	}

	bufferg.setColor( Color.white );
	bufferg.drawString("Clear",660,25);
	bufferg.setFont(f1);
	addMouseListener( this );
      	addMouseMotionListener( this );
   }
   public void mouseEntered( MouseEvent e ) {}
   public void mouseExited( MouseEvent e ) {}
   public void mouseClicked( MouseEvent e ) {}
   	

	public void mousePressed( MouseEvent e ) {
      
      		mx = e.getX();
      		my = e.getY();
		x = e.getX();
      		y = e.getY();

		//SELECT COLOR!!!
		if (mx > 0 && mx < 50 && my < 40) {
			bufferg.setColor( Color.black );
			}
		if (mx > 50 && mx < 100 && my < 40) {
			bufferg.setColor( Color.white );
			}
		if (mx > 100 && mx < 150 && my < 40) {
			bufferg.setColor( Color.green );
			}
		if (mx > 150 && mx < 200 && my < 40) {
			bufferg.setColor( Color.red );
			}		
		if (mx > 200 && mx < 250 && my < 40) {
			bufferg.setColor( Color.blue );
			}	
		if (mx > 250 && mx < 300 && my < 40) {
			bufferg.setColor( Color.yellow );
			}
		if (mx > 300 && mx < 350 && my < 40) {
			bufferg.setColor( Color.gray );
			}
		if (mx > 350 && mx < 400 && my < 40) {
			bufferg.setColor( Color.pink );
			}
		if (mx > 400 && mx < 450 && my < 40) {
			bufferg.setColor( Color.lightGray );
			}		
		if (mx > 450 && mx < 500 && my < 40) {
			bufferg.setColor( Color.darkGray );
			}
		if (mx > 500 && mx < 550 && my < 40) {
			bufferg.setColor( Color.cyan );
			}
		if (mx > 550 && mx < 600 && my < 40) {
			bufferg.setColor( Color.magenta );
			}		
		if (mx > 600 && mx < 650 && my < 40) {
			bufferg.setColor( Color.orange );
			}	
		if (mx > 650 && mx < 700 && my < 40) {
			bufferg.clearRect(0,40,width,height-120);
			}
		
		
      		repaint();
      		e.consume();
   	}
   	public void mouseReleased( MouseEvent e ) { 
      		
      		repaint();
      		e.consume();
   		}
   	public void mouseMoved( MouseEvent e ) { 
		x = e.getX();
      		y = e.getY();
		s = "  X: " + x + " Y: " + y;
		bufferg.clearRect(0,500,width,600);
		bufferg.drawString(s,0,600);
      		repaint();
      		e.consume();
   	}



   	public void mouseDragged( MouseEvent e ) {
      		int oldx = x;
		int oldy = y;
		int t=0;
		x = e.getX();
      		y = e.getY();
				
		s = "  X: " + x + " Y: " + y;
		
		bufferg.clearRect(0,500,width,600);
		bufferg.drawString(s,0,600);
		t++;
		if (y > 50 && y < 500){
		
		for (int i = 0; i < 20; i++){
      			bufferg.drawLine(x+i,y,oldx+i,oldy);
		}
		repaint();
      		e.consume();
		}
   	}

   	public void update( Graphics g ) {
      		g.drawImage( backbuffer, 0, 0, this );
   	}

   	public void paint( Graphics g ) {
		

		
		


   }
}

