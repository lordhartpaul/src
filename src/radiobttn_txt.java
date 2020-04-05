import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*<applet code="radiobttn_txt"width=300 height=300>
</applet>
*/
public class radiobttn_txt extends JApplet implements ActionListener
{
JTextField tf;
public void init()
{
Container contentPane=getContentPane();
contentPane.setLayout(new FlowLayout());
JRadioButton b1=new JRadioButton("A");
b1.addActionListener(this);
contentPane.add(b1);
JRadioButton b2=new JRadioButton("B");
b2.addActionListener(this);
contentPane.add(b2);
ButtonGroup bg=new ButtonGroup();
bg.add(b1);
bg.add(b2);
tf=new JTextField(5);
contentPane.add(tf);
}
public void actionPerformed(ActionEvent ae)
{
tf.setText(ae.getActionCommand());
}
}