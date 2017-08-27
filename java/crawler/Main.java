package crawler;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static String sendGet(String url){
        
        BufferedReader bin=null;
        String result="";
        try {
            URL realUrl=new URL(url);//将Stirng转成url对象
            URLConnection connection=realUrl.openConnection();//初始化连接
            connection.connect();//开始实际的连接
            bin=new BufferedReader(new InputStreamReader(connection.getInputStream()));//初始化输入流获得连接
            String line=null;//存储每一行抓取的数据
           
            while((line=bin.readLine())!=null){
                result+=line;
            }
            
            
            
        } catch (Exception e) {
            System.out.println("发送请求get 异常");
            e.printStackTrace();
        }finally{
            if(bin !=null){
                try {
                    bin.close();
                } catch (IOException e) {
               
                    e.printStackTrace();
                }
            }
        }
      return result;
    }
    
    public static String regexString(String targetStr,String patternStr){
        Pattern pattern=Pattern.compile(patternStr);
        Matcher matcher=pattern.matcher(targetStr);
        if(matcher.find()){
            return matcher.group(1);
        }
        return null;
    }
    public static void main(String[] args){
        
        
        ExecutorService cachedThread=Executors.newCachedThreadPool();
        
            cachedThread.execute(new Runnable(){
                String url="http://blog.csdn.net/m0_37897828/article/details/77161713";
                
                @Override
                public void run() {
                    for(int i=0;i<300 ;i++){
                    String str=sendGet(url);
                    System.out.println("AB");
                }
                }
                
            });
     
        
        cachedThread.shutdown();
        
     }

       
    

}
