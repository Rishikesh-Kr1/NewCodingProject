
package hotel.management.system;
import java.sql.*;

 public class Conn {
     Connection c;
     Statement s;
    Conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","");
            
            s=c.createStatement();
            
        }
        catch (Exception e){
            e.printStackTrace();
            
        }
    }    

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
