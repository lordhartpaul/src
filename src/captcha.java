import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
*<applet code="captcha"width=300 height=300>
 * <param name="Image1" value="1.png">
 * <param name="Image2" value="2.gif">
 * <param name="Image3" value="3.png">
 * <param name="Image4" value="4.jpeg">
 * </applet>
 */ 
public class captcha extends Applet implements ActionListener
{
    String msg;
    Button submit;
    TextField namefield;
    Image img1;
    String filenames[]={"Image1","Image2","Image3","Image4"};
    String filetext[]={"maria","jw62k","azeob","hymne"};
    String filename;
    int x;
    public void init()
    {
        setLayout(null);
        namefield=new TextField("",5);
        submit=new Button("submit");
        add(namefield);
        add(submit);
        submit.addActionListener(this);
        filename=new String(filenames[0]);
        img1=getImage(getDocumentBase(),getParameter(filename));
        namefield.setBounds(100,150,100,30);
        submit.setBounds(100,200,100,40);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String str=namefield.getText();
        if(str.equals(filetext[x]))
        {
         msg="Log In";
         repaint();
        }
        else
        {
            msg="Wrong Try Again";
            namefield.setText(null);
            x=(int)((Math.random()*100)%4);
            filename=new String(filenames[x]);
            img1=getImage(getDocumentBase(),getParameter(filename));
            repaint();
        }
repaint();
    }
    public void paint(Graphics g)
    {
        g.drawImage(img1,10,10,this);
        g.drawString(msg,100,300);
    }
}