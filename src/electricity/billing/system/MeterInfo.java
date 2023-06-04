
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java .util.*;
//import java.awt.Color;
import java.awt.event.*;

public class MeterInfo extends JFrame implements ActionListener {
 JTextField tfname,tfaddress,tfstate,tfcity,tfemail,tfphone; 
 JButton next,cancel;
 JLabel Iblmeter;
  Choice meterlocation,metertype,phasecode,billtype;  
  String meternumber;
    MeterInfo(String meternumber){
        this.meternumber=meternumber;
        
      setSize (700,500);
      setLocation(400,200);
      setVisible(true);
      
      JPanel P= new JPanel();
      P.setLayout(null);
      P.setBackground(new Color(173,216,230));
      add(P);
      
      JLabel heading = new JLabel("Meter Information");
      heading.setBounds(180,10,200,25);
      heading.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(heading);
      
      JLabel Iblname= new JLabel(" Meter Number");
      Iblname.setBounds(100,80,100,20);
      //Iblname.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblname);
      
       JLabel Iblmeternumber= new JLabel(meternumber);
      Iblmeternumber.setBounds(240,80,100,20);
      //Iblname.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblmeternumber);
      
      
    
     
      JLabel Iblmeterno= new JLabel("Meter Location");
     Iblmeterno.setBounds(100,120,100,20);
     // Iblmeterno.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblmeterno);
      
      meterlocation =new Choice();
      meterlocation.add("Outside");
      meterlocation.add("Inside");
      meterlocation.setBounds(240,120,200,20);
      P.add(meterlocation);
      
     
      
      
 
      JLabel Ibladdress= new JLabel("Meter Type");
      Ibladdress.setBounds(100,160,100,20);
     // Ibladdress.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Ibladdress);
      
      
     metertype =new Choice();
      metertype.add("Analog Meter");
      metertype.add("Digital eter");
      metertype.add("Smart Meter");
      metertype.setBounds(240,160,200,20);
      P.add(metertype);
      
       JLabel Iblcity= new JLabel("Phase Code");
      Iblcity.setBounds(100,200,100,20);
      //Iblname.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblcity);
      
    phasecode =new Choice();
      phasecode.add("011");
       phasecode.add("022");
       phasecode.add("033");
        phasecode.add("044");
         phasecode.add("055");
          phasecode.add("066");
           phasecode.add("077");
            phasecode.add("088");
             phasecode.add("099");
       phasecode.setBounds(240,200,200,20);
      P.add( phasecode);
      
       JLabel Iblstate= new JLabel("Bill Type");
      Iblstate.setBounds(100,240,100,20);
      //Iblname.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblstate);
      
      
      billtype=new Choice();
      billtype.add("Resident Meter");
      billtype.add("Commercial Meter");
      billtype.setBounds(240,240,200,20);
      P.add(billtype);
      
       JLabel Iblemail= new JLabel("Days");
      Iblemail.setBounds(100,280,100,20);
      //Iblname.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblemail);
      
      JLabel Iblemails= new JLabel(" 30 Days");
      Iblemails.setBounds(240,280,100,20);
      //Iblname.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblemails);
    
      
       JLabel Iblphone= new JLabel("Note");
      Iblphone.setBounds(100,320,100,20);
      //Iblname.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblphone);
      
      JLabel Iblphones= new JLabel("By Default Bill is Calculaterd for 30 days only");
      Iblphones.setBounds(240,320,500,20);
      //Iblname.setFont(new Font("Tahoma",Font.PLAIN,24));
      P.add(Iblphones);
      
      
   
      
      
      next= new JButton("Submit ");
      next.setBounds(220,390,100,25);
      next.setBackground(Color.BLACK);
      next.setForeground(Color.WHITE);
      next.addActionListener(this);
      P.add(next);
      
     
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
            
            String meter = meternumber;
            String location =meterlocation.getSelectedItem();
            String type =metertype.getSelectedItem();
            String code=phasecode.getSelectedItem();
            String typebill=billtype.getSelectedItem();
            String days= "30";
            
            
            String query= "insert into meter_info values('"+meter+"','"+location+"', '"+type+"','"+code+"','"+typebill+"','"+days+"')";
            try{
               Conn c= new Conn() ;
               c.s.executeUpdate(query);
            
               
             JOptionPane.showMessageDialog(null,"Meter Information Added Successfully");
               setVisible(false);
              
            }catch (Exception e){
                e.printStackTrace();
            }
        } else {
           setVisible(false) ;
        }
    }
    public static void main(String[] args){
        new MeterInfo("");
    }
}



