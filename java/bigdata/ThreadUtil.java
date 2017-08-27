package bigdata;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sound.midi.SysexMessage;

public class ThreadUtil {
    /**
     * 线程池创建多个线程完成字符串存入文件任务
     */
    public static void threadPoolOutPut(){
        
        ExecutorService cachedThread=Executors.newCachedThreadPool();//创建可缓存线程池
        
            cachedThread.execute(new Runnable(){

                @Override
                public void run() {
                    for(int i=0;i<10;i++){
                         StringBuffer fileName=new StringBuffer("D:/random/");
                         fileName.append(i+".txt");
                         FileUtil.randomFile(fileName.toString());
                        System.out.println(i+"success");
                     }
                 }
                
            });
            cachedThread.shutdown();//关闭线程池
     }
    
    public static void threadPool() throws IOException{
        ExecutorService fixedThread=Executors.newFixedThreadPool(10);
        
         fixedThread.execute(new Runnable() {
           
                 @Override
                 public void run(){
                     long start=System.nanoTime();
                     File file2=new File("D:/random4");
                     File[] filelist2=file2.listFiles();
                     for(int i=1;i<filelist2.length;i++){
                         FileUtil.count=-1;
                         String reader="D:/random4/"+filelist2[i].getName();
                         System.out.println(reader);
                         FileUtil.fileReader(reader);
                         System.out.println("end");
                        // System.out.println(i);
                         String writerFile="D:/random/_"+i+".txt"; 
                         FileUtil.fileWriter(writerFile, DataUtil.comp(DataUtil.p));
                         System.out.println(i);
                    }
                    //
                     String writerFile="D:/random/_"+"topTen"+".txt"; 
                     FileUtil.fileWriter(writerFile, DataUtil.comp(DataUtil._Map ));
                     long end=System.nanoTime()-start;
                     System.out.println("成功");
                     System.out.println(end);
                   
             }
         });
            

       
         fixedThread.shutdown();
        
        
        
    }
    
    public static void main(String[] args) throws IOException {
        
           long start=System.nanoTime();
          /*  for (int i = 0; i < 10; i++) {
                String filename1 = "C:/Users/lingxiang/Desktop/" + i + ".txt";
                FileUtil.count=0;
                FileUtil.fileReader(filename1);
                System.out.println(i + "success");
               
            }
            System.out.println(FileUtil.count);*/
          
        /*   File file=new File("D:/random1");
            File[] filelist=file.listFiles();
            for (int i = 0; i < filelist.length; i++) {
                FileUtil.count=1;
                String filename = "D:/random1/" + filelist[i].getName();
                System.out.println(filename);
                FileUtil.fileReader(filename);
                System.out.println(i+ "success");
            }*/
      
      /*  File file2=new File("D:/random4");
        File[] filelist2=file2.listFiles();
        for(int i=1;i<filelist2.length;i++){
            FileUtil.count=-1;
            String reader="D:/random4/"+filelist2[i].getName();
            System.out.println(reader);
            FileUtil.fileReader(reader);
            System.out.println("end");
           // System.out.println(i);
            String writerFile="D:/random/_"+i+".txt"; 
            FileUtil.fileWriter(writerFile, DataUtil.comp(DataUtil.p));
       }
       
        String writerFile="D:/random/_"+"topTen"+".txt"; 
        FileUtil.fileWriter(writerFile, DataUtil.comp(DataUtil._Map ));
        long end=System.nanoTime()-start;
        System.out.println("成功");
        System.out.println(end);*/
  
  
   /*    
      StringBuffer readerFile=new StringBuffer("D:/random1/a.txt");//读取文件
        StringBuffer writerFile=new StringBuffer("D:/random2/a.txt");//读取文件
        FileUtil.fileReader(readerFile.toString());
        System.out.println("*************************************************************************");
        FileUtil.fileWriter(writerFile.toString(), DataUtil.comp());
        long end=System.nanoTime();
        System.out.println("成功");
        System.out.println(end);*/
            
          //  threadPool();
           int i;
           for(i=2;i<=10;i++){
           System.out.println(i);
           }   

    }
}
     
