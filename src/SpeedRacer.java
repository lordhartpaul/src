import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.applet.*;

//
// main applet class
//

/*
<applet code="SpeedRacer"width=300 height=300>
</applet>
*/


public class SpeedRacer extends Applet {

	public void init() {
		setSize(400, 400);
		setLayout(new BorderLayout());

		SkyCanvas sky = new SkyCanvas(400, 100);
		add(sky, "North");
		DashCanvas dash = new DashCanvas(400, 100, this);
		add(dash, "South");
		RoadCanvas road = new RoadCanvas(400, 200, dash, this);
		add(road, "Center");
	}
}

//
// Canvas for stuff above the horizon
//
class SkyCanvas extends Canvas {

	int xdim, ydim;

	public SkyCanvas(int x, int y) {
		xdim = x;
		ydim = y;
	}

	public void addNotify() {
		super.addNotify();
		setSize(xdim, ydim);
	}

	public void paint(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(0, 0, xdim, ydim);
	}
}

//
// Canvas for stuff on the dash
//
class DashCanvas extends Canvas {

	int xdim, ydim;
	int speed;
	int damage;
	int angel;
	int devil;
	int time_left;
	Image halo, trident;
	Applet mom;
	Image db;
	MediaTracker tracker;
	Font dash_font;

	public DashCanvas(int x, int y, Applet mom) {
		xdim = x;
		ydim = y;
		speed = angel = devil = 0;
		damage = 0;
		time_left = 0;
		this.mom = mom;

		dash_font = new Font("Helvetica", Font.ITALIC, 20);
		tracker = new MediaTracker(mom);
		halo = mom.getImage(mom.getDocumentBase(), "angel.gif");
		trident = mom.getImage(mom.getDocumentBase(), "devil.gif");
		tracker.addImage(halo, 0);
		tracker.addImage(trident, 1);
	}

	public void addNotify() {
		super.addNotify();

		setSize(xdim, ydim);

		db = createImage(xdim, ydim);  // double buffer image

		try {
			tracker.waitForAll(); // get images
		} catch (InterruptedException e) {
			System.out.println(e);
		}

	}

	public void update(Graphics g) { // no flicker
		paint(g);
	}

	public void paint(Graphics g) {
		Graphics g2 = db.getGraphics();

		g2.setColor(Color.lightGray);
		g2.fillRect(0, 0, xdim, ydim);

		g2.setColor(Color.black);

		g2.setFont(dash_font);
		FontMetrics fm = g2.getFontMetrics();

		// speed indicator
		int height = fm.getAscent() + fm.getDescent();// + fm.getLeading();
		g2.drawString("Speed: " + speed, 10, height);

		// damage indicator
		if (damage > 100) damage = 100;
		g2.drawString("Damage: ", 10, height*2);
		int offset = fm.stringWidth("Damage: ");
		g2.setColor(Color.blue);
		int x1 = offset+10;
		int y1 = height*2-height+fm.getDescent();
		int w = xdim-10-x1;
		int h = height*2-y1;
		g2.drawRect(x1, y1, w, h);
		g2.fillRect(x1, y1, w*damage/100, h);

		int iconx, icony;
		// halo
		iconx = xdim*1/3-halo.getWidth(mom);
		g2.drawImage(halo, iconx, height*3-height+fm.getDescent(), mom);
		g2.setColor(Color.black);
		g2.drawString(" "+angel, iconx+halo.getWidth(mom), height*3);


		// trident
		iconx = xdim*2/3-trident.getWidth(mom);
		g2.drawImage(trident, iconx, height*3-height+fm.getDescent(), mom);
		g2.setColor(Color.black);
		g2.drawString(" "+devil, iconx+trident.getWidth(mom), height*3);

		// score
		g2.drawString("Score: " + Math.abs(angel-devil), 10, height*4);

		// time left
		offset = fm.stringWidth("Time: 000");
		g2.drawString("Time: " + time_left, xdim-10-offset, height*4);

		// buffer to front
		g.drawImage(db, 0, 0, mom);
	}
}

//
// Canvas for the road and action!
//

class RoadCanvas extends Canvas {

	Image db;
	Car car;
	MediaTracker tracker;
	Applet mom;
	int xdim, ydim;
	Target target[];
	Ticker ticker;
	DashCanvas dash;
	Line line[] = new Line[4];
	int suggested_speed = 0;
	int suggested_xpos = 0;
	int x_acceleration = 0;
	int time_left = 0;
	int t2tl = 30;  // time to countdown timer another notch
	boolean game_over = true;

