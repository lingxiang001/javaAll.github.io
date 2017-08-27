package thread;
/**
 * 数据不一致的现象
 */
import java.util.ArrayList;

import annotation.main;

public class DataNoSame  {
    static boolean falg=true;
    static ArrayList<Integer> list=new ArrayList();
   
   
   public static void main(String[] args){
       DataNoSame da=new DataNoSame();
       Thread1 t1=da.new Thread1();
       Thread2 t2=da.new Thread2();
       new Thread(t1).start();
       new Thread(t2).start();
   }
   class Thread1 implements Runnable{

    @Override
    public void run() {
        
            list.add(12);
            if(list.size()>0){
                try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
                System.out.println(list.get(0));
            }
      }
       
   }
   class Thread2 implements Runnable{

    @Override
    public void run() {
        list=null;
    }
       
   }
}
