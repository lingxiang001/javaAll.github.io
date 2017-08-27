package thread;
/**
 * 生产者和消费者问题
 * synchronized 实现
 */
import java.util.ArrayList;

public class _1Produdcer_Customer {
     private static ArrayList<String> list=new ArrayList();
    final static Integer producter=1;
    final static  Integer customer=2;
     final static private  int NUM=10;
    static  class Producer implements Runnable{
       private String name;
       private int count=0;
       public Producer(String name) {
        super();
        this.name = name;
    }

    public void production(){
       synchronized (producter) {
      
            if (list.size() < NUM) {
              
                    list.add(this.name + " " + ++count+ "0001");
                    System.out.println(this.name + " produced " + count + "0001");
                    producter.notifyAll();//唤醒等待生产的消费者
                
            } else {
                try {
                    System.out.println("生产已满 ，等待消费");
                    producter.wait();

                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
        
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
          
         synchronized (customer) {
             try {
                Thread.sleep(500);
            } catch (InterruptedException e1) {
               
                e1.printStackTrace();
            }
           
                if (list.size() > 0) {
                    System.out.println(this.name + "customed " + list.remove(0));
                   customer.notifyAll();//唤醒等待消费的生产者
                } else {
                    try {
                        System.out.println("消费完毕 ，等待生产");
                        customer.wait();

                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                }
            
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
