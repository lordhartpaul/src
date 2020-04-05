import java.awt.event.KeyEvent;
import java.io.*;
import java.net.Socket;

public class client extends javax.swing.JFrame {
public static  String  msgin, msgout,disp;
public Thread recv;
public static  Socket clientSocket;
public static  BufferedReader inFromServer;
public static  PrintWriter outToServer;     
    public client()  {
        initComponents();
        disp="";    
          }
//generated code..
    private void chatKeyPressed(java.awt.event.KeyEvent evt) {                                
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
      update () ;
        }
    }                               
    private void sendMouseClicked(java.awt.event.MouseEvent evt) {                                  
        update () ;
    }

    public void update() {
        disp+=chat.getText()+"\n";
        msgout=chat.getText();
        chat.setText("");
        status.setText(disp);
         outToServer.println (msgout) ;
    }                                 
    private void connectActionPerformed(java.awt.event.ActionEvent evt) {                                        
        recv=new Thread(){
        public void run(){
            while(true){
                 try {     
				clientSocket = new Socket("localhost", 5000);
				outToServer = new PrintWriter(clientSocket.getOutputStream(),true);
				inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				disp+="client is connected to server at port 5000\n";
				status.setText(disp);
				} catch (IOException ex) {
				System.out.println("error");
				}
            while(true){
				try {
				msgin=inFromServer.readLine();
				disp+=msgin;
				update();
			} catch (IOException ex) {
			System.out.println("error 1");
        }}}}};
    recv.start();
    }                                       
    public static void main(String args[]) throws IOException, InterruptedException {
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                client x=new client();
                x.setVisible(true);
                x.setTitle("client");
                
            }
        });      
      }
    // Variables declaration - do not modify                     
    private static javax.swing.JTextField chat;
    public javax.swing.JButton connect;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton send;
    private javax.swing.JLabel stat;
    public javax.swing.JTextArea status;
    // End of variables declaration                   
}
