
package electricity.billing.system;
//import java.awt.Color;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java .awt.event.*;
import java.sql.*;
public class Signup extends JFrame implements ActionListener {
    JButton create,back;
    Choice accountType;
    JTextField meter,username,name,password;
    Signup(){
      //  setSize(700,400);
       // setLocation(450,150);
        setBounds(450,150,700,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JPanel Panel = new JPanel();
        Panel.setBounds(30,30,650,300);
        Panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230),2),"Create-Account",TitledBorder.LEADING,TitledBorder.TOP, null, new Color(172,216,230)));
        Panel.setBackground(Color.WHITE);
        Panel.setLayout(null);
        Panel.setForeground(new Color(34,139,34));
        add(Panel);
        
        JLabel heading  = new JLabel("Create Account as");
        heading.setBounds(100,50,140,20);
        heading.setForeground(Color.GRAY);
        heading.setFont(new Font("Tahoma",Font.BOLD,14));
        Panel.add(heading);
        
        accountType =new Choice();
        accountType.add("Admin");
        accountType.add("Customer");
        accountType.setBounds(260,50,150,20);
        Panel.add(accountType);
        
        JLabel Iblmeter  = new JLabel("Meter number");
        Iblmeter.setBounds(100,90,140,20);
        Iblmeter.setForeground(Color.GRAY);
        Iblmeter.setFont(new Font("Tahoma",Font.BOLD,14));
        Iblmeter.setVisible(false);
        Panel.add(Iblmeter);
        
         meter = new JTextField();
        meter.setBounds(260,90,150,20);
        meter.setVisible(false);
        Panel.add(meter);
        
      
        JLabel Iblusername  = new JLabel("Username");
        Iblusername.setBounds(100,130,140,20);
        Iblusername.setForeground(Color.GRAY);
        Iblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        Panel.add(Iblusername);
        
         username = new JTextField();
        username.setBounds(260,130,150,20);
        Panel.add(username);
        
        JLabel Iblname  = new JLabel("Name");
        Iblname.setBounds(100,170,140,20);
        Iblname.setForeground(Color.GRAY);
        Iblname.setFont(new Font("Tahoma",Font.BOLD,14));
        Panel.add(Iblname);
        
         name = new JTextField();
        name.setBounds(260,170,150,20);
        Panel.add(name);
         meter.addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent fe){}
            @Override
            public void focusLost(FocusEvent fe){
            
                try{
                   Conn c= new Conn(); 
                      ResultSet rs =c.s.executeQuery("select * from login where meter_no = '"+meter.getText()+"'");
                      while(rs.next()){
                         name.setText(rs.getString("name"));
                      }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        
        JLabel Iblpassword  = new JLabel("Password");
        Iblpassword.setBounds(100,210,140,20);
        Iblpassword.setForeground(Color.GRAY);
        Iblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        Panel.add(Iblpassword);
        
         password = new JTextField();
        password.setBounds(260,210,150,20);
        Panel.add(password);
        
        accountType.addItemListener(new ItemListener(){
            
            public void itemStateChanged(ItemEvent ae){
                String user = accountType.getSelectedItem();
                if(user.equals("Customer")){
                    Iblmeter.setVisible(true);
                    meter.setVisible(true);
                    name.setEditable(false);
                }else {
                 Iblmeter.setVisible(false);
                    meter.setVisible(false);  
                    name.setEditable(true);
                }
            }
        });
   
         create =new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(140,260,150,25);
        create.addActionListener(this);
        Panel.add(create);
        
        back =new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back .setBounds(300,260,150,25);
        back.addActionListener(this);
        Panel.add(back);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2= i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3=  new ImageIcon(i2);
        
        JLabel image = new JLabel(i3);
        image.setBounds(410,30,250,250);
        Panel.add(image);
     
         setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()== create){
           String atype= accountType.getSelectedItem();
           String susername= username.getText();
             String sname= name.getText();
             String spassword= password.getText();
             String smeter= meter.getText();
           //  "codefori"+smeter+"nterview"
             try{
                 Conn c = new Conn();
                 String query =null;
                 if(atype.equals("Admin")){
                     
                      query="insert into login values('"+smeter+" ', '"+ susername+" ',  '"+ sname+"', '"+spassword+"','"+ atype+"')";
                 }else{
                     query ="update login set username= '"+susername+"',password='"+spassword+"', user = '"+atype+"' where meter_no='"+smeter+"'"; 
                     
                 }
                  c.s.executeUpdate(query);
                    
                   JOptionPane.showMessageDialog(null,"Account created Sucessfully");
                   setVisible(false);
                   new Login();
                   
             } catch (Exception e){
             e.printStackTrace();
             }
         }else if(ae.getSource()== back){
             setVisible(false);
             new Login();
         }
    }
    
    public static void main(String[] args){
        new Signup();
    }
}
