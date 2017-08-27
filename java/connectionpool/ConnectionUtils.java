package connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtils {
    private final String URL = "jdbc:mysql://localhost:3306/student";
    private final String USER = "root"; 
    private final String PASSWORD = "dlx";
    
    public Connection getConn(){
        Connection conn =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(URL,USER,PASSWORD);
            
        } catch (Exception e) {
           
            e.printStackTrace();
        }
        return conn;
        
    }

}
