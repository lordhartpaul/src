import java.io.*;
import javax.swing.JOptionPane;

class user_info {


String name,course,address,text;

 void display()
 {
	 text = "Student Record has been Saved.";
	 JOptionPane.showMessageDialog(null,text,
	"Student Report",JOptionPane.INFORMATION_MESSAGE);
	 System.exit(0);

}


}

class user {

	public static void main(String args[]){


        String text;

      PrintWriter  output = null;

  try {

		output = new PrintWriter(new FileOutputStream("write.txt"));


      user_info stud = new user_info();

      stud.name =  JOptionPane.showInputDialog(
	              "Enter Student Name  ");

      stud.course =  JOptionPane.showInputDialog(
	              "Enter Student Course  ");

      stud.address =  JOptionPane.showInputDialog(
	              "Enter Student Address  ");


      output.println("Name      : "+ stud.name);
      output.println("Course    : " + stud.course);
      output.println("Address   : " + stud.address);
      output.close();

    stud.display();

} catch(IOException ex) {
	ex.printStackTrace();
   }

   }

}


