package annotation;

public class main {

    public static void main(String[] args) {
       IWork worker ;
       worker=WorkFactory.getWorkerByJdkDynamicProxy(IWorkImpl.class);
       //System.out.println("**********************");
       worker.login1();
       //System.out.println("*************************");
       worker.login2();

    }

}
