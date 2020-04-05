import java.awt.*;
import java.applet.*;
/*<applet code="grid"width=300 height=300>
</applet>
*/
public class grid extends Applet
{
 static final int n=4;
public void init()
{
setLayout(new GridLayout(n,n));
setFont(new Font("SansSerif",Font.BOLD,24));
for(int i=0;i<n;i++)
{
 for(int j=0;j<n;j++)
{
int k=i*n+j;
if(k>0)


add(new Button(""+k));



}
}
}
}