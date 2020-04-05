/*
 * Gamrec.java
 *
 * Created on October 7, 2007, 6:30 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package gamertv;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author UNICORN
 */
public class Gamrec extends javax.swing.JApplet implements Runnable
{
    Dimension d;
    Graphics g1;
    int q,w,s;
    JPanel p;
    Thread th;
    /** Creates a new instance of Gamrec k/]}{\=*/
    public void init()
    {
        setSize(300,300);
        d=getSize();
        p=new JPanel();
        getContentPane().add(p);
         
        th=new Thread(this);
       
        th.start();
       
        
        s=0;
    }
    
    
    public void run()
    {
        while(Thread.currentThread()==th)
        {
        repaint();
         try
         {
             Thread.sleep(500);
         }
         catch(InterruptedException e)
         {
             break;
         }
    }
        
        
    }
    
    public void stop()
    {
        try
        {
        th=null;
        
    }
        catch(Exception e)
        {
            getAppletContext().showStatus("thread interupted");
        }
    }
    
     public void destroy()
     {
         try
        {
        th=null;
        
    }
        catch(Exception e)
        {
            getAppletContext().showStatus("thread interupted");
        }
         
              }
    
    
      
      
    public void update(Graphics g)
    {
       
        if(s==0)
        {
            p.setBackground(Color.WHITE);
            g.setColor(Color.cyan);
        g.fill3DRect(q,w,50,50,true);
         s=1;
    }
        else
        {
            
    g.setColor(getBackground());
        g.clearRect(0,0,d.width,d.height);
        s=0;
    }
        q=(int)(Math.random()*1000)%(d.width-(d.width/10));
        w=(int)(Math.random()*1000)%(d.height-(d.height/10));
        
    }
    }

