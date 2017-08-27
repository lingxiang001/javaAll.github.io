package thread;
/**
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _2ThreadPool {

    public static void main(String[] args) {
       ExecutorService fixedThread=Executors.newFixedThreadPool(5);
       for (int i = 0; i < 10; i++) {
        fixedThread.execute(new Runnable() {

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
        fixedThread.shutdown();
    }

    }

}