	static int GOODPERSON = 0;  // indices for target[]
	static int BADPERSON = 1;
	static int BARRIER = 2;

	public RoadCanvas(int x, int y, DashCanvas dash, Applet mom) {

		this.mom = mom;
		this.dash = dash;
		this.xdim = x;
		this.ydim = y;

		ticker = new Ticker(this);

		// get me a car and load the image
		car = new Car();
		car.y = ydim - 70;

		// give me lines in the road
		for(int i = 0; i < line.length; i++)
			line[i] = new Line(i*i*15+3, 10, ydim);

		// give me some targets
		target = new Target[3];
		target[GOODPERSON] = new Target(mom, "good1.gif", "good2.gif", "deadgood.gif", 3, 20, 0, 3, 1, 0, false);
		target[BADPERSON] = new Target(mom, "bad1.gif", "bad2.gif", "deadgood.gif", 3, 20, 0, 3, 0, 1, false);
		target[BARRIER] = new Target(mom, "barr.gif", null, "deadbarr.gif", 999, 999, 15, 15, 0, 0, true);

		car.image = mom.getImage(mom.getDocumentBase(), "car.gif");
		tracker = new MediaTracker(mom);
		tracker.addImage(car.image, 0);

		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (game_over) {
					game_over = false;
					car.damage = 0;
					car.goodkills = 0;
					car.badkills = 0;
					t2tl = 30;
					time_left = 100;
				}
			}
		});

		// get ready to handle keyboard input!
        requestFocus();
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent event) {
                switch(event.getKeyCode()) {
                case KeyEvent.VK_LEFT:
					if (car.speed > 0)
						car.x-=car.turnspeed;
                    break;
                case KeyEvent.VK_RIGHT:
					if (car.speed > 0)
						car.x+=car.turnspeed;
                    break;
                case KeyEvent.VK_UP: // fall thru
					car.speed++;

					break;

                case KeyEvent.VK_DOWN:
					car.speed--;
					if (car.speed < 0) car.speed = 0;
					break;

				default:
					System.out.println("Some key event");
                    break;
                }
            }
		});

		// use the mouse for driving
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent m) {
				suggested_speed = (ydim - m.getY()-30)/3;
				if (suggested_speed < 0) suggested_speed = 0;
				suggested_xpos = m.getX() - xdim/2;
				x_acceleration = Math.abs(car.x - suggested_xpos) / 5;
				if (x_acceleration > car.speed)
					x_acceleration = car.speed;
			}
		});

		// gimme a nice crosshair for aiming
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

		// get updates every so often
		ticker.start();
	}

	public void addNotify() {
		super.addNotify();

		setSize(xdim, ydim);

		db = createImage(xdim, ydim);

		try {
			tracker.waitForAll();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}

	public void update(Graphics g) { // no flicker
		paint(g);
	}

	public void paint(Graphics g) {
		// this is the only place in the universe we can put this
		// request focus (not including event handlers) and have 
		// it work right.  If it's not here, focus will never ever
		// be gained in a zillion years and no key events will be
		// caught.  Everywhere else, this call is seemingly 
		// ignored.
		requestFocus();

		Graphics g2 = db.getGraphics();  // draw to double buffer

		g2.setColor(Color.green); // draw land
		g2.fillRect(0, 0, xdim, ydim);

		g2.setColor(Color.darkGray); // draw road
		int xpoints[] = new int[4];
		int ypoints[] = new int[4];
		xpoints[0] = xdim/2-5; ypoints[0] = 0; // top constant
		xpoints[1] = xdim/2+5; ypoints[1] = 0;
		xpoints[2] = xdim - 60 - car.x; ypoints[2] = ydim; // bottom moves
		xpoints[3] =    0 + 60 - car.x; ypoints[3] = ydim;
		g2.fillPolygon(xpoints, ypoints, 4);

		int bottomcenter = ydim - car.x;

		// draw a dashed line
		for(int i = 0; i < line.length; i++) {
			g2.setColor(Color.white);
			int x1 = (int)(line[i].y1 * (bottomcenter - xdim/2) / ydim + ydim);
			int x2 = (int)(line[i].y2 * (bottomcenter - xdim/2) / ydim + ydim);
			g2.drawLine(x1, (int)(line[i].y1), x2, (int)(line[i].y2));
		}

		// draw objects
		for(int i = 0; i < target.length; i++) {
			Target t = target[i];
			if (t.y >= 0) {
				int visx = (int)t.y * (bottomcenter+t.x - (xdim/2)) / ydim + ydim;
				int wid = t.image[t.current].getWidth(mom);
				int hei = t.image[t.current].getHeight(mom);
				float sf = (float)(((int)t.y+hei)/(float)ydim);  // scale factor
				g2.drawImage(t.image[t.current], visx, 
									 (int)t.y,
									 visx+(int)(wid*sf), 
									 (int)t.y+(int)(hei*sf),
									 0, 0, wid, hei, mom);
			}
		}

		g2.drawImage(car.image, xdim/2-32, car.y, mom); // draw car

		// draw game over sign
		if (game_over) {
			g2.setFont(new Font("Helvetica", Font.ITALIC | Font.BOLD, 23));
			FontMetrics fm = g2.getFontMetrics();
			int width = fm.stringWidth("Game Over");
			int height = fm.getAscent() + fm.getDescent();
			g2.setColor(Color.white);
			g2.drawString("Game Over", (xdim-width)/2, height*2);
			g2.setColor(Color.black);
			g2.drawString("Game Over", (xdim-width)/2-1, height*2-1);

			g2.setFont(new Font("Helvetica", Font.BOLD | Font.ITALIC, 13));
			fm = g2.getFontMetrics();
			width = fm.stringWidth("Click to Start");
			height = height*2 + (fm.getAscent() + fm.getDescent())*2;
			g2.setColor(Color.white);
			g2.drawString("Click to Start", (xdim-width)/2, height);
			g2.setColor(Color.black);
			g2.drawString("Click to Start", (xdim-width)/2-1, height-1);
		}

		// finally slap that on the screen
		g.drawImage(db, 0, 0, mom);
	}

	// time to do some stuff!
	public void tick() {

		//move the stuff
		for(int i = 0; i < target.length; i++) 
			target[i].update(ydim, car.speed);

		// move the lines down the street
		for(int i = 0; i < line.length; i++) {
			line[i].y1 += (line[i].y1+1)/(float)ydim * car.speed;
			line[i].y2 += (line[i].y2+1)/(float)ydim * car.speed;
			if (line[i].y1 > ydim) line[i].reset();
		}

		// move the car
		car.dist += car.speed;
		if (car.y < ydim - 70) car.y++; // bump!

		if (game_over)
			suggested_speed = 0;

		// accelerate and steer
		if (car.speed < suggested_speed) car.speed++;
		else if (car.speed > suggested_speed) car.speed--;

		if (car.speed > 0) {
			if (car.x > suggested_xpos) car.x -= x_acceleration;
			if (car.x < suggested_xpos) car.x += x_acceleration;
		}
		
		dash.speed = car.speed * 2;
		dash.damage = car.damage;
		dash.angel = car.badkills;
		dash.devil = car.goodkills;
		dash.time_left = time_left;

		// see what we hit
		int x1 = car.x-32; // -32 cause car is centered on screen 
		int x2 = x1+car.image.getWidth(mom);
		int y1 = car.y;
		int y2 = y1+car.image.getHeight(mom);
		boolean hitsomething = false;

		for(int i = 0; i < target.length; i++) {
			if (target[i].collision(x1, y1, x2, y2) && car.speed > 0) {
				if (target[i].current < target[i].image.length - 1) {
					car.speed -= target[i].slowdown;
					if (car.speed < 1) car.speed = 1;
					car.damage += target[i].damage;
					car.goodkills += target[i].goodworth;
					car.badkills += target[i].badworth;
				}
				target[i].current = target[i].image.length - 1; // change to dead image
				hitsomething = true;
			}
		}

		if (hitsomething) 
			if (car.speed > 0 && car.y == ydim - 70)
				car.y -= 2; // make a bump

		if (car.damage >= 100)
			game_over = true;

		// decrement timer
		if (!game_over && time_left > 0) {
			t2tl--;
			if (t2tl <= 0) {
				time_left--;
				t2tl = 30;
			}
		} else
			game_over = true;  // outta time

		repaint();  // show the new things!
		dash.repaint();
	}
}

