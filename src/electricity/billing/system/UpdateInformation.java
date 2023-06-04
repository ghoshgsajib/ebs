
package electricity.billing.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateInformation extends JFrame implements ActionListener {
    JTextField tfaddress,tfstate,tfcity,tfemail,tfphone;
    JButton update,cancel;
    String meter;
    JLabel name;
    UpdateInformation(String meter){
        this.meter=meter;
      setBounds(300,150,1050,450);
      
     
     getContentPane().setBackground(Color.WHITE);
      setLayout(null);
      
       JLabel heading =new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setBounds(110,0,400,30);
        heading.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(heading);
        
         JLabel Iblname =new JLabel("Name");
       Iblname.setBounds(30,50,100,20);
        Iblname.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Iblname);
        
        name =new JLabel("");
       Iblname.setBounds(230,70,200,20);
        Iblname.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(name);
        
                 JLabel Iblmeternumber =new JLabel("Meter Number");
       Iblmeternumber.setBounds(30,110,130,20);
        Iblmeternumber.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Iblmeternumber);
        
        JLabel meternumber =new JLabel("");
       meternumber.setBounds(230,110,200,20);
       meternumber.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(meternumber);
        
        
                 JLabel Ibladdress =new JLabel("Address");
       Ibladdress.setBounds(30,150,100,20);
        Ibladdress.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Ibladdress);
        
        tfaddress =new JTextField();
      tfaddress.setBounds(230,150,200,20);
      tfaddress.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(tfaddress);
        
        
                 JLabel Iblcity =new JLabel("City");
       Iblcity.setBounds(30,190,100,20);
     Iblcity.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Iblcity);
        
        tfcity =new JTextField();
      tfcity.setBounds(230,190,200,20);
      tfcity.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(tfcity);
        
        
         JLabel Iblstate =new JLabel("State");
       Iblstate.setBounds(30,230,100,20);
     Iblstate.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Iblstate);
        
       tfstate =new JTextField();
      tfstate.setBounds(230,230,200,20);
      tfstate.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(tfstate);
        
          JLabel Iblemail =new JLabel("Email");
       Iblemail.setBounds(30,270,100,20);
     Iblemail.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Iblemail);
        
        tfemail =new JTextField();
      tfemail.setBounds(230,270,200,20);
      tfemail.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(tfemail);
        
          JLabel Iblphone =new JLabel("Phone");
       Iblphone.setBounds(30,310,100,20);
     Iblphone.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Iblphone);
        
        tfphone =new JTextField();
      tfphone.setBounds(230,310,200,20);
      tfphone.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(tfphone);
        
        try{
          Conn c= new Conn();  
          ResultSet rs = c.s.executeQuery("select * from customer where meter_no='"+meter+"'");
          while(rs.next()){
              name.setText(rs.getString("name"));
               tfaddress.setText(rs.getString("address"));
                tfcity.setText(rs.getString("city"));
                 tfstate.setText(rs.getString("state"));
                  tfemail.setText(rs.getString("email"));
                  tfphone.setText(rs.getString("phone"));
                    meternumber.setText(rs.getString("meter_no"));
              
          }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
       update.setBounds(70,360,100,25);
        add(update);
        update.addActionListener(this);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(230,360,100,25);
        add(cancel);
        cancel.addActionListener(this);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 =i1.getImage().getScaledInstance(400, 300,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(550,50,400,300);
        add(image);
        
        setVisible(true);
       
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==update){
        
            String address=tfaddress.getText();
             String city =tfcity.getText();
              String state=tfstate.getText();
               String email=tfemail.getText();
                String phone=tfphone.getText();
                try {
                  Conn c= new Conn() ;
                  c.s.executeUpdate("update customer set address='"+address+"',city='"+city+"',state='"+state+"',email='"+email+"',phone='"+phone+"',where meter_no='"+meter+"'");
                  JOptionPane.showMessageDialog(null, "User Information update successfully");
                  setVisible(false);
                }catch(Exception e){
                    e.printStackTrace();
                }
            
        }else {
            setVisible(false);
        }
    }
    public static  void main(String[] args){
        new UpdateInformation("");
    }
    
}
