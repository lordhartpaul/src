import java.util.Calendar;
class calendardemo{
public static void main(String args[])
{
String months[]={"Jan","Feb","March","April","May","June","July","August","September","October","November","December"};
Calendar calendar=Calendar.getInstance();
System.out.print("Date:");
System.out.print(months[calendar.get(Calendar.MONTH)]);
System.out.print(" "+calendar.get(Calendar.DATE)+" ");
System.out.print(calendar.get(Calendar.YEAR));
}
}
