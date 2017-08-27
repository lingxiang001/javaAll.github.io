package sql.jdbc_utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

public   enum  JDBCFacadeImpl implements JDBCFacade {
    
    me;
    private  BlockingQueue<Connection> pool=new LinkedBlockingQueue<Connection>(10);
   // private static Logger log=Logger.getLogger(JDBCFacadeImpl.class);
    private  JDBCFacadeImpl(){
        init();
    }
    
    @Override
    public ResultSet executeQuery(String sql) {
        Connection conn=null;
        conn=getConn();
        try {
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            return cache(rs);
        } catch (SQLException e) {
         //  log.error(e.getMessage(), e);
           throw new DataException(e);
           
        }finally{
            realseConn(conn);
        }
        
    }
    /**
     * 扩展成参数外化的功能
     */
    public ResultSet executeQueries(String sql,Object...objs) {
        Connection conn=null;
        conn=getConn();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs=getArgus(pstmt,objs).executeQuery();
            return cache(rs);
        } catch (SQLException e) {
          // log.error(e.getMessage(), e);
           throw new DataException(e);
           
        }finally{
           realseConn(conn);
        }
        
    }
    private PreparedStatement getArgus(PreparedStatement pstmt,Object[] objs) throws SQLException{
        for(int i=0;i<objs.length;i++){
            pstmt.setObject(i+1, objs[i]);
        }
        
        return pstmt;
        
    }

    @Override
    public int executeUpdate(String sql) {
        Connection conn=null;
        conn=getConn();
        try {
            Statement stmt=conn.createStatement();
            int result=stmt.executeUpdate(sql);
            return result;
        } catch (SQLException e) {
         //   log.error(e.getMessage(), e);
            throw new DataException(e);
        }finally{
            realseConn(conn);
        }
        
    }
    public int executeUpdate(String sql,Object...obj){
        Connection conn=null;
        conn=getConn();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            int result=getArgus(pstmt,obj).executeUpdate();
          
            return result;
        } catch (SQLException e) {
          //  log.error(e.getMessage(), e);
            throw new DataException(e);
        }finally{
            realseConn(conn);
        }
      
        
    }
    private ResultSet cache(ResultSet rs) throws SQLException{
        com.sun.rowset.CachedRowSetImpl rowset=new com.sun.rowset.CachedRowSetImpl();
        rowset.populate(rs);
        return rowset;
    }
    
    /**
     * 连接数据库
     */
    private Connection createConnection(){
        
          Connection conn=null;  
           try {
                Class.forName("com.mysql.jdbc.Driver");
               
            } catch (ClassNotFoundException e) {
              //  log.error(e.getMessage(), e);
                throw new DataException(e);
            }
           try {
                conn = DriverManager.getConnection(Config.URL,Config.USER,Config.PASSWORD);
               
           } catch (SQLException e) {
             //  log.error(e.getMessage(), e);
               throw new DataException(e);
           }
           return conn;
    }
    
    private void  init(){
        for(int i=0;i<10;i++){
            pool.add(createConnection());
        }
    }
    /**
     * 从连接池中借出一个连接
     * @return
     */
    public Connection getConn(){
        return pool.poll();
    }
    /**
     * 将连接归还给连接池,要判断该连接是否为null 或是 是否已关闭
     * @param conn
     */
    public void realseConn(Connection conn){
        try {
            if(null != conn && !conn.isClosed()){
                pool.add(conn);
            }
        } catch (SQLException e) {
          //  log.error(e.getMessage(), e);
            throw new DataException(e);
        }
    }

    @Override
    public List executeQuery(String sql,Class claz,Object...obj){
        ResultSet rs=executeQueries( sql,obj);
        List list=new ArrayList();
        try {
            while(rs.next()){
                Object obj1=populationInstance(rs,claz); 
                list.add(obj1);
            }
        } catch (SecurityException | SQLException e) {
            throw new RuntimeException();
        }
        return list;
    }
    private static  Object populationInstance(ResultSet rs,Class claz){
        Field[] field=claz.getDeclaredFields();//得到所有域
      //  final Logger LOGGER=Logger.getLogger(claz);
        Object obj = null;
        try {
            obj = claz.newInstance();
        } catch (InstantiationException | IllegalAccessException e1) {
            System.out.println("列名");
            throw new RuntimeException();
        }
        for(Field f:field){
            f.setAccessible(true);
            String name=f.getName();
            
            String type=f.getType().getSimpleName();
          
             try {
                switch (type) {
                case "String":
                    f.set(obj, rs.getString(name));
                    break;
                case "Integer":                 
                    f.set(obj, rs.getInt(name));
                    break;
               case "Date":
                   f.set(obj, rs.getDate(name)); 
                   break;
               case "Boolean":
                    f.set(obj,rs.getBoolean(name));
                   break;
                 case "Double":
                     
                    f.set(obj, rs.getDouble(name));
                   break;
                case "char":
                    f.set(obj,rs.getObject(name));
                    break;
                default:
                    break;
                }
            } catch (Exception e) {
                System.out.println("在结果集中不存在该属性: "+name);
            //   LOGGER.warn("在结果集中不存在该属性: "+name);
                e.printStackTrace();
               continue;
            }
        }
        return obj;
    }

   

}
