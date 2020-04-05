   import javax.swing.*;   
   public class Sine extends GraphFormula {
      private double aa0, aa1, aa2, aa3, xmin, xmax;
   
      public Sine(){
         super( 0, 2, 1, 1, 0, 0);
         aa0 = 1; aa1 = 1; aa2 = 0;
      }
      public Sine( double xMinim, double xMaxim, double a0, double a1, double a2){
         super( xMinim, xMaxim, a0, a1, a2, 0 );
         aa0 = a0;
         aa1 = a1;
         aa2 = a2;
         xmin = xMinim;
         xmax = xMaxim;
      }
      public Sine( double xMinim, double xMaxim, double a0, double a1, double a2, double a3){
         super( xMinim, xMaxim, a0, a1, a2, 0 );
         aa0 = a0;
         aa1 = a1;
         aa2 = a2;
         xmin = xMinim;
         xmax = xMaxim;
      
      }
      public Graph setNew( double a, double b, double c, double d ){
         return new Sine( xmin, xmax, a, b, c, d);
      }
   
      public String writeFormulaBn() { 
         return " "+aa0 + " sin( " + aa1 + "x  +  " + aa2 + " )";} 
   
      public double Fx(double x)
      {  
         return aa0*Math.sin( aa1* x + aa2);
      
      }
   
      public GraphFormula formulaBnEvent() {
         String a3$, a2$, a1$, a0$;
         try{
            a0$ = JOptionPane.showInputDialog( "<html><p color = \"0000ff\"><b><font color = \"ff0000\"> a </font> sin( bx + c )<br>Sine: y = <font color = \"ff0000\">"+aa0 +"</font> sin( "+aa1+"x + "+aa2 + " )<br>  Change the value of <font color = \"ff0000\">a</font> to:</b></p></html>");
            if ( ! a0$.equals("") ) aa0 = Double.valueOf(a0$).doubleValue();
            a1$ = JOptionPane.showInputDialog(  "<html><p color = \"0000ff\"><b> a sin(<font color = \"ff0000\"> b</font>x + c )<br>Sine: y = "+aa0 +" sin( <font color = \"ff0000\"> "+aa1+"</font>x + "+aa2 + " )<br>  Change the value of <font color = \"ff0000\">b</font> to:</b></p></html>");
            if ( ! a1$.equals("") ) aa1 = Double.valueOf(a1$).doubleValue();
            a2$ = JOptionPane.showInputDialog(  "<html><p color = \"0000ff\"><b> a sin( bx + <font color = \"ff0000\">c</font> )<br>Sine: y = "+aa0 +" sin( "+aa1+"x + <font color = \"ff0000\">"+aa2 + "</font> )<br>  Change the value of <font color = \"ff0000\">c</font> to:</b></p></html>");
            if ( ! a2$.equals("") ) aa2 = Double.valueOf(a2$).doubleValue(); 
         }
            catch ( NumberFormatException nfe ) { 
               JOptionPane.showMessageDialog( null, "You must input a number!\nTry Again",
                  "Invalid NumberFormatException", JOptionPane.ERROR_MESSAGE ); 
             //  return new Sine( xmin, xmax, 0, 0, 0, 0);            
            }         
         return  new Sine( xmin, xmax, aa0, aa1, aa2, 0);
      
      }  
   }
