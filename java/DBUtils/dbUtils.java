package DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbUtils {
private Connection conn = null;
    
    private final String URL = "jdbc:mysql://localhost:3306/student";
    
    private final String USER = "root";
    
    private final String PASSWORD = "dlx";
    
    public Connection getCon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                conn = DriverManager.getConnection(URL,USER,PASSWORD);
                System.out.println("数据库连接成功");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return this.conn;
    }

}
