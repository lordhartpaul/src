/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sunny
 */
import java.util.Scanner;
public class Emailvalidation {
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        String email_check="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        System.out.println("enter an email address");
        String email=s.nextLine();
        if(email.matches(email_check))
        {
            System.out.println("valid email");
            
        }
        else
        {
            System.out.println("invalid_email");
        }
    }

}
