package thread;
/**
 * 得出结果有时并没有得到10000，说明volatile修饰的变量不能保证原子性操作。
 * 线程不安全（保证可见性，不保证原子性）。
 * synchronized 保证线程安全。
 * @author lingxiang
 *
 */
public class volatileTest {
   
    
    
    public static void main(String[] args) throws InterruptedException{
        
        Thread1[] t1=new Thread1[100];
        Thread2[] t2=new Thread2[100];
        for(int i=0;i<100;i++){
            t1[i]=new Thread1();
            t2[i]=new Thread2();
        }
        for(int i=0;i<100;i++){
          //  new Thread(t1[i]).start();
            new Thread(t2[i]).start();
        }
        //System.out.println("count="+Thread1.count);
        System.out.println("count2="+Thread2.count2);
        
       
    }
    
    
    
   

}

class Thread1 implements Runnable{
  volatile static int count=0;
    @Override
    public void run() {
        
        for(int i=0;i<100;i++){
            count++;
        }
     
    }
    
}

class Thread2 implements Runnable{
    static int count2=0;
    @Override
    public void run() {
        synchronized(this){
            for(int i=0;i<100;i++){
                count2++;
            }
        }
        
    }
    
}
