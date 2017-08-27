package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException{
        Class claz=Class.forName("java.lang.String");
        print(claz.getName());
        print("{");
        print("=============域成员===========");
        Field[] field=claz.getDeclaredFields();
        for(Field f:field){
            String modify=Modifier.toString(f.getModifiers());//修饰符 
            String type=f.getType().getName();
            String name=f.getName();
                    
            print("\t"+modify+" "+type+" "+name);
        }
        
        print("====================构造方法====================");
        Constructor[] con=claz.getConstructors();
        for(Constructor c:con){
            String modify=Modifier.toString(c.getModifiers());//修饰符 
            String name=c.getName();
            System.out.print("\t"+modify+" "+name+"(");
             Class pt[]= c.getParameterTypes();  
             for(Class p:pt){
                 System.out.print(" "+p.getSimpleName()+" "); 
             }
             System.out.print(") throws ");
             Class ex[]=c.getExceptionTypes();
             for(Class e:ex){
                 System.out.print(" "+e.getSimpleName()+" ");
             }

             print("");
            
        }
        
        print("=================方法================");
        Method[] method=claz.getDeclaredMethods();
        for(Method m:method){
            String modify=Modifier.toString(m.getModifiers());//修饰符 
            String type=m.getReturnType().getName();
            String name=m.getName();
            System.out.print("\t"+modify+" "+type+" "+name+"(");
             Class pt[]= m.getParameterTypes();  
             for(Class p:pt){
                 System.out.print(" "+p.getSimpleName()+" "); 
             }
             System.out.print(") throws ");
             Class ex[]=m.getExceptionTypes();
             for(Class e:ex){
                 System.out.print(" "+e.getSimpleName()+" ");
             }
             print("");
            
        }
        print("}");
        
    }
    public static void print(Object obj){
        System.out.println(obj);
    }

}
