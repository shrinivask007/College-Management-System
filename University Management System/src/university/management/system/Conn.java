
/**
 *
 * @author Shreyash
 */
package university.management.system;

import java.sql.*;

public class Conn {
//    refernce vaible for the connection object 
    Connection c;
    Statement s;

    Conn () {
        try {
//register the driver 
            Class.forName("com.mysql.cj.jdbc.Driver");
//drivermanger class is used to create the connection stream 
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem", "root", "foxiscoming");
//            creating the statement 
            s = c.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}