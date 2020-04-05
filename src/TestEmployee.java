/* TestEmployee.java : test the following subclasses
 *						
 *	Admin.class
 *	Doctor.class
 *	Nurse.class
 *	Receptionist.class
 *	Surgeon.class
 *
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
/**
 * This class is use to test employees.
 */
public class TestEmployee extends JFrame implements ActionListener {	
	
	//GUI Components
	JFrame displayFrame;
		   
	JButton createButton,
			inheritButton,
			abstractButton,
			privateButton,
			quitButton;
	
	JLabel createLabel,
		   inheritLabel,
		   abstractLabel,
		   privateLabel,
		   bigLabel,
		   quitLabel;
	
	JPanel leftPanel,
		   rightPanel,
		   createPanel,
		   inheritPanel,
		   abstractPanel,
		   privatePanel,
		   quitPanel;
		   
	JTextArea displayTextArea;


	/**
	 * Constructor to initialize GUIs
	 */
	public TestEmployee() {

		displayFrame = new JFrame("Test Employee Classes");
		displayFrame.getContentPane().setLayout(new BorderLayout(20,20));
		
		createPanel = new JPanel();
		createPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		inheritPanel = new JPanel();
		inheritPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		abstractPanel = new JPanel();
		abstractPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		privatePanel = new JPanel();
		privatePanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		quitPanel = new JPanel();
		quitPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(5,1,10,10));
		
		rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		
		createButton = new JButton("Create Objects");
		inheritButton = new JButton("Inherited Methods");
		abstractButton = new JButton("Abstract Methods");
		privateButton = new JButton("Private Methods");
		quitButton = new JButton("Exit");
		
		// Registering listeners to buttons
		createButton.addActionListener(this);
		inheritButton.addActionListener(this);
		abstractButton.addActionListener(this);
		privateButton.addActionListener(this);
		quitButton.addActionListener(this);
				
		createLabel = new JLabel("Click to Create objects from the " +
								 "hospital classes.");		
		inheritLabel = new JLabel("Click to execute methods inherited " +
								 "from the Employee class.");
		abstractLabel = new JLabel("Click to execute abstract method " +
								 "of Employee class.");
		privateLabel = new JLabel("Click to execute object class methods.");
		quitLabel = new JLabel("Click to end testing.");

		
		bigLabel = new JLabel("Testing Hospital Employee Classes ...");
		bigLabel.setForeground(Color.red);
		bigLabel.setFont(new Font("", Font.BOLD, 24));
		
		displayTextArea = new JTextArea ("Welcome! Click on Buttons to " + 
										 "commence TEST",10,30);
		displayTextArea.setFont(new Font("",Font.BOLD,12));				 
		
		rightPanel.add(displayTextArea, BorderLayout.CENTER);

		createPanel.add(createButton);
		createPanel.add(createLabel);
		inheritPanel.add(inheritButton);
		inheritPanel.add(inheritLabel);
		abstractPanel.add(abstractButton);
		abstractPanel.add(abstractLabel);
		privatePanel.add(privateButton);
		privatePanel.add(privateLabel);
		quitPanel.add(quitButton);
		quitPanel.add(quitLabel);
		
		leftPanel.add(createPanel);
		leftPanel.add(inheritPanel);
		leftPanel.add(abstractPanel);
		leftPanel.add(privatePanel);
		leftPanel.add(quitPanel);
		