class Car {
	int speed;
	int x;
	int y;
	int goodkills;
	int badkills;
	int dist;
	int turnspeed;
	int damage;
	Image image;

	public Car() {
		speed = dist = x = goodkills = badkills = 0;
		image = null;
		turnspeed = 5;
		damage = 0;
	}
}

//
// Hey!  There's something in the road.
//
class Target {
	int x;
	float y;
	int deltax;     // change in x pos each round
	int time2move;  // time until deltax influences x pos
	Image image[];  // a some images to cycle through
	int current;  // index of image on screen; if last, it's dead
	int time2shift; // time until image change
	boolean fixed;  // true if we shouldn't move this guy at all
	Applet mom;
	int t2m_top;   // don't change these--use them to reset
	int t2s_top;
	int damage;   // how much it hurts to hit
	int slowdown; // how much it slows us
	int goodworth;
	int badworth;

	static int maxx = (400-120)/2; // max road x value

	public Target(Applet mom, String image1, String image2, String dead,
		int t2m, int t2s, int damage, int slow, int goodworth, int badworth,
		boolean fixed) {

		this.mom = mom;
		t2m_top = t2m;
		t2s_top = t2s;
		this.fixed = fixed;
		this.damage = damage;
		this.slowdown = slow;
		this.goodworth = goodworth;
		this.badworth = badworth;

		MediaTracker mt = new MediaTracker(mom);
		// final image is the dead image
		if (image2 != null) {
			image = new Image[3];
			image[0] = mom.getImage(mom.getDocumentBase(), image1);
			mt.addImage(image[0], 0);
			image[1] = mom.getImage(mom.getDocumentBase(), image2);
			mt.addImage(image[1], 1);
			image[2] = mom.getImage(mom.getDocumentBase(), dead);
			mt.addImage(image[2], 2);
		} else {
			image = new Image[2];
			image[0] = mom.getImage(mom.getDocumentBase(), image1);
			mt.addImage(image[0], 0);
			image[1] = mom.getImage(mom.getDocumentBase(), dead);
			mt.addImage(image[1], 1);
		}
		try { mt.waitForAll(); }
		catch (InterruptedException e) { System.out.println(e); }

		resetRand();
	}

