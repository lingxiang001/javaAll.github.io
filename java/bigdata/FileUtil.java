package bigdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件操作类
 * @author lingxiang
 *
 */
public class FileUtil {
   static  Map<String,Integer> map=new HashMap();
   static int count=0;
    /**
     * 写入一个G文件
     * @param fileName
     */
    public static void randomFile(String fileName){
        File file=creatFile(fileName);
        saveFile(file);
    }
    /**
     * 创建文件
     * @param fileName
     */
    public static File creatFile(String fileName){
        //创建文件
        File file=new File(fileName);
        if(! file.exists()){
            try {
             file.createNewFile();
         } catch (IOException e) {
             e.printStackTrace();
         }
        }
        return file;
    }
    private static void saveFile(File file) {
        try { 
            FileChannel fc=new RandomAccessFile(file, "rws").getChannel();
            ByteBuffer bb=ByteBuffer.allocateDirect(100);
            while(fc.size()<=1024*1024*1024){
                StringBuffer sb=new StringBuffer("");
                for(int i=0;i<10000;i++){
                    sb.append(RandomUtil.randomString());
                }
                fc.write(ByteBuffer.wrap(sb.toString().getBytes()),fc.size());
            }
        } catch (Exception e) {
           
            e.printStackTrace();
        }
    }
    
    public static Map<String,Integer> fileReader(String readerFile){
      
        try {
           
            File file=new File(readerFile);
            final int BUFFER_SIZE=0x2500000;
            ByteBuffer bf=ByteBuffer.allocateDirect(1024);
            RandomAccessFile raf= new RandomAccessFile(file,"rws");
            FileChannel fc=raf.getChannel();
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()); 
            byte[] dist=new byte[BUFFER_SIZE];
            
            for(int offerSet=0;offerSet<mbb.capacity();offerSet+=BUFFER_SIZE){
               
                if((mbb.capacity()-offerSet)>=BUFFER_SIZE){
                    for(int i=0;i<BUFFER_SIZE;i++){
                        dist[i]=mbb.get(offerSet+i);
                    }  
                }else{
                    for(int i=0;i<mbb.capacity()-offerSet;i++){
                        dist[i]=mbb.get(offerSet+i);
                    }
                }
                int length=dist.length;
                String str=new String(dist,0,length);//得到字符串
              
                //进行分词处理
                if(file.length()>=50*1014*1024){
                    DataUtil.fenCi(str,count);//为数据分类，缩小数据
                }else{
                    DataUtil.fenCi(str,-1);//给数据统计词频
                   
                }
              
            }
            count++;
            fc.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        return map;
    }
    
    public static void fileWriter(String fileName,String str){
        File file=creatFile(fileName);
        try {
            FileChannel fc=new RandomAccessFile(file, "rws").getChannel();
            ByteBuffer bb=ByteBuffer.allocateDirect(100);
            fc.write(ByteBuffer.wrap(str.getBytes()),fc.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        
    }
  
    public static void main(String[] args) {
        fileReader("D:/random1/a.txt");
    }

}
