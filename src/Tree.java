////////////////////////////////////////////////////////////////////////////
// "Tree.java" - Demonstrates various types of minimum-length
// interconnection trees (minimum spanning tree, Steiner tree, etc.)
//
// Author: Joe Ganley, ganley@cadence.com
////////////////////////////////////////////////////////////////////////////



import java.lang.*;
import java.awt.*;

/*
<applet code="Tree"width=300 height=300>
</applet>
*/



public class Tree extends java.applet.Applet {

private final int	maxN = 30;	// the max number of terminals
private int		n = 10;		// the current number of terminals
private final int	r = 4;		// the radius of a terminal
private Point		p[];		// the terminals
private Point		current;	// the current one and its old location
private boolean		m[][];		// the minimum spanning tree edges
private Rectangle	border, inner;	// applet borders
private Scrollbar	sb;		// scrollbar for changing n
private Image		buffer;		// buffer for double-buffering
private Graphics	bufg;		// buffer's Graphics


public void init() {
  p = new Point[maxN];
  current = null;
  m = new boolean[maxN][maxN];

  border = new Rectangle(0, 0, size().width - 1, size().height - 1);
  inner = new Rectangle(r + 1, r + 1,
			size().width - 2 * r - 3, size().height - 2 * r - 23);

  // initialize the terminals to random locations
  for (int i = 0; i < maxN; i++) {
    p[i] = new Point((int) Math.round(Math.random()
				  * (size().width - 2 * r - 2) + r + 1),
		     (int) Math.round(Math.random()
				  * (size().height - 20 - 2 * r - 2) + r + 1));
    for (int j = 0; j < maxN; j++) {
      m[i][j] = false;
    }
  }
  mst();

  setBackground(Color.white);

  setLayout(new BorderLayout());
  sb = new Scrollbar(Scrollbar.HORIZONTAL, n, 5, 2, maxN);
  add("South", sb);

  buffer = createImage(size().width, size().height);
  bufg = buffer.getGraphics();
  bufg.setFont(getFont());
} // init()


public void update(Graphics g) {
  bufg.setColor(getBackground());
  bufg.fillRect(border.x, border.y, border.width, border.height);
  bufg.setColor(Color.black);
  bufg.drawRect(border.x, border.y, border.width, border.height);

  // first do the MST edges
  for (int i = 0; i < n; i++) {
    for (int j = (i + 1); j < n; j++) {
      if (m[i][j]) {
	bufg.setColor(Color.red);
	bufg.drawLine(p[i].x, p[i].y, p[j].x, p[j].y);
      }
    }
  }
  
  // redraw the terminals
  for (int i = 0; i < n; i++) {
    bufg.setColor(Color.green);
    bufg.fillOval(p[i].x - r, p[i].y - r, 2 * r, 2 * r);
    bufg.setColor(Color.black);
    bufg.drawOval(p[i].x - r, p[i].y - r, 2 * r, 2 * r);
  }

  // draw the current one in cyan
  if (current != null) {
    bufg.setColor(Color.cyan);
    bufg.fillOval(current.x - r, current.y - r, 2 * r, 2 * r);
    bufg.setColor(Color.black);
    bufg.drawOval(current.x - r, current.y - r, 2 * r, 2 * r);
  } 

  g.drawImage(buffer, 0, 0, null);
} // update(Graphics)


public void paint(Graphics g) {
  update(g);
} // paint(Graphics)


public boolean handleEvent(Event evt) {
  switch (evt.id) {

  case Event.MOUSE_DOWN: {
    Rectangle rect = new Rectangle();

    current = null;
    for (int i = 0; (i < n) && (current == null); i++) {
      rect.reshape(p[i].x - r, p[i].y - r, 2 * r, 2 * r);
      if (rect.inside(evt.x, evt.y)) {
	current = p[i];
      }
    }
    break;
  }

  case Event.MOUSE_UP: {
    current = null;
    repaint();
    break;
  }

  case Event.MOUSE_DRAG: {
    if (current != null) {
      if (inner.inside(evt.x, evt.y)) {
	current.move(evt.x, evt.y);
      }
      else {
	current.move(Math.max(Math.min(evt.x, inner.x + inner.width), inner.x),
		   Math.max(Math.min(evt.y, inner.y + inner.height), inner.y));
      }
      mst();
      repaint();
    }
    break;
  }

  case Event.SCROLL_LINE_UP: case Event.SCROLL_LINE_DOWN:
  case Event.SCROLL_PAGE_UP: case Event.SCROLL_PAGE_DOWN:
  case Event.SCROLL_ABSOLUTE: {
    n = sb.getValue();
    mst();
    repaint();
    break;
  }

  default: {
    break;
  }

  } // switch

  return(true);
} // handleEvent(Event)


// Euclidean distance between two points (x1,y1) and (x2,y2)
private int distance(int x1, int y1, int x2, int y2) {
  return((int) Math.round(Math.sqrt(
		     (double) (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2))));
} // distance(int,int,int,int)


// mst - compute a minimum spanning tree using Prim's algorithm with "dumb"
// heaps.  This is the fastest graph algorithm for complete graphs, though
// we could do better geometrically - but with 10 terminals, why bother?
private void mst() {
  int dist[], neigh[], closest, minDist, d;

  dist = new int[n];
  neigh = new int[n];

  // initialize data structures
  for (int i = 0; i < n; i++) {
    dist[i] = distance(p[0].x, p[0].y, p[i].x, p[i].y);
    neigh[i] = 0;
    for (int j = 0; j < n; j++) {
      m[i][j] = false;
    }
  }

  // find terminal closest to current partial tree
  for (int i = 1; i < n; i++) {
    closest = -1;
    minDist = Integer.MAX_VALUE;
    for (int j = 1; j < n; j++) {
      if ((dist[j] != 0) && (dist[j] < minDist)) {
	closest = j;
	minDist = dist[j];
      }
    }
    
    // set an edge from it to its nearest neighbor
    m[neigh[closest]][closest] = true;
    m[closest][neigh[closest]] = true;

    // update nearest distances to current partial tree
    for (int j = 1; j < n; j++) {
      d = distance(p[j].x, p[j].y, p[closest].x, p[closest].y);
      if (d < dist[j]) {
	dist[j] = d;
	neigh[j] = closest;
      }
    }
  }
} // mst()

} // class Tree extends java.applet.Applet
