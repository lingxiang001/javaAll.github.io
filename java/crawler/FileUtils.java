package crawler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public enum FileUtils {
    me;
    public File createFile(){
        File file=new File("url.txt");
        if(!file.exists() ){
            try {
                file.createNewFile();
            } catch (IOException e) {
               
                e.printStackTrace();
            }
        }
        return file;
    }
    
    public void saveFile(String url){
        File file=createFile();
        try {
            FileChannel filechannel=new RandomAccessFile(file,"rws").getChannel();
            ByteBuffer buffer=ByteBuffer.allocate(1024);
            filechannel.write(ByteBuffer.wrap(url.getBytes()),filechannel.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
           
            e.printStackTrace();
        }
        
    }

}
