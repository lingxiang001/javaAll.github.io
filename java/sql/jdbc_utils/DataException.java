package sql.jdbc_utils;
/**
 * 数据访问层的异常统一包装成此异常
 * @author lingxiang
 *
 */
public class DataException extends RuntimeException{
    public DataException(Exception e){
        super(e);
    }
}
