// calendar.java
// author: Mr. Jake Rodriguez Pomperada,MAED-Instructional Technology
// date  : January 3, 2009
// tool  : java

// Program Description:
//   I wrote this program to display the current calendar for the current
//   month and year using java. It is a great experience to learn how java
//   has many built in library to support date and time that is not available
//   to other programming language without using a third part library. I hope
//   this code will help somebody interested in java programming. If you
//   think this code help you send me an email at jakerpomperada@yahoo.com. 
//   Thank you very much and Happy Programming ;-D



import java.util.*;
import java.util.Calendar;

public class calendar
 {
 
  public static void main(String []args)
   {
    String[] monthName = {"JANUARY", "FEBRUARY",
            "MARCH", "APRIL", "MAY", "JUNE", "JULY",
            "AUGUST", "SEPTEMBER", "OCTOBER", "NOVERMBER",
            "DECEMBER"};
 
        Calendar cal = Calendar.getInstance();
        String months = monthName[cal.get(Calendar.MONTH)];
        int year = cal.get(Calendar.YEAR);

        System.out.println("\n"); 
        System.out.println("\t " + months + " " + year);
    
   GregorianCalendar d = new GregorianCalendar();
   
   int today = d.get(Calendar.DAY_OF_MONTH);
   int month = d.get(Calendar.MONTH);
   
   d.set(Calendar.DAY_OF_MONTH, 1);
   
   int weekday = d.get(Calendar.DAY_OF_WEEK);
   
   System.out.println("Sun Mon Tue Wed Thu Fri Sat");
   
   for (int i = Calendar.SUNDAY; i < weekday; i++)
       System.out.print("    ");
       
   do
   {
     int day = d.get(Calendar.DAY_OF_MONTH);
     
     if (day < 10) System.out.print(" ");
     System.out.print(day);
     
     if(day == today)
       System.out.print("* ");
     else 
       System.out.print("  ");
       
     if (weekday == Calendar.SATURDAY)
       System.out.println();
           
     d.add(Calendar.DAY_OF_MONTH, 1);
     weekday = d.get(Calendar.DAY_OF_WEEK);
     
     }
     
     while (d.get(Calendar.MONTH) == month);
     
     if (weekday != Calendar.SUNDAY)
       System.out.println();
  
        System.out.print("\n");
        System.out.print("\t\t===================================================== " );
        System.out.println("\n\t\t\t THANK YOU for USING this PROGRAM" ); 
        System.out.println("\t\t\t Program Coding & Design By: ");
        System.out.println("\t\t\t Jake Rodriguez Pomperada,MAED-IT " );
        System.out.print("\t\t===================================================== " );
        System.out.print("\n");     
   }
}



 
 
