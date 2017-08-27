package thread;
/**
 * 创建一个定长线程池，支持定时及周期性任务执行。
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _4ThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledThread=Executors.newScheduledThreadPool(5);
       
       scheduledThread.schedule(new Runnable(){

        @Override
        public void run() {
           System.out.println("A");
            
        }}, 3, TimeUnit.SECONDS);
       
     //  scheduledThread.shutdown();
       scheduledThread.scheduleAtFixedRate(new Runnable(){

        @Override
        public void run() {
           System.out.println("B");
            
        }
           
       },1, 3,TimeUnit.SECONDS);//线程执行时延迟一秒,每三秒执行一次,周期性执行
       
       scheduledThread.shutdown();

    }

}
