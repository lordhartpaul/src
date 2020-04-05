//prac 1

package multhread;


public class simmultread implements Runnable {
Thread t;
String i;
 public   simmultread(String inc) {
     this.i=inc;
t=new Thread(this,i);
t.start();
}
    public static void main(String[] args) throws InterruptedException {
        simmultread a, b,c;   
       a= new simmultread("A");
       b= new simmultread("B");
       c= new simmultread("C");
       for(int i=0;i<15;i++){
            System.out.println(Thread.currentThread().getName().toString()+" is running")    ;
            try {
                Thread.sleep(100);
            } catch (Exception ex) {
               System.out.println("err");
            }
       }
       System.out.println(Thread.currentThread().getName().toString()+" is exiting")    ;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Thread "+Thread.currentThread().getName().toString()
                    +" is running")    ;
            try {
                Thread.sleep(100);
            } catch (Exception ex) {
               System.out.println("err");
            }
        }
        System.out.println("Thread "+Thread.currentThread().getName().toString()
                    +" is exiting")    ;
    }
}
