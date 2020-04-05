import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*<applet code="appy" width=300 height=300>
 * </applet>
 */
public class appy extends Applet implements ActionListener,ItemListener
{
    String msg="";
    String m1,m2,m3,m4;
    Button b1;
    Checkbox cb1,cb2;
    CheckboxGroup cbg;
    TextField txt1;
    TextArea t1;
    Choice c1;
    public void init()
    {
        setLayout(null);
        b1=new Button("ok");
        cbg=new CheckboxGroup();
        cb1=new Checkbox("indian");
        cb2=new Checkbox("other",cbg,true);
        txt1=new TextField(12);
        txt1.setEchoChar('%');
        t1=new TextArea();
        c1=new Choice();
        c1.add("hey");
        c1.add("hi");
        b1.addActionListener(this);
        cb1.addItemListener(this);
        cb2.addItemListener(this);
        txt1.addActionListener(this);
        c1.addItemListener(this);
        
        b1.setBounds(10,40,100,20);
        cb1.setBounds(120,40,100,20);
        cb2.setBounds(240,40,100,20);
        txt1.setBounds(10,90,100,20);
        t1.setBounds(10,150,100,50);
        c1.setBounds(10,210,100,20);
        add(b1);
        add(cb1);
        add(cb2);
        add(c1);
        add(txt1);
        add(t1);
        
        
                
    }
public void actionPerformed(ActionEvent ae)
{
    if(ae.getSource()==b1)
    {
        msg="ch"+cbg.getSelectedCheckbox().getLabel();
        m4=""+cb1.getLabel();
        m1=""+txt1.getText();
        m2=""+t1.getText();
        m3=""+c1.getSelectedItem();
        
    }
    repaint();
}
public void itemStateChanged(ItemEvent ie)
{
    repaint();
    
}
public void paint(Graphics g)
{
    g.drawString(msg,600,120);
     g.drawString(m1,700,120);
      g.drawString(m2,800,120);
       g.drawString(m3,900,120);
        g.drawString(m4,1000,120);
    
}
   
}
