
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java .util.*;
import java.awt.event.*;

public class NewCustomer extends JFrame implements ActionListener {
 JTextField tfname,tfaddress,tfstate,tfcity,tfemail,tfphone; 
 JButton next,cancel;
 JLabel Iblmeter;
    
    NewCustomer(){
      setSize (700,500);
      setLocation(400,200);
      setVisible(true);
      
      JPanel P= new JPanel();
      P.setLayout(null);
      P.setBackground(new Color(173,216,230));
      add(P);
      
      JLabel heading = new JLabel("New Customer");
      heading.setBounds(180,10,200,25);
      heading.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(heading);
      
      JLabel Iblname= new JLabel(" Customer  Name");
      Iblname.setBounds(100,80,100,20);
      //Iblname.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblname);
      
      
      tfname=new JTextField();
      tfname.setBounds(240,80, 200,20);
      P.add(tfname);
     
      JLabel Iblmeterno= new JLabel("Meter Number");
     Iblmeterno.setBounds(100,120,100,20);
     // Iblmeterno.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblmeterno);
      
      
       Iblmeter= new JLabel("");
     Iblmeter.setBounds(240,120,100,20);
      //Iblmeter.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblmeter);
      
      Random ran =new Random();
      Long number= ran.nextLong() %1000000;
      Iblmeter.setText(""+ Math.abs( number));
 
      JLabel Ibladdress= new JLabel("Address");
      Ibladdress.setBounds(100,160,100,20);
     // Ibladdress.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Ibladdress);
      
      
      tfaddress=new JTextField();
      tfaddress.setBounds(240,160,200,20);
      P.add(tfaddress);
      
       JLabel Iblcity= new JLabel(" City");
      Iblcity.setBounds(100,200,100,20);
      //Iblname.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblcity);
      
      
      tfcity=new JTextField();
      tfcity.setBounds(240,200,200,20);
      P.add(tfcity);
      
       JLabel Iblstate= new JLabel("State");
      Iblstate.setBounds(100,240,100,20);
      //Iblname.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblstate);
      
      
      tfstate=new JTextField();
      tfstate.setBounds(240,240,200,20);
      P.add(tfstate);
      
       JLabel Iblemail= new JLabel(" Email  Name");
      Iblemail.setBounds(100,280,100,20);
      //Iblname.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblemail);
      
      
      tfemail=new JTextField();
      tfemail.setBounds(240,280,200,20);
      P.add(tfemail);
      
       JLabel Iblphone= new JLabel("Phone Number");
      Iblphone.setBounds(100,320,100,20);
      //Iblname.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblphone);
      
      
      tfphone=new JTextField();
      tfphone.setBounds(240,320,200,20);
      P.add(tfphone);
      
      
      next= new JButton("Next");
      next.setBounds(120,390,100,25);
      next.setBackground(Color.BLACK);
      next.setForeground(Color.WHITE);
      next.addActionListener(this);
      P.add(next);
      
       cancel= new JButton("Cancel");
      cancel.setBounds(250,390,100,25);
      cancel.setBackground(Color.BLACK);
     cancel.setForeground(Color.WHITE);
     cancel.addActionListener(this);
      P.add(cancel);
      
      setLayout(new BorderLayout());
      
      add(P,"Center");
      
      ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
      Image i2= i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
      ImageIcon i3= new ImageIcon(i2);
      JLabel image= new JLabel(i3);
      add(image,"West");
      
      getContentPane().setBackground(Color.WHITE);
      setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== next){
            
            String name = tfname.getText();
            String meter =Iblmeter.getText();
            String address =tfaddress.getText();
            String city=tfcity.getText();
            String state=tfstate.getText();
            String email= tfemail.getText();
            String phone=tfphone.getText();
            
            String query1= "insert into Customer values('"+name+"','"+meter+"', '"+address+"','"+city+"','"+state+"','"+email+"','"+phone+"')";
            String query2="insert into login values('"+meter+"',' ', '"+name+"',' ', ' ')";
            try{
               Conn c= new Conn() ;
               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);
               
               JOptionPane.showMessageDialog(null,"Customer Details Added Succesfully");
               setVisible(false);
               
               new MeterInfo(meter);
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
           setVisible(false) ;
        }
    }
    public static void main(String[] args){
        new NewCustomer();
    }
}


