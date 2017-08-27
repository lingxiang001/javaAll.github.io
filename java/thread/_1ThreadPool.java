package thread;
/**
 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 * 
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _1ThreadPool {

    public static void main(String[] args) {
        ExecutorService cachedThread=Executors.newCachedThreadPool();
        for(int i=0;i<100;i++){
            cachedThread.execute(new Runnable(){

                @Override
                public void run() {
                   System.out.println("A");
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        
                        e.printStackTrace();
                    }
                }
                
            });
         //   cachedThread.shutdown();
            
        }
    }

}
