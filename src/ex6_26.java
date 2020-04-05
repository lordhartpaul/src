import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class ex6_26 extends Applet{
	TextArea ans = new TextArea("",10,25);
	int chk = 1,pctr=0;
	public void init() {
		Label title = new Label("Excercise 6.26 'Prime number' method");
		add(title);
		add(ans);
		prime();
	}
	public void prime() { 
			for(long ctr=10000;ctr>=1;ctr--)
			{
				for(long ctr2=ctr-1;ctr2>1;ctr2--)
					{
						if(ctr%ctr2==0)
						{
							chk=0;
						}
					}
				if (chk==1)
				{
					ans.insert("\n"+ctr,0);
					pctr++;
				}
				chk=1;
			}
		ans.insert("\nThere are "+pctr+" Prime numbers.",0);
		ans.insert("Prime numbers from 1-10,000",0);
	}
}
