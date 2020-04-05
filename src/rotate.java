import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class rotate extends Applet implements Runnable,ActionListener
 {  
    double x[]= new double[2];
    double y[] = new double[2];       
    double j=0,k,j1,m,m1,m2;    
    long l; 
    String sl="",sb="";
    int fx,sx,tx,fox,fy,sy,ty,foy,len,br,sq,eq;

    //(x,y) points of rectangle
    int x2[]={fx,sx,tx,fox,fx};
    int y2[]={fy,sy,ty,foy,fy};

    Label l0=new Label("Length");
    Label l1=new Label("Breadth");
  
    TextField tf,tf1;
  
public void init()
 {
   Thread t=new Thread();
   t.start();
   setBackground(Color.black);
   setForeground(Color.green);
   tf=new TextField(sl,2);
   tf1=new TextField(sb,2);

   add(l0);
   setForeground(Color.red); add(tf);
   setForeground(Color.green);add(l1);
   setForeground(Color.red);add(tf1);

   tf.addActionListener(this);
   tf1.addActionListener(this);  
   
 }

public void actionPerformed(ActionEvent ae) 
  {
    try{ 
        sl=tf.getText();
        sb=tf1.getText();// getting i/p value of len & breadth
        len=Integer.parseInt(sl);
        br=Integer.parseInt(sb);
        sq=(len*len)+(br*br);
        k=Math.sqrt(sq);
        sq=(int)k;// diagonal value of rect. 
        sq=sq/2;

        if(len>br)         
         m2=(br*90/len);       
        else
         m2=(len*90/br);

        l=Math.round(m2);
        eq= (int)l; 
//find the distance of angle b/w first & second x,y points of circle //having diagonal as radius   
       
       
      run();
       }
   catch(Exception e)
     { } 
   
  }

public void run()
 {  
     // first x,y points
      k=Math.toRadians(j);
      x[0]=(150+(sq* Math.cos(k)));
      l=Math.round(x[0]);
      fx= (int)l; 
      y[0]=(150+(sq* Math.sin(k)));
      l=Math.round(y[0]);
      fy= (int)l; 

    // 3rd x,y points are 180 degree away from first x,y points
     if(j<180)
         j1=j+180;
      else
         j1=j-180; 
 
   // third x,y points
      k=Math.toRadians(j1);
      x[0]=(150+(sq* Math.cos(k)));
      l=Math.round(x[0]);
      tx= (int)l; 
      y[0]=(150+(sq* Math.sin(k)));
      l=Math.round(y[0]);
      ty= (int)l;  

      if((j+eq)>360)
       m=(j+eq)-360;
      else
       m=j+eq;   
  
    // 2nd x,y points
      k=Math.toRadians(m);
      x[0]=(150+(sq* Math.cos(k)));
      l=Math.round(x[0]);
      sx= (int)l; 
      y[0]=(150+(sq* Math.sin(k)));
      l=Math.round(y[0]);
      sy= (int)l;  

      if(m<180)
         m1=m+180;
      else
         m1=m-180; 
 
    // 4th x,y points
      k=Math.toRadians(m1);
      x[0]=(150+(sq* Math.cos(k)));
      l=Math.round(x[0]);
      fox= (int)l; 
      y[0]=(150+(sq* Math.sin(k)));
      l=Math.round(y[0]);
      foy= (int)l; 
   
   //increase the degree value
      j=j+=1;if(j>359) j=0;
      x2[0]=fx; x2[1]=sx; x2[2]=tx; x2[3]=fox; x2[4]=fx;
      y2[0]=fy; y2[1]=sy; y2[2]=ty; y2[3]=foy; y2[4]=fy;

      try
      {
       Thread.sleep(15);
      }
     catch(Exception e) { } 
    
     repaint();
 }

 public void paint(Graphics g)
  {     
   setForeground(Color.blue);
   g.drawPolygon(x2,y2,5); // drawing rectangle using 4 x,y points 
   run();   
  }  
   
}



/*<applet code="rotate" width=300 height=300>
</applet> */


                                      