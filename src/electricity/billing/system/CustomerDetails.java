package electricity.billing.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class CustomerDetails  extends JFrame implements ActionListener {
    JTable table;
    JButton print;
    CustomerDetails(){
        
        super("Customer Details");
        setSize(1000,650);
        setLocation(200,150);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        table =new JTable();
        
        try{
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("select * from customer");
          table.setModel(DbUtils.resultSetToTableModel(rs));
             
        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane sp= new JScrollPane(table);
                 sp.setBounds(0,0,700,650);

        add(sp);
       
       print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print,"South");
        setVisible(true);
            
    }
      public void actionPerformed(ActionEvent ae){
         
                try{
                table.print();
              }catch(Exception e){
                e.printStackTrace();
              }       
          }
          
    public static void main(String[] args){
        new CustomerDetails();
    }
}
