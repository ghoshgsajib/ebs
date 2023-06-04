
package electricity.billing.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class PayBill extends JFrame implements ActionListener {
    Choice cmonth;
    JButton Pay,back;
    String meter;
   
    PayBill(String meter){
        this.meter=meter;
        setLayout(null);
        setBounds(300,150,900,600);
        
        JLabel heading= new JLabel("Electicity Bill");
        heading.setFont(new Font("Tahoma",Font.BOLD, 24));
        heading.setBounds(120,5,400,30);
        add(heading);
        JLabel Iblmeternumber= new JLabel("Meter Number");
        Iblmeternumber.setBounds(35,80,200,20);
        add(Iblmeternumber);
        JLabel meternumber= new JLabel("");
        meternumber.setBounds(300,80,200,20);
        add(meternumber);
        JLabel Iblname= new JLabel("Name");
        Iblname.setBounds(35,140,200,20);
        add(Iblname);
        
        JLabel Iabelname= new JLabel("");
        Iabelname.setBounds(300,140,200,20);
        add(Iabelname);
        
         JLabel Iblmonth= new JLabel("Month");
        Iblmonth.setBounds(35,200,200,20);
        add(Iblmonth);
              cmonth = new Choice();
        cmonth.setBounds(300,200,200,20);
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
        add(cmonth);
        
         JLabel Iblunits= new JLabel("Units");
         Iblunits.setBounds(35,260,200,20);
        add( Iblunits);
        
        JLabel Iabelunits= new JLabel("");
        Iabelunits.setBounds(300,260,200,20);
        add(Iabelunits);
        
         JLabel Ibltotalbill= new JLabel("Total Bill");
         Ibltotalbill.setBounds(35,320,200,20);
        add( Ibltotalbill);
        
        JLabel Iabeltotalbill= new JLabel("");
        Iabeltotalbill.setBounds(300,320,200,20);
        add(Iabeltotalbill);
        
        JLabel Iblstatus= new JLabel("Status");
         Iblstatus.setBounds(35,380,200,20);
        add( Iblstatus);
        
        JLabel Iabelstatus= new JLabel("");
        Iabelstatus.setBounds(300,380,200,20);
        Iabelstatus.setForeground(Color.red);
        add(Iabelstatus);

        try{
         Conn c= new Conn() ;
         ResultSet rs= c.s.executeQuery("select * from customer where meter_no='"+meter+"'");
         while(rs.next()){
             meternumber.setText(meter);
             Iabelname.setText(rs.getString("name"));
         }
          rs= c.s.executeQuery("select * from bill where meter_no='"+meter+"' AND month ='January'");
         while(rs.next()){
             Iabelunits.setText(rs.getString("units"));
             Iabeltotalbill.setText(rs.getString("totalbill"));
                          Iabelstatus.setText(rs.getString("status"));

         }
        }catch(Exception e){
            e.printStackTrace();
        }
        
      cmonth.addItemListener(new ItemListener(){
          
          public void itemStateChanged(ItemEvent ae){
              
               try{
         Conn c= new Conn() ;
       
         ResultSet rs= c.s.executeQuery("select * from bill where meter_no='"+meter+"' AND month ='"+cmonth.getSelectedItem()+"'");
         while(rs.next()){
             Iabelunits.setText(rs.getString("units"));
             Iabeltotalbill.setText(rs.getString("totalbill"));
                          Iabelstatus.setText(rs.getString("status"));

         }
        }catch(Exception e){
            e.printStackTrace();
        }
          }
      });
      Pay = new JButton("PAY");
        Pay.setBackground(Color.BLACK);
        Pay.setForeground(Color.WHITE);
        Pay.setBounds(100,460,100,25);
        Pay.addActionListener(this);
        add(Pay);
        back = new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(230,460,100,25);
        back.addActionListener(this);
        add(back);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/bill.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(400,120,600,300);
        add(image);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== Pay){
           try{
              Conn c= new Conn() ;
              c.s.executeUpdate("update bill set status = 'paid where meter_no='"+meter+"'AND month='"+cmonth.getSelectedItem()+"'");
           }catch(Exception e){
             e.printStackTrace();
           }
           setVisible(false);
           new Bkash(meter);
        }else{
            setVisible(false);
        }
    }
    public static void main(String[]args){
        new PayBill("");
    }
}
