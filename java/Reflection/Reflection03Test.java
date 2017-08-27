package Reflection;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import sql.jdbc_utils.JDBCFacadeImpl;

public class Reflection03Test {

    @Test
    public void test() throws IllegalArgumentException, IllegalAccessException, SQLException, Exception {
       /* String sql="select * from studentInfo ";
       ResultSet rs= JDBCFacadeImpl.me.executeQuery(sql);
       Reflection03 re=new Reflection03();
       Class claz=Student.class;
       List<Student> list=re.rs2List(rs, claz);
       
       assertEquals(,list);*/
    }

}
