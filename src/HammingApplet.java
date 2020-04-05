/**
*Demonstrates Hamming encoding/decoding
*/
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class HammingApplet extends Applet
{
	
		private Panel superp;
		private Panel p;
		private Panel q;
		private Panel p2;
		private Panel q2;
		private Button encode;
		private Button pcheck;
		private TextField inputwords;
		private String input;
		private GridBagConstraints gbc;
			
		public void init(){
			superp=new Panel();
			p= new Panel();
			q= new Panel();
			p2= new Panel();
			q2= new Panel();
			superp.setLayout(new GridBagLayout());
			p.setLayout(new GridBagLayout());
			q.setLayout(new GridBagLayout());
			p2.setLayout(new GridBagLayout());
			q2.setLayout(new GridBagLayout());
			gbc= new GridBagConstraints();
						gbc.gridx=0;
						gbc.fill=GridBagConstraints.NONE;
						gbc.anchor=GridBagConstraints.WEST;
			this.add(superp);
			gbc.gridy=0;
			superp.add(p,gbc);
			gbc.gridy=1;
			superp.add(q, gbc);
			gbc.gridy=2;
			superp.add(p2, gbc);
			gbc.gridy=3;
			superp.add(q2,gbc);
			superp.invalidate();
			superp.validate();
			gbc.gridy=0;
			p.add(new Label("enter word here:"),gbc);
			inputwords= new TextField(6);
			gbc.gridy=1;
			p.add(inputwords, gbc);
			
	encode= new Button("encode");
				encode.setSize(2,6);
				encode.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						q.removeAll();
						String input=inputwords.getText();
					if((inputwords.getText()).length()>6)
						input=(inputwords.getText()).substring(0,6);
					if(input.length()<6)
					{
						for(int t=6-input.length(); t>0; t--)
							input+=" ";
					}
					Integer[] iarray= Translator.toIntegerArray(input);
					
					gbc.gridy=0;
					q.add(new Label("binary version of input word:"), gbc);
					String bversion="";
					Integer[] iarray2=new Integer[iarray.length*6];
					int cur=0;
					for(int i=0; i<iarray.length; i++){
						int[] bnumbers= new int[6];
						int num= iarray[i].intValue();
						int spot=0;
						for(int j=5; j>=0; j--){
						if(power(2, j)<=num){
										bnumbers[spot]=1;
										num=num-power(2,j);
										spot++;
									}
						else{
							bnumbers[spot]=0;
							spot++;
						}
						}
						for(int k=0; k<bnumbers.length;k++){
						bversion+=bnumbers[k]+"";
						iarray2[cur]=new Integer(bnumbers[k]);
						cur++;
						}
					}
					gbc.gridy=1;
					q.add(new TextField(bversion),gbc);
					ffVector[] encoder=new ffVector[iarray2.length/4];
					
					for(int i=0; i<encoder.length; i++){
						encoder[i]=(new ffVector(2, 4));
					}
					int place=0;
					for(int j=0; j<encoder.length;j++){
						for(int k=0; k<encoder[j].size(); k++){
							encoder[j].setElementAt((iarray2[place]), k);
							place++;
						}
					}
					ffVector[] codewords= HammingCode.encode(encoder);
					gbc.gridy=2;
					q.add(new Label("codewords in Hamming Code(4,7): (make your own errors)"),gbc);
					for(int y=0; y<codewords.length; y++){
						String out="";
						for(int h=0; h<codewords[y].size();h++){
							out+=((Integer)codewords[y].elementAt(h)).intValue()+"";
						}
						gbc.gridy=3+y;
						q.add(new TextField(out),gbc);	
						pcheck.enable();
					}
					superp.invalidate();
					q.invalidate();
					p.invalidate();
					p2.invalidate();
					q2.invalidate();
					invalidate();
					superp.validate();
					p.validate();
					validate();
					}
				});
			gbc.gridy=3;
				p.add(encode, gbc);
				superp.invalidate();
				p.invalidate();
				superp.validate();
				validate();
	pcheck= new Button("parity check");
			pcheck.setBounds(0,0,20,60);
						pcheck.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e) {
								q2.removeAll();
								String[] inputblocks= new String[9];
								for(int i=0; i<inputblocks.length; i++){
										inputblocks[i]=((TextField)q.getComponent(i+3)).getText();										
									}
								ffVector[] forpcheck= new ffVector[9];
								for(int i=0; i<forpcheck.length;i++){
									forpcheck[i]=(new ffVector(2, 7));
								}
								for(int j=0; j<forpcheck.length; j++){
									for(int k=0; k<forpcheck[k].size();k++){
										forpcheck[j].setElementAt(new Integer(inputblocks[j].charAt(k)+""), k);
									}
								}
								int errorplace=HammingCode.parityCheck(forpcheck);
								if(errorplace==-1){
							
								gbc.gridy=0;
									q2.add(new Label("no errors"), gbc);
									}
								else{
									gbc.gridy=0;
									q2.add(new Label("there is an error in block "+ (10-errorplace)),gbc);
									System.out.print(10-errorplace);
								}
								q2.invalidate();
								q2.validate();
								}					
								});
			gbc.gridy=0;
								p2.add(pcheck,gbc);
								p2.invalidate();
								p2.validate();
								superp.invalidate();
								superp.validate();
								pcheck.disable();
								validate();
							
}
private int power(int base, int exp){
		int returner= 1;
		for(int i= exp; i>0; i--){
			returner= returner*base;
		}
		return returner;
	}
}
