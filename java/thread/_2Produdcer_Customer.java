package thread;
/**
 * 生产者和消费者问题
 * ReentrantLock,condition 实现
 */
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _2Produdcer_Customer {
     private static ArrayList<String> list=new ArrayList();
     final static  Lock lock=new ReentrantLock();
     final static Condition notEmpty=lock.newCondition();
     final static Condition notFull=lock.newCondition();
     final static private  int NUM=10;
    static  class Producer implements Runnable{
       private String name;
       private int count=0;
       public Producer(String name) {
        super();
        this.name = name;
    }

    public void production(){
            lock.lock();
            
            try {
                if (list.size() < NUM) {

                    list.add(this.name + " " + ++count + "0001");
                    System.out.println(this.name + " produced " + count + "0001");
                    notEmpty.signalAll();

                } else {
                System.out.println("生产已满 ，等待消费");
                notFull.await();
                } 
            }catch(Exception e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
    }
       
        @Override
        public void run() {
            production();
           
        }
         
     }
     
     
     static class Customer implements Runnable{
         private String name;
         private int count=0;
         public Customer(String name) {
          super();
          this.name = name;
      }

       public void customtion(){
           lock.lock();
           try{
               Thread.sleep(500);
               if (list.size() > 0) {
                   System.out.println(this.name + "customed " + list.remove(0));
                   notFull.signalAll();
               } else {
                    System.out.println("消费完毕 ，等待生产");
                   notEmpty.await();
               }
           }catch(Exception e){
               e.printStackTrace();
           }finally{
               lock.unlock();
           }
        }

    @Override
    public void run() {
        customtion();
    }

  
 }
     
     
     
     public static void main(String[] args){
         Producer[] p=new Producer[10];
         Customer[] c=new Customer[10];
         for(int i=0;i<10;i++){
             p[i]=new Producer("生产者"+i);
             c[i]=new Customer("消费者"+i);
         }
         for(int i=0;i<10;i++){
             new Thread(p[i]).start();
             new Thread(c[i]).start();
         }
     }
}
