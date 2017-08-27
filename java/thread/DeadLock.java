package thread;
/**
 *造成线程死锁的原因：
 *1. 互斥条件：即某一个资源只能 被一个资源占有
 *2. 不可抢占资源：一个线程所获得的资源在为释放前，等待的线程不可抢占资源；
 *3. 占有且申请条件：一个线程占有一个资源并申请新的资源，但又 不释放已有资源
 *4. 循环等待条件：A线程持有B线程需要的资源；B线程持有A线程需要的资源，彼此互不相让。
 *这四个是死锁的必然条件，缺一不可。
 *
 *死锁的预防：
 *安全序列和银行家算法。
 */
import java.util.ArrayList;

public class DeadLock  implements Runnable{
    private static boolean flag = true;
   static  ArrayList<Integer> list=new ArrayList();
     static int[] num=new int[10];
    public static void main(String[] args) {
        DeadLock t1=new DeadLock();
        DeadLock t2=new DeadLock();
        new Thread(t1).start();
        new Thread(t2).start();

    }
     public void test() throws InterruptedException{
         synchronized(list){
                 Thread.sleep(500);
                 synchronized(num) {
                     System.out.println("AAAAAAAAAAA");
                    
                 }
         }
    }
     
     public void test2() throws InterruptedException{
         synchronized(num){
               Thread.sleep(399);
                 synchronized(list) {
                     System.out.println("BBBBBBBBBBBB");
                    
                 }
         }
     }

    @Override
    public void run() {
        try {
            if (flag) {
                flag = false;
                test();
            } else {
                flag = true;
                test2();
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
        
    }

}