		displayFrame.getContentPane().add(bigLabel, BorderLayout.NORTH);
		displayFrame.getContentPane().add(leftPanel, BorderLayout.WEST);
		displayFrame.getContentPane().add(rightPanel, BorderLayout.EAST);
		
	}

	public void launchApp() {
		
		displayFrame.pack();

		// Centering the screen on the desktop
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = displayFrame.getSize();
		displayFrame.setLocation(((screenSize.width - frameSize.width) / 2),
							((screenSize.height - frameSize.height) / 2));		

		inheritButton.setVisible(false);
		inheritLabel.setVisible(false);
		abstractButton.setVisible(false);
		abstractLabel.setVisible(false);
		privateButton.setVisible(false);
		privateLabel.setVisible(false);


		displayFrame.setVisible(true);

	}

	/**
	 * The driver program
	 */
	public static void main(String args[]) {
		
		TestEmployee testEmployee = new TestEmployee();
		testEmployee.launchApp();
	}// End of main method
	
	/**
	 * Trapped user button events
	 */
	public void actionPerformed(ActionEvent e) {
		
		Admin adm1 = new Admin("John Lee",'M',18,4000,"Assunta Hospital");
		Surgeon sug1 = new Surgeon("Yat Seng",'M',19,2000);
		Doctor doc1 = new Doctor("Terrence",'M',18,2500);
		Doctor doc2 = new Doctor("Kenny",'M',21,2700);
		Doctor doc3 = new Doctor("Alvan",'M',18,2600);
		Nurse nur1 = new Nurse("Su Yean",'F',20,1400,doc1.getName());
		Nurse nur2 = new Nurse("Janice",'F',18,1300,doc2.getName());
		Nurse nur3 = new Nurse("Arvinder",'F',21,1500,doc1.getName());
		Receptionist rec1 = new Receptionist("Amyra",'F',20,1200);
		
		// Create Objetcs
		if (e.getSource() == createButton) {

			displayTextArea.setText("");
			displayTextArea.append(adm1.getStatus());
			displayTextArea.append(sug1.getStatus());
			displayTextArea.append(doc1.getStatus());
			displayTextArea.append(doc2.getStatus());
			displayTextArea.append(doc3.getStatus());
			displayTextArea.append(nur1.getStatus());
			displayTextArea.append(nur1.getStatus());
			displayTextArea.append(nur3.getStatus());
			displayTextArea.append(rec1.getStatus());
			
			createButton.setVisible(false);
			createLabel.setVisible(false);
			
			inheritButton.setVisible(true);
			inheritButton.requestFocus();
			inheritLabel.setVisible(true);	
		}

		// Test inherited class methods
		if (e.getSource() == inheritButton) {

			displayTextArea.setText("");
			displayTextArea.append(adm1.getDetails());
			displayTextArea.append(sug1.getDetails());
			displayTextArea.append(doc1.getDetails());

			inheritButton.setVisible(false);
			inheritLabel.setVisible(false);
			
			abstractButton.setVisible(true);
			abstractButton.requestFocus();
			abstractLabel.setVisible(true);	
		}

		if (e.getSource() == abstractButton) {

			displayTextArea.setText("");
			displayTextArea.append(adm1.performJob());
			displayTextArea.append(doc1.performJob());
			displayTextArea.append(sug1.performJob());
			displayTextArea.append(nur1.performJob());
			displayTextArea.append(rec1.performJob());

			abstractButton.setVisible(false);
			abstractLabel.setVisible(false);
			
			privateButton.setVisible(true);
			privateButton.requestFocus();
			privateLabel.setVisible(true);	
		}

		if (e.getSource() == privateButton) {

			displayTextArea.setText("");
			displayTextArea.append(adm1.adminOf());
			displayTextArea.append(adm1.declareHoliday(15));
			displayTextArea.append(nur1.tidyRoom());
			displayTextArea.append(nur1.doctorOf());
			displayTextArea.append(nur2.doctorOf());
			displayTextArea.append(sug1.addSkill("Brain"));
			displayTextArea.append(sug1.addSkill("Eye"));
			displayTextArea.append(doc1.curePatient());
			displayTextArea.append(rec1.handleEnquiry());
			displayTextArea.append(rec1.cancelAppointment("Khairul"));

			privateButton.setVisible(false);
			privateLabel.setVisible(false);
			
			quitButton.requestFocus();
		}
		
		if (e.getSource() == quitButton) {
			System.exit(0);
		}
	}// End of ActionPerformed method
} // End of TestEmployee class

// This class serves as a template for employee creation
abstract class Employee {
	
	// Employee attributes
	protected String empName;
	protected char empGender;
	protected int empAge;
	protected double empSalary;
	
	
	// Method to get all employee details
	public String getDetails() {
		return("\tName   : " + empName +
			   "\n\tGender : " + empGender +
			   "\n\tAge    : " + empAge +
			   "\n\tSalary : " + empSalary + "\n");
	}
	
	/**
	 * Method to get employee's Name
	 */
	public String getName() {
		return(empName);
	}

	/**
	 * Method to get employee's Gender
	 */
	public char getGender() {
		return(empGender);
	}

	/**
	 * Method to get employee's Age
	 */
	public int getAge() {
		return(empAge);
	}

	/**
	 * Method to get employee's Salary
	 */
	public double getSalary() {
		return(empSalary);
	}
	
	/**
	 * Abstract method for employee to carry out their duty
	 */
	public abstract String performJob();

}// End of Employee class

/**
 * This is the Administrator job class
 */
class Admin extends Employee {
	
	// Private attributes of a Administrator
	private String hospitalName;
	
	/**
	 * Constructor used to initialize the new Administrator created
	 */
	public Admin(String name, char gender, int age, double salary, String hospital) {
		
		empName = name;
		empGender = gender;
		empAge = age;
		empSalary = salary;
		hospitalName = hospital;
		
	}