	public void resetRand() {
		x = (int)(Math.random() * (maxx*2) - maxx);
		y = 0;
		deltax = (int)(Math.random()>0.5?-1:1);
		time2move = t2m_top;
		time2shift = t2s_top;
		current = 0;
		y = (int)(Math.random() * -200);
	}

	public void update(int ydim, int speed) {
		// move the target down the screen:
		y += (Math.abs(y)+1)/(float)ydim * speed;

		if (y > ydim) resetRand();
		if (!fixed && current != image.length - 1) {
			time2move--;
			if (time2move <= 0) {
				x += deltax;
				time2move = t2m_top;
			}
		}

		// update the current images, if necessary:
		time2shift--;
		if (time2shift <= 0) {
			if (current < image.length-1) { // !dead
				current++;
				if (current == image.length-1)
					current = 0;  // don't show the dead image
			}
			time2shift = t2s_top;
		}
	}

	// collision code disregards scale factor.  But the images are so
	// close to full size when they reach the car it makes no
	//difference.

	public boolean collision(int a1, int b1, int a2, int b2) {
		// collision checking
		int x1 = x;
		int x2 = x1+image[current].getWidth(mom);
		int y1 = (int)y;
		int y2 = y1+image[current].getHeight(mom);

		if ((x1 >= a1 && x1 <= a2 && y1 >= b1 && y1 <= b2) ||
		    (x2 >= a1 && x2 <= a2 && y1 >= b1 && y1 <= b2)) {
				return true;
		}

		return false;
	}

}

//
// ticker thread -- runs things in the RoadCanvas that updates things
//                  and does stuff.
//

class Ticker extends Thread {

	static int sleep_time = 20; // milliseconds
	RoadCanvas mom;

	public Ticker(RoadCanvas mom) {
		this.mom = mom;
	}

	public void run() {
		while(true) { // forever!

			// sleep a bit
			try {
				this.sleep(sleep_time);
			}
			catch(Exception e) {
				System.out.println(e);
			}

			// notify mom!
			mom.tick();
		}
	}
}

//
// Cheesy class for line in the road
//
class Line {
	float y1, y2;
	int len, height;

	public Line(int start, int len, int height) {
		this.len = len;
		this.height = height;

		this.y1 = this.y2 = (float)start;

		for(int i=0;i<len;i++)
			y2 += (y2+1)/(float)height * len;
	}

	public void reset() {
		this.y1 = this.y2 = 0;

		for(int i=0;i<len;i++)
			y2 += (y2+1)/(float)height * len;
	}
}
