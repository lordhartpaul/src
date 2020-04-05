/*<html>
<applet
code = dauber4
width = 400
height = 240>
</applet>
</html>*/

import java.awt.Graphics;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;
import java.applet.Applet;
public class dauber4 extends Applet implements ActionListener, MouseListener, MouseMotionListener
{
	Button buttonzigzag;
	Point ptAnchor, ptTemp;
	Point pts[] = new Point[10000];
	Point pt[]=new Point[10000];
	int loop_index=0,i=0;
	int ptindex = 0;
	// The flags are set according to the button clicked
	    boolean bzigzagFlag=false;
		public void init() 
                                      {
		buttonzigzag=new Button("zigzag");
		add(buttonzigzag);
		buttonzigzag.addActionListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
                                        }
		public void mouseClicked(MouseEvent pe)
                                        {
                                           if(bzigzagFlag)
                                                 {
                 	                                ptAnchor=new Point(pe.getX(),pe.getY());
													bzigzagFlag=!bzigzagFlag;
                                                  }
																  if((!bzigzagFlag)&&(ptindex >0))
                                                              {
																 ptTemp=new Point(pts[ptindex-1].x,pts[ptindex-1].y);
																 while(loop_index<=ptindex)
																 {
																  if(loop_index==(ptindex-1))
																  {
																  pt[i]=pts[ptindex-1];
																  i++;
																   }
																   loop_index++;
																  }
															  }
	                                                        repaint();
                                             }
    public void mouseMoved(MouseEvent me) 
	{
        showStatus("mouse mooved");
		 pts[ptindex] = new Point(me.getX(),me.getY());
		  ptindex++;
     }
 	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseDragged(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	
	public void paint(Graphics g)
                     {
					 if((!bzigzagFlag)&&(ptindex>0))
					// if((ptAnchor instanceof Point)&&(ptTemp instanceof Point))
				     {
					      for(i=0;i<ptindex-1;i++)
						  {
					        g.drawLine(ptAnchor.x,ptAnchor.y,pt[i].x,pt[i].y);  
						    //g.drawLine(ptAnchor.x,ptAnchor.y,ptTemp.x,ptTemp.y);      		    		
							}
                      }
                      }
    	public void actionPerformed(ActionEvent e) 
                     {
		if(e.getSource() == buttonzigzag)
		{
   		     bzigzagFlag=!bzigzagFlag; 
		 }	
                                                                                      }
}