	/**
	 * Method to get the hired status for employee
	 */
	 public String getStatus() {
		return("Admin " + empName + " has been hired for " + hospitalName + ".\n");	 	
	 }

	/**
	 * Method for employee to perform their duty
	 */
	public String performJob() { 
		return("Admin " + empName + " manages daily paper work.\n");
	}
	
	/**
	 * Method for Admin to cheer up employees
	 */
	public String declareHoliday(int day) {
		return("Admin " + empName + " declares " + day + " day(s) "+
			   "holiday for all employees.\n");
	}
	
	/**
	 * Method to check the hospital the admin is managing
	 */
	public String adminOf() {
		return("Admin " + empName + " manages Hospital " + hospitalName + ".\n");
	}
}// End of class Admin

/**
 * This is the Doctor job class
 */
class Doctor extends Employee {
	
	/**
	 * Constructor used to initialize the new Doctor created
	 */
	public Doctor(String name, char gender, int age, double salary) {
		
		empName = name;
		empGender = gender;
		empAge = age;
		empSalary = salary;	
	}


	/**
	 * Method to get the hired status for employee
	 */
	 public String getStatus() {
		return("Doctor " + empName + " has been hired.\n");	 	
	 }

	/**
	 * Method for employee to perform their duty
	 */
	public String performJob() { 
		return("Doctor " + empName + " examines a patient.\n");
	}
	
	/**
	 * Method for doctors to cure patients
	 */
	public String curePatient() {
		return("Doctor " + empName + " has just cured a patient.\n");
	}
}// End of class Doctor

/**
 * This is the Nurse job class
 */
class Nurse extends Employee {
	
	// Private attributes of a Nurse
	private String doctorName;
	
	/**
	 * Constructor used to initialize the new Nurse created
	 */
	public Nurse(String name, char gender, int age, double salary, String doctor) {
		
		empName = name;
		empGender = gender;
		empAge = age;
		empSalary = salary;
		doctorName = doctor;
	}

	/**
	 * Method to get the hired status for employee
	 */
	 public String getStatus() {
		return("Nurse " + empName + " has been hired.\n");	 	
	 }

	/**
	 * Method for employee to perform their duty
	 */
	public String performJob() { 
		return("Nurse " + empName + " takes care of a patient.\n");
	}
	
	/**
	 * Method for nurse to tidy up a patient's room
	 */
	public String tidyRoom() {
		return("Nurse " + empName + " cleans up a bed.\n");
	}
	
	/**
	 * Method to find out which doctor the nurse is an assistant of
	 */
	public String doctorOf() {
		return("Nurse " + empName + " is an assistant of Doctor "
				+ doctorName + ".\n");
	}
}// End of class Nurse

/**
 * This is the Receptionist job class
 */
class Receptionist extends Employee {
	
	/**
	 * Constructor used to initialize the new Receptionist created
	 */
	public Receptionist(String name, char gender, int age, double salary) {
		
		empName = name;
		empGender = gender;
		empAge = age;
		empSalary = salary;		
	}

	/**
	 * Method to get the hired status for employee
	 */
	 public String getStatus() {
		return("Receptionist " + empName + " has been hired.\n");	 	
	 }

	/**
	 * Method for employee to perform their duty
	 */
	public String performJob() { 
		return("Receptionist " + empName + " schedules an appointment.\n");
	}
	
	/**
	 * Method for receptionist to cancel an appointment
	 */
	public String cancelAppointment(String patient) {
		return("Receptionist " + empName + " cancels and appointment with " +
			   "patient " + patient + ".\n");
	}
	
	/**
	 * Method for receptionist to handle enquiries
	 */
	public String handleEnquiry() {
		return("Receptionist " + empName + " has just handled a customer enquiry.\n");
	}
}// End of class Receptionist

/**
 * This is the Surgeon job class
 */
class Surgeon extends Employee {
	
	/**
	 * Constructor used to initialize the new Surgeon created
	 */
	public Surgeon(String name, char gender, int age, double salary) {
		
		empName = name;
		empGender = gender;
		empAge = age;
		empSalary = salary;
	}

	/**
	 * Method to get the hired status for employee
	 */
	 public String getStatus() {
		return("Surgeon " + empName + " has been hired.\n");	 	
	 }

	/**
	 * Method for employee to perform their duty
	 */
	public String performJob() { 
		return("Surgeon " + empName + " performs an intricate surgery.\n");
	}
	
	/**
	 * Method for Surgeon to learn new surgery skills
	 */
	public String addSkill(String skill) {
		return("Surgeon " + empName + " learn new ways in operating " + 
			   skill + ".\n");
	}
}// End of class Surgeon