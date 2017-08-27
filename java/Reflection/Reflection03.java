package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import sql.jdbc_utils.JDBCFacadeImpl;
/**
 * 将结果集转换为指定claz的实例的列表
参数1：结果集
参数2：目标集合中的元素的类型
对应关系：将列名对应到对象的属性名，假设二者是一致的，列名可能多于claz的属性，不作处理即可

 * @author lingxiang
 *
 */
public class Reflection03 {
   
    public static <T> List<T> rs2List(ResultSet rs,Class<T> claz) {
        List<T> list=new ArrayList<T>();
        try {
            while(rs.next()){
                T obj=populationInstance(rs,claz); 
                list.add(obj);
            }
        } catch (SecurityException | SQLException e) {
            throw new RuntimeException();
        }
        return list;
    }
    private static <T> T populationInstance(ResultSet rs,Class<T> claz){
        Field[] field=claz.getDeclaredFields();//得到所有域
        final Logger LOGGER=Logger.getLogger(claz);
        T obj = null;
        try {
            obj = claz.newInstance();
        } catch (InstantiationException | IllegalAccessException e1) {
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
                case "int":                 
                    f.set(obj, rs.getInt(name));
                    break;
                case "Date":
                    f.set(obj, rs.getDate(name));
                   break;
                default:
                    break;
                }
            } catch (Exception e) {
               LOGGER.warn("在结果集中不存在该属性: "+name);
                e.printStackTrace();
               continue;
            }
        }
        return obj;
    }
    
   public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, SQLException, Exception{
       String sql="select * from student ";
       ResultSet rs= JDBCFacadeImpl.me.executeQuery(sql);
       Reflection03 re=new Reflection03();
       Class claz=Student.class;
       List<Student> list=re.rs2List(rs, claz);
       System.out.println(list);
   }


}
