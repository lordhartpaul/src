import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class NormalArea extends Applet implements ActionListener{

    Button Calculate;
    TextField From,To;
    Label txtFrom,txtTo,txtResult,Result;
    Font font;
    int W,H;
    double a=0,b=0;
    Color black,red;
    
    public void init(){
        W=this.getWidth();
        H=this.getHeight();
        this.setBackground(new Color(200,200,200));
        black=new Color(0,0,0);
        red=new Color(255,0,0);
        Calculate=new Button("Calculate");
        From=new TextField("-1");
        To=new TextField("1");
        txtFrom=new Label("From:");
        txtTo=new Label("To:");
        txtResult=new Label("Result:");
        Result=new Label("                                ");
        this.add(txtFrom);
        this.add(From);
        this.add(txtTo);
        this.add(To);
        this.add(Calculate);
        this.add(txtResult);
        this.add(Result);
        Calculate.addActionListener(this);
       
    }
    
    public void paint(Graphics g){
        int basla=250;
        
        g.setColor(black);
        g.drawLine(1,202,500,202);
        
        for (double i=-4;i<4;i=i+.0005){
            g.drawLine(basla+(int)(i*50),200-(int)(f(i)*190),basla+(int)(i*50),200-(int)(f(i)*190));
        }
        g.setColor(red);
        for (double i=a;i<b;i=i+.0005){
            g.drawLine(basla+(int)(i*50),200-(int)(f(i)*190),basla+(int)(i*50),200);
        }
        g.drawLine(basla+(int)(a*50),200-(int)(f(a)*190),basla+(int)(a*50),200);
        g.drawLine(basla+(int)(b*50),200-(int)(f(b)*190),basla+(int)(b*50),200);
        
    }
    
    public void actionPerformed(ActionEvent e){
        a=Double.parseDouble(From.getText());
        b=Double.parseDouble(To.getText());
        double result=getArea(a,b);
        Result.setText(String.valueOf(result));
        repaint();
    }
   
    
    public double f(double x){
      return (((1/Math.sqrt(2*Math.PI))*Math.exp(-Math.pow(x,2)/2)));  
    }
    
    
    public double getArea(double a,double b){
        double step=0.000001;
        double toplam=0.0;
        for (double i=a-step;i<b+step;i=i+step){
            toplam=toplam+(step*2*f(i));
            i=i+step;
        }
        return toplam;
    }
    
    
}
