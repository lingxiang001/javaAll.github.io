package sql.jdbc_utils;

import java.sql.ResultSet;
import java.util.List;

/**
 * jdbc简单的操作工具，封装复杂的操作流程，为用户提供便捷的sql操作
 * @author lingxiang
 *
 */
public interface JDBCFacade<T> {
    /**
     * 进行查询的sql操作
     * 
     * @param sql
     * @return 结果集
     */
    ResultSet executeQuery(String sql);
    /**
     * 进行查询操作，将结果集返回 为list对象
     * @param sql
     * @param obj
     * @return
     */
    List<T> executeQuery(String sql,Class claz,Object...obj);
   
    /**
     * 进行更新的sql操作
     * @param sql
     * @return 整数
     */
    int executeUpdate(String sql);
    

}
