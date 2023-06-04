
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Bkash extends JFrame implements ActionListener {
    String meter;
   Bkash(String meter){
       this.meter= meter;
       
       JEditorPane j = new JEditorPane();
       j.setEditable(false);
       
       try{
         j .setPage("https://nagad.com.bd/");
       }catch(Exception e){
           e.printStackTrace();
           j.setContentType("text/html");
           j.setText("<html> Could not found <html>");
           
       
       }
       JScrollPane pane = new JScrollPane(j);
       add(pane);
       setSize(800,600);
       setLocation(400,150);
       setVisible(true);
   }    
   
   public void actionPerformed(ActionEvent ae){
       
   }
    
    public static void main(String[]args){
        new Bkash("");
    }
}
