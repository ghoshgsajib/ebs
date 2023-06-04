
package electricity.billing.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class ViewInformation extends JFrame implements ActionListener  {
    JButton cancel;
    ViewInformation(String meter){
        setBounds(350,150,850,650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading =new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(250,0,500,40);
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(heading);
        
         JLabel Iblname =new JLabel("Name");
       Iblname.setBounds(50,80,100,20);
        Iblname.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Iblname);
        
        JLabel name =new JLabel("");
       Iblname.setBounds(250,80,100,20);
        Iblname.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(name);
        
                 JLabel Iblmeternumber =new JLabel("Meter Number");
       Iblmeternumber.setBounds(70,140,130,20);
        Iblmeternumber.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Iblmeternumber);
        
        JLabel meternumber =new JLabel("");
       meternumber.setBounds(250,140,100,20);
       meternumber.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(meternumber);
        
        
                 JLabel Ibladdress =new JLabel("Address");
       Ibladdress.setBounds(70,200,100,20);
        Ibladdress.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Ibladdress);
        
        JLabel address =new JLabel("");
      address.setBounds(250,200,100,20);
      address.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(address);
        
        
                 JLabel Iblcity =new JLabel("City");
       Iblcity.setBounds(70,260,100,20);
     Iblcity.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Iblcity);
        
        JLabel city =new JLabel("");
      city.setBounds(250,260,100,20);
      city.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(city);
        
        
         JLabel Iblstate =new JLabel("State");
       Iblstate.setBounds(500,80,100,20);
     Iblstate.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Iblstate);
        
        JLabel state =new JLabel("");
      state.setBounds(650,80,100,20);
      state.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(state);
        
          JLabel Iblemail =new JLabel("Email");
       Iblemail.setBounds(500,140,100,20);
     Iblemail.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Iblemail);
        
        JLabel email =new JLabel("");
      email.setBounds(650,140,100,20);
      email.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(email);
        
          JLabel Iblphone =new JLabel("Phone");
       Iblphone.setBounds(500,200,100,20);
     Iblphone.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Iblphone);
        
        JLabel phone =new JLabel("");
      phone.setBounds(650,200,100,20);
      phone.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(phone);
        
        try{
          Conn c= new Conn();  
          ResultSet rs = c.s.executeQuery("select * from customer where meter_no='"+meter+"'");
          while(rs.next()){
              name.setText(rs.getString("name"));
               address.setText(rs.getString("address"));
                city.setText(rs.getString("city"));
                 state.setText(rs.getString("state"));
                  email.setText(rs.getString("email"));
                  phone.setText(rs.getString("phone"));
                    meternumber.setText(rs.getString("meter_no"));
              
          }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(250,350,100,25);
        add(cancel);
        cancel.addActionListener(this);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 =i1.getImage().getScaledInstance(600, 300,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(20,350,600,300);
        add(image);
        
        setVisible(true);
      }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String[] args){
       new ViewInformation("");
    }
    
}
