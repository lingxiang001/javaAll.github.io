package random;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 随机创建100M的字符串存入文件里
 * @author lingxiang
 *
 */

public class _100Mrandom {
   /**
    * 创建文件
    * @param fileName
    */
   public static void creatFile(String fileName){
       //创建文件
       File file=new File(fileName);
       if(! file.exists()){
           try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
       }
       //写文件
       outputFile(file);
   }
   
 //   private static  File file=new File("C:/Users/lingxiang/Desktop/random.txt");//存入的文件
    /**
     * 生成随即字符串
     * @return
     */
    public static  String getStringRandom(){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random=new Random();
        StringBuffer sb=new StringBuffer(" ");
        for(int i=0;i<5;i++){
            int num=random.nextInt(52);
            sb.append(str.charAt(num));
        }
       
        return sb.toString();
    }
    /**
     * 将字符串用nio存入文件了
     */
    public static  void outputFile(File file){
        try { 
            FileChannel fc=new RandomAccessFile(file, "rws").getChannel();
            ByteBuffer bb=ByteBuffer.allocateDirect(100);
            while(fc.size()<=1024*1024*1024){
                StringBuffer sb=new StringBuffer("");
                for(int i=0;i<10000;i++){
                    sb.append(getStringRandom());
                }
                writeFileByLine(fc,sb.toString());
            }
        } catch (Exception e) {
           
            e.printStackTrace();
        }
    }
    public static void writeFileByLine(FileChannel fcout, String line){
        try {
            fcout.write(ByteBuffer.wrap(line.getBytes()), fcout.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void inputFile(){
        File file2=new File("C:/Users/lingxiang/Desktop/random2.txt");
        ByteBuffer bf=ByteBuffer.allocateDirect(1024);
        try {
            FileChannel fc=new RandomAccessFile(file2,"rws").getChannel();
            int a=fc.read(bf);
            String str="";
            while(a!=-1){
                bf.flip();
                Charset charset=Charset.forName("UTF-8");
                CharBuffer charBuffer=charset.decode(bf);
                while(charBuffer.hasRemaining()){
                    System.out.print(charBuffer.get());
                }
                bf.clear();
                a=fc.read(bf);
            }
            MappedByteBuffer mbb=fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            mbb.flip();
            fc.close();
            
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
    }
    /**
     * 线程池创建多个线程完成字符串存入文件任务
     */
    public static void threadPoolOutPut(){
        
        ExecutorService cachedThread=Executors.newCachedThreadPool();
        
            cachedThread.execute(new Runnable(){

                @Override
                public void run() {
                    for(int i=0;i<10;i++){
                         StringBuffer sb=new StringBuffer("C:/Users/lingxiang/Desktop/");
                        sb.append(i+".txt");
                        creatFile(sb.toString());
                        System.out.println(i+"success");
                     }
                 }
                
            });
            cachedThread.shutdown();
            
        
      
    }
    public static void main(String[] args){
       
        threadPoolOutPut();
       // inputFile();
       
        
     
    }

}
