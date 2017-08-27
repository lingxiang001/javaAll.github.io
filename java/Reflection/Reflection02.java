package Reflection;

import java.lang.reflect.Field;
import java.util.Map;

import org.apache.log4j.Logger;

public class Reflection02 {
    public static <T> T map2Bean(Map map,Class<T> claz) {
        Field[] field=claz.getDeclaredFields();//得到所有域
        T obj = null;
        try {
            
            obj = claz.newInstance();
            for (Field f : field) {
                String name = f.getName();
                String type = f.getType().getSimpleName();
                if (map.containsKey(name)) {
                    f.setAccessible(true);
                    switch(type){
                    case "int":
                        f.set(obj, Integer.parseInt(map.get(name).toString()));
                        break;
                    case "String":
                        f.set(obj, map.get(name).toString());
                        break;
                     default:
                         break;
                    }
                }
                f.setAccessible(false);
            } 
        } catch (Exception e) {
           throw new  RuntimeException();
        }
        return obj;

    }
    

    

}
