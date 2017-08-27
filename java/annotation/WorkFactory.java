package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Throwables;
import com.google.common.reflect.Reflection;


public class WorkFactory {
    /**
     * 基于jdk动态代理的获取一个代理对象，用反射调用方法，判断方法是否有注解；
     * 在代理对象上增强原有方法
     * @param claz
     * @return
     */
    public static IWork getWorkerByJdkDynamicProxy(Class<? extends IWorkImpl> claz){
        class Handler implements InvocationHandler{
           private IWorkImpl iwork;
           public  Handler(IWorkImpl iwork){
               super();
               this.iwork=iwork;
           }
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                ShowDuration ann=method.getAnnotation(ShowDuration.class);
                Object result;
               // System.out.println("**************************88");
                if (ann != null && ann.value()) {
                  //  System.out.println("**************************88");
                    long startTime=System.nanoTime();
                    result= method.invoke(iwork,args);
                    long dutaTime=System.nanoTime()-startTime;
                   // System.out.println("********************88");
                    System.out.println(method.toGenericString()+"方法持续了"+TimeUnit.NANOSECONDS.toSeconds(dutaTime)+" 时间");
                   
                }else{
                    result=method.invoke(iwork, args);
                }
                return result;
            } 
        }
        try {
            final IWorkImpl target=claz.newInstance();
            return (IWork) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new Handler(target));
          //  return Reflection.newProxy(IWork.class,new Handler(target));
        } catch (InstantiationException | IllegalAccessException e) {
           throw new RuntimeException(e);
        }
    }

}
