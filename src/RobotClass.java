import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotClass {
    
    public static void main(String[] args) {
        
        try {
            
            Robot robot = new Robot();
            // Creates the delay of 5 sec so that you can open notepad before
            // Robot start writting
            try
            {
            
           Runtime.getRuntime().exec("notepad");
            }catch(Exception e)
            {
            	
            }
         //   System.out.println("User is" +System.getProperty("username"));
            robot.delay(5000);
            robot.keyPress(KeyEvent.VK_H);
            robot.keyPress(KeyEvent.VK_I);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyPress(KeyEvent.VK_H);
            robot.keyPress(KeyEvent.VK_I);
            robot.keyPress(KeyEvent.VK_S);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_I);
            robot.keyPress(KeyEvent.VK_S);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_S);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyPress(KeyEvent.VK_M);
            robot.keyPress(KeyEvent.VK_P);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyPress(KeyEvent.VK_E);
             robot.keyPress(KeyEvent.VK_ENTER);
             robot.keyPress(KeyEvent.VK_F5);
            
            
            
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}