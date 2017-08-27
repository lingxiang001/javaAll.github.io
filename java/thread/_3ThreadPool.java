package thread;
/**
 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class _3ThreadPool {

    public static void main(String[] args) {
        ExecutorService single=Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            single.execute(new Runnable() {

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
            single.shutdown();
        }
    }

}
