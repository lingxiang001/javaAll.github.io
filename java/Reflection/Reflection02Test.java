package Reflection;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Reflection02Test {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        Map map=new HashMap();
        map.put("name","dlx");
        map.put("age", "10");
        Class claz=Student.class;
        Reflection02 re=new Reflection02();
        Student stu=(Student)re.map2Bean(map, claz);
        assertEquals(10,stu.getAge());
        
    }

}
