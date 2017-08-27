package commons.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.ReaderInputStream;

public class IODemo {
    @SuppressWarnings("deprecation")
    public static void input(){
        InputStream in=null;
        try {
            in=new URL( "http://commons.apache.org"   ).openStream();
           System.out.println( IOUtils.toString(in));
            
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }finally{
            IOUtils.closeQuietly(in);
        }
  
    }
    
    public static void copyFile(){
        File file1=new File("C:/Users/lingxiang/Desktop/蓝桥/JAVA题库/a.txt");
        File file2=new File("C:/Users/lingxiang/Desktop/蓝桥/JAVA题库/b.txt");
        try {
            FileUtils.copyFile(file1, file2);
            
            System.out.println("success");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    

}
