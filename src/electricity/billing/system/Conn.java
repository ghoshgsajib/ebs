
package electricity.billing.system;
import java.sql.*;
public class Conn {
    Connection c;Statement s;
    Conn() {
       try{
           
             c= DriverManager.getConnection("jdbc:mysql://@localhost:3306/ebs", "root","221155417");
               s=c.createStatement();
  // String query ="insert into login values()";
       } catch (Exception e) {
           e.printStackTrace();
       } 
    }
}


