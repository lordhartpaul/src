import java.awt.*;
   import java.applet.*;
    import java.awt.event.*;
    import java.awt.Label;
/*
<applet code="add"width=300 height=300>
</applet>
*/
    public class add extends Applet implements ActionListener{
      TextField text1,text2,output;
      Label label1,label2,label3,title;
      Button button,clear;
      public void init(){
        setLayout(null);


          title = new Label("Addition of Two Numbers");
		  title.setBounds(80,10,140,20);
		  add(title);
		  title.setAlignment(title.CENTER);

        label1 = new Label("Enter Number 1: ");
        label1.setBounds(20,50,100,20);
        add(label1);

        text1 = new TextField(5);
        text1.setBounds(150,50,100,20);
        add(text1);

        label2 = new Label("Enter Number 2: ");
        label2.setBounds(20,90,100,20);
        add(label2);

        text2 = new TextField(5);
        text2.setBounds(150,90,100,20);
        add(text2);

        label3 = new Label("Sum of Two Numbers: ");
        label3.setBounds(20,130,130,20);
        add(label3);

        output = new TextField(5);
        output.setBounds(150,130,100,20);
        add(output);

        button = new Button("Sum");
        button.setBounds(150,170,100,20);
        add(button);

		clear = new Button("Clear");
        clear.setBounds(280,170,100,20);
        add(clear);

        button.addActionListener(this);
        clear.addActionListener(this);


        }
        public void actionPerformed(ActionEvent ae){
        int num1=Integer.parseInt(text1.getText());
        int num2=Integer.parseInt(text2.getText());
        int sum=num1+num2;
       
			if(ae.getSource() == clear)
			{
				 text1.setText("");
			  text2.setText("");
			   output.setText("");
			   text1.requestFocus();
    }
        else if(ae.getSource()==button)
        {
                        try
                        {
                            
                                 
                             output.setText(Integer.toString(sum));
                        
                        }
                        catch(Exception e)
                        {
                            
                        }
        }              
}
}
