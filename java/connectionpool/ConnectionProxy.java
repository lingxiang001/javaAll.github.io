package connectionpool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.BlockingQueue;
/**
 * 实现对Connection的动态代理
 * @author lingxiang
 *
 */
public class ConnectionProxy implements InvocationHandler{
      private Connection  conn;
      private BlockingQueue<Connection> pool;
      private ConnectionProxy(Connection conn, BlockingQueue<Connection> pool) {
      this.conn = conn;
      this.pool = pool;
    }
      /**
       * 返回代理连接
       * @param o
       * @param pool
       * @return
       */
      public static Connection getProxy(Object o,BlockingQueue<Connection> pool){
          Object proxyed=Proxy.newProxyInstance(
                  o.getClass().getClassLoader(), 
                  new Class[]{ Connection.class },
                  new ConnectionProxy((Connection) o,pool) );
          return (Connection) proxyed;
      }
  

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("close".equals(method.getName())){
            pool.put((Connection)proxy);
            System.out.println("成功归还 一个连接，缓冲池还剩："+pool.size()+"个");
            return null;
        }else{
           return method.invoke(proxy, args); 
        }
       
    }
    
}