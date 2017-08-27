package connectionpool;

import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * 设置简易连接池 
 * @author lingxiang
 *
 */
public class ConnectionPool implements DataSource{
    private static BlockingQueue<Connection> pool=new LinkedBlockingQueue<Connection>();//阻塞队列
    private final String URL = "jdbc:mysql://localhost:3306/student";
    private final String USER = "root"; 
    private final String PASSWORD = "dlx";
    private final int MAX_NUM=10;
    public  ConnectionPool(){
        Connection conn =null;
        ConnectionProxy cp=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            for(int i=0;i<MAX_NUM;i++){
                conn=DriverManager.getConnection(URL,USER,PASSWORD);
                conn=cp.getProxy(conn, pool); //获取代理的对象
                pool.add((Connection)conn);   //添加/缓存代理的对象
            }
        } catch (Exception e) {
           
            e.printStackTrace();
        }
       
    }
    
    

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        // TODO Auto-generated method stub
        return false;
    }
/**
 * 从池中得到一个对象
 */
    @Override
    public  Connection getConnection() throws SQLException {
        Connection conn=null;
        try {
             conn=pool.take();
             System.out.println("成功得到一个连接，缓冲池还剩："+pool.size()+"个");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    
    
    
    
    

}
