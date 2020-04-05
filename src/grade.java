    import java.awt.*;
    import java.applet.*;
    import java.awt.event.*;
    import java.awt.Label;
    import java.text.DecimalFormat;

     public class grade extends Applet implements ActionListener{
      TextField txtprelim,txtmidterm,txtprefinal,txtendterm, txtfinal,txtremarks;
      Label lblprelim,lblmidterm,lblprefinal,lblendterm,lblfinal,lblremarks,title;
      Button button,clear;

 DecimalFormat dFormat = new DecimalFormat("0");
      public void init(){
        setLayout(null);


          title = new Label("Grade Solver 1.0");
		  title.setBounds(90,20,150,20);
		  add(title);
		  title.setAlignment(title.CENTER);

        lblprelim = new Label("Prelim Grade ");
        lblprelim.setBounds(20,50,100,20);
        add(lblprelim);

        txtprelim = new TextField(5);
        txtprelim.setBounds(150,50,100,20);
        add(txtprelim);

        lblmidterm = new Label("Midterm Grade");
        lblmidterm.setBounds(20,90,100,20);
        add(lblmidterm);

        txtmidterm = new TextField(5);
        txtmidterm.setBounds(150,90,100,20);
        add(txtmidterm);

        lblprefinal = new Label("Prefinal Grade");
        lblprefinal.setBounds(20,130,130,20);
        add(lblprefinal);
        txtprefinal = new TextField(5);
        txtprefinal.setBounds(150,130,100,20);
        add(txtprefinal);


        lblendterm = new Label("Endterm Grade");
        lblendterm.setBounds(20,170,130,20);
        add(lblendterm);
        txtendterm = new TextField(5);
        txtendterm.setBounds(150,170,100,20);
        add(txtendterm);


        lblfinal = new Label("Final Grade");
        lblfinal.setBounds(20,210,100,20);
        add(lblfinal);
        txtfinal = new TextField(5);
        txtfinal.setBounds(150,210,100,20);
        add(txtfinal);


		lblremarks = new Label("Remarks");
        lblremarks.setBounds(20,250,100,20);
        add(lblremarks);
        txtremarks = new TextField(5);
        txtremarks.setBounds(150,250,100,20);
        add(txtremarks);

        button = new Button(" Solve Grade ");
        button.setBounds(70,280,100,20);
        add(button);

		clear = new Button(" Clear ");
        clear.setBounds(230,280,100,20);
        add(clear);

        button.addActionListener(this);
        clear.addActionListener(this);


        }

        public void actionPerformed(ActionEvent ae)
        {

      double prelim =Double.parseDouble(txtprelim.getText());
      double midterm =Double.parseDouble(txtmidterm.getText());
  	  double prefinal =Double.parseDouble(txtprelim.getText());
      double endterm =Double.parseDouble(txtmidterm.getText());


      double pre = (prelim * 0.2);	  double pref = (prefinal * 0.2);
      double mid = (midterm * 0.2);   double endt = (endterm * 0.4);

      double compute_final_grade = (pre+mid+pref+endt);

       txtfinal.setBackground(Color.black);
       txtfinal.setForeground(Color.white);
       txtfinal.setText(dFormat.format(compute_final_grade));
       txtfinal.setEditable(false);

        if (compute_final_grade >= 75) {
			txtremarks.setBackground(Color.yellow);
			txtremarks.setForeground(Color.blue);
			txtremarks.setText("Passed");
		}
		 else{
		  txtremarks.setBackground(Color.yellow);
		   txtremarks.setForeground(Color.red);
			txtremarks.setText("Failed");
		}
         txtremarks.setEditable(false);

			if(ae.getSource() == clear)
			{
			 txtprelim.setText("");
			  txtmidterm.setText("");
			  txtprefinal.setText("");
			   txtendterm.setText("");
			   txtfinal.setText("");
			   txtremarks.setText("");
			   txtprelim.requestFocus();
    }
}
}