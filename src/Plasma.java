
import java.awt.*;
import java.applet.*;
import java.awt.image.*;

public class Plasma extends Applet implements Runnable
{
	
	int plasma[]=new int[256];
	Thread t=null;
	int w,h;
	boolean stopflag=true;
	Image buffer=null;
	int choice;
	int pixels[];
	int lookup[];
	
	public void init()
	{
      double d;
      choice=Integer.parseInt(getParameter("effect"));
      Dimension dim=getSize();
      w=dim.width;
      h=dim.height;
      int r,g,b,i;
       pixels=new int[w*h];
      lookup=new int[w*h];
      double pi=22.0/7;
                  	
                         	
               for(i=0;i<256;i++)
                  {
        	       r=(int)(128.0+128*Math.sin(pi*i/32.0));
        	 g=(int)(128+128*Math.sin(pi*i/64.0));
        	 b=(int)(128+128*Math.sin(pi*i/128.0));
        	 
        	 plasma[i]=(255<<24)|(r<<16)|(g<<8)|b;
        	         
        }
       
       switch(choice)
         {
         	 
        case 1:
                  for(r=0;r<h;r++)
         			{
         	          for(g=0;g<w;g++)
         	             {
         	 	           i=(int)(128+128*Math.sin(g/16.0));
         	 	         	 	lookup[g+r*h]=i;
         	              }
         	           }
         	           break;
        case 2:
                     for(r=0;r<h;r++)
                        {
         	             for(g=0;g<w;g++)
         	              {
         	 	            i=(int)(128+128*Math.sin(r/16.0));
         	 	         	 	lookup[g+r*h]=i;
         	               }
         	             }
         	            break;
        case 3:
                   for(r=0;r<h;r++)
                    {
         	         for(g=0;g<w;g++)
         	           {
         	 	          i=(int)(128+128*Math.sin((r+g)/16.0));
         	 	       	 	lookup[g+r*h]=i;
         	            }
         	          }

 	                  break;

        case 4:
                d=0;
                for(r=0;r<h;r++)
                  {
                  	for(g=0;g<w;g++)
                  	  {
                        d=d+(r-100)*(r-100)+(g-100)*(g-100);
                        d=Math.sqrt(d);        	  	
                        i=(int)(128+128*Math.sin(d/16.0));
                        lookup[g+r*h]=i;
                    }
                }
                break;
         case 5:
          
               for(r=0;r<h;r++)
                 {
         	       for(g=0;g<w;g++)
         	      {
         	 	    i=(int)(128+128*Math.sin(r/16.0)+128+128*Math.sin(g/16.0));
         	 	     i=i/2;
         	 	      lookup[g+r*h]=i;
         	        }
         	       }
                break;
       
       case 6:
       
                for(r=0;r<h;r++)
                 {
         	       for(g=0;g<w;g++)
         	      {
   i=(int)(128+128*Math.sin(g/16.0)+128+128*Math.sin(r/16.0)+128+128*Math.sin((r+g)/16.0));
   d=Math.sqrt(r*r+g*g);
   d=Math.sqrt(d);
   i=i+(int)(128*Math.sin(d/16.0));      	 	    
         	 	     i=i/4;
         	 	      lookup[g+r*h]=i;
         	        }
         	       }
         	       
         	       break;
         	    }
                	
	}

public void start()
{
	t=new Thread(this);
	t.start();
}

public void run()
{
	for(;;){
		try{
			repaint();
			Thread.sleep(5);
			if(stopflag)
			 break;
}catch(InterruptedException e){}
}
}
		public void stop(){
			stopflag=false;
			t=null;
		}
	public void paint(Graphics g)
	{
		update(g);
	}
	public void update(Graphics g)
	{
		
		int i,x,y,t;
		for(y=0;y<h;y++)
		 {
		 	 for(x=0;x<w;x++)
		 	  {
                 	t=x+y*h;	 	  	
		 	  	pixels[t]=plasma[lookup[t]];
		 	  }
		 	}

		buffer=createImage(new MemoryImageSource(w,h,pixels,0,w));
              g.drawImage(buffer,0,0,this);
              
              int temp;
		temp=plasma[0];
		for(i=1;i<256;i++)
		 {plasma[i-1]=plasma[i];}
		 plasma[255]=temp;
		}
}
