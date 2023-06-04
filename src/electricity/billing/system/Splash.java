
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
public class Splash  extends JFrame implements Runnable{
    Thread t;
    Splash(){
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2= i1. getImage().getScaledInstance(730,550,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        add(image);
        setVisible(true);
        
        for(int i=1;i<5;i++){
        setSize(2*i,i);
        setLocation(400,150);
        try {
            Thread.sleep(2);
        } catch(Exception e){
          e.printStackTrace();
    }
      t=new Thread(this);
      t.start();
      setSize(730,550) ;
      setLocation(400,150);
      setVisible(true);
    }
    }
        public void run(){
            try{
                Thread.sleep(7000);
                setVisible(false);
                //login frame 
                new Login();
            }catch(Exception e){
                e.printStackTrace();
            }
        }


    
   public static void main(String[]args) {
       new Splash ();
   }
}

    

