// RandomNumbers.java
// This applet simply prints out a series of random numbers between 0 and 1

// Written by Julian Devlin, 8/97, for the text book
// "Introduction to Probability," by Charles M. Grinstead & J. Laurie Snell

// Packages we need
import java.awt.*;
import java.applet.Applet;
import java.util.Random;


public class RandomNumberss extends Applet
{
	TextArea disp;		// Area to display random numbers
	
	Panel contp;		// Panel for user controls
	
	Label numl;			// Controls
	TextField num;
	Button go;
	
	Random randGen;		// Random number generator
	
	// Initialize applet
	public void init()
	{	
		numl = new Label("No.");			// Create controls
		num = new TextField("100", 4);
		go = new Button("Go");
		
		contp = new Panel();				// Set up control panel
		contp.add(numl);					
		contp.add(num);
		contp.add(go);
		contp.setLayout(new FlowLayout());
		
		disp = new TextArea(20, 30);		// Create display area
		
		resize(500,400);					// Set up applet
		setLayout(new FlowLayout());
		add(disp);
		add(contp);
		
		validate();
		
		randGen = new Random();			// Create random number generator
	}
	
	// Handle events
	public boolean handleEvent(Event evt)
	{
		if (evt.target instanceof Button)
		{
			if (evt.target == go && evt.id == Event.ACTION_EVENT)	
					// When button is clicked
			{
				disp.setText("");			// Reset output window
        		generate(Integer.valueOf(num.getText()).intValue());
        		return true;		// Generate correct number of random floats				
											
			}
		}
		return super.handleEvent(evt);	// Handle other events as usual
	}
	
	// Generate n random floats from 0 to 1, and print them in the disp area
    public void generate(int n)
    {
    	float randFloat;
    	for(int i = 0; i < n; i++)
    	{
    		randFloat = randGen.nextFloat();
    		disp.appendText(Float.toString(randFloat));
    		if(i%3 == 2)
    			disp.appendText("\n");
    		else
    			disp.appendText("	");
    	}
	}
	
}

