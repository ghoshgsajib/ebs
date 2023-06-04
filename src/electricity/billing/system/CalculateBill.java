
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java .util.*;
//import java.awt.Color;
import java.awt.event.*;
import  java.sql.*;

public class CalculateBill extends JFrame implements ActionListener {
 JTextField tfname,tfaddress,tfstate,tfunits,tfemail,tfphone; 
 JButton next,cancel;
 JLabel Iblname,labeladdress;
  Choice meternumber,cmonth;  
    CalculateBill(){
      setSize (700,500);
      setLocation(400,150);
      setVisible(true);
      
      JPanel P= new JPanel();
      P.setLayout(null);
      P.setBackground(new Color(173,216,230));
      add(P);
      
      JLabel heading = new JLabel("Calculate Electricity Bill");
      heading.setBounds(100,10,400,25);
      heading.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(heading);
      
      JLabel Iblmeternumber= new JLabel("Meter number");
      Iblmeternumber.setBounds(100,80,100,20);
      //Iblname.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblmeternumber);
     
      meternumber = new Choice();
      try{
         Conn C= new Conn() ;
         ResultSet rs =C.s.executeQuery("select * from customer ");
         while(rs.next()){
           meternumber.add( rs.getString("meter_no"));
         }
      }catch(Exception e){
          e.printStackTrace();
      }
      
      meternumber.setBounds(240,80,200,20);
      //Iblmeter.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(meternumber);
          
      JLabel Iblmeterno= new JLabel("Name");
     Iblmeterno.setBounds(100,120,100,20);
     // Iblmeterno.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblmeterno);
      
      
       Iblname= new JLabel("");
     Iblname.setBounds(240,120,100,20);
      //Iblmeter.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblname);
      
     
      JLabel Ibladdress= new JLabel("Address");
      Ibladdress.setBounds(100,160,100,20);
     // Ibladdress.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Ibladdress);
      
      
      labeladdress=new JLabel();
      labeladdress.setBounds(240,160,200,20);
      P.add(labeladdress);
      
      try{
          Conn c=new Conn();
          ResultSet rs =c .s.executeQuery("select * from customer where meter_no= '"+meternumber.getSelectedItem()+"' ");
          while(rs.next()){
              Iblname.setText(rs.getString("name"));
             labeladdress.setText(rs.getString("address"));
          }
      }catch(Exception e){
          e.printStackTrace();
      }
      meternumber.addItemListener(new ItemListener(){
         public void itemStateChanged(ItemEvent ie) {
             try{
          Conn c=new Conn();
          ResultSet rs =c .s.executeQuery("select * from customer where meter_no= '"+meternumber.getSelectedItem()+"' ");
          while(rs.next()){
              Iblname.setText(rs.getString("name"));
             labeladdress.setText(rs.getString("address"));
          }
      }catch(Exception e){
          e.printStackTrace();
      }  
         }
      });
      
       JLabel Iblcity= new JLabel(" Units Conxumed");
      Iblcity.setBounds(100,200,100,20);
      //Iblname.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblcity);
      
      
      tfunits=new JTextField();
      tfunits.setBounds(240,200,200,20);
      P.add(tfunits);
      
       JLabel Iblstate= new JLabel("Month");
      Iblstate.setBounds(100,240,100,20);
      //Iblname.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblstate);
      
      cmonth =new Choice();
      cmonth.setBounds(240,240,200,20);
      cmonth.add("January");
       cmonth.add("February");
        cmonth.add("March");
         cmonth.add("April");
          cmonth.add("May");
           cmonth.add("June");
            cmonth.add("July");
             cmonth.add("August");
              cmonth.add("September");
               cmonth.add("October");
                cmonth.add("November");
                 cmonth.add("December");
                    P.add(cmonth);
      
       
      
      next= new JButton("Submit");
      next.setBounds(120,350,100,25);
      next.setBackground(Color.BLACK);
      next.setForeground(Color.WHITE);
      next.addActionListener(this);
      P.add(next);
      
       cancel= new JButton("Cancel");
      cancel.setBounds(250,350,100,25);
      cancel.setBackground(Color.BLACK);
     cancel.setForeground(Color.WHITE);
     cancel.addActionListener(this);
      P.add(cancel);
      
      setLayout(new BorderLayout());
      
      add(P,"Center");
      
      ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
      Image i2= i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
      ImageIcon i3= new ImageIcon(i2);
      JLabel image= new JLabel(i3);
      add(image,"West");
      
      getContentPane().setBackground(Color.WHITE);
      setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== next){
          
            String meter =meternumber.getSelectedItem();
            String units =tfunits.getText();
            String month=cmonth.getSelectedItem();
            
            int totalbill =0;
            int unit_consumed = Integer.parseInt(units);
            String query= "select *from tax";
            try{
               Conn c= new Conn() ;
            ResultSet rs=c.s.executeQuery(query);
            
            while(rs.next()){
              totalbill+= unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                     totalbill += Integer.parseInt(rs.getString("meter_rent"));
                         totalbill+=Integer.parseInt(rs.getString("service_charge"));
                             totalbill+=Integer.parseInt(rs.getString("service_tax"));
                                    totalbill+=Integer.parseInt(rs.getString("extra_fees"));
                                            totalbill+=Integer.parseInt(rs.getString("fixed_tax"));

              }
           
            }catch (Exception e){
                e.printStackTrace();
            }
               String query2="insert into bill values('"+meter+"','"+month+"','"+units+"','"+totalbill+"','not paid')";
               try{
                   Conn C= new Conn();
                   C.s.executeUpdate(query2);
                          JOptionPane.showMessageDialog(null,"customer bill update");
                   setVisible(false);
               }catch(Exception e){
                 e.printStackTrace();
               }
        } else {
           setVisible(false) ;
        }
    }
    public static void main(String[] args){
        new CalculateBill();
    }
}



