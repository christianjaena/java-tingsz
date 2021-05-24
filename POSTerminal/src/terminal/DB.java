
package terminal;

import java.sql.Connection;
import java.sql.DriverManager;


public class DB {
    private static Connection con;
    
    public static Connection getConnection() throws Exception {
        try{
           
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pointofsale","root","");
           
        }catch (Exception e){
           System.out.println(""+ e);
        }
         return con;
    }
}
