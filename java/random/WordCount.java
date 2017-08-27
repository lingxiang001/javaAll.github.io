package random;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apache.lucene.util.Version;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;

import sql.jdbc_utils.JDBCFacadeImpl;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.SimpleAnalyzer;
import org.apache.lucene.analysis.StopAnalyzer;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.Token;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

public class WordCount {
   // static  File file2=new File("C:/Users/lingxiang/Desktop/0.txt");
    static RandomAccessFile raf=null;
    static volatile boolean flag=true;
    static  HashMap<String,Integer> mm=new HashMap<String,Integer>();
    int count=0; 
   synchronized  public static void inputDB( String filename1,String filename2,String filename){
        File file2=new File(filename);
        ByteBuffer bf=ByteBuffer.allocateDirect(1024*100);
        try {
            final int BUFFER_SIZE=0x1000000;
            raf=new RandomAccessFile(file2,"rws");
            FileChannel fc=raf.getChannel();
            int a=fc.read(bf);
            MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()); 
            byte[] dist=new byte[BUFFER_SIZE];
            for(int offerSet=0;offerSet<mbb.capacity();offerSet+=BUFFER_SIZE){
              //  System.out.println(mbb.position());
                if((mbb.capacity()-offerSet)>=BUFFER_SIZE){
                    for(int i=0;i<BUFFER_SIZE;i++){
                        dist[i]=mbb.get(offerSet+i);
                      
                    }
                  
                }else{
                    for(int i=0;i<mbb.capacity()-offerSet;i++){
                        dist[i]=mbb.get(offerSet+i);
                    }
                }
                int length=mbb.capacity()%BUFFER_SIZE==0?BUFFER_SIZE:mbb.capacity()%BUFFER_SIZE;
                
                String str=new String(dist,0,length);
                System.out.println(str);
                fenCi(str,filename1,filename2);
            }
            
            
       
            
            fc.close();
            System.out.println("ending   ");
            
        } catch (FileNotFoundException e) {
            
            e.printStackTrace();
        } catch (IOException e) {
            
            e.printStackTrace();
        }
        
    }
   public static  void mm(String filename2){
     //总的前十；
       Set key2=mm.keySet();
       ArrayList<Map.Entry<String,Integer>>  list3=null;
       StringBuffer sb2=new StringBuffer("");
       for(Object k:key2){
             list3=new ArrayList(mm.entrySet());
           Collections.sort(list3,new Comparator<Map.Entry<String, Integer>>(){

             @Override
             public int compare(Entry<java.lang.String, Integer> arg0,
                     Entry<java.lang.String, Integer> arg1) {
                    return arg0.getValue()-arg1.getValue();
                   }

              
       });
      
           
          
       }    
    // sb2.append(k+":   ");
       for(int i=0;i<10;i++){
           sb2.append(list3.get(i));
           System.out.println(list3.get(i));
           
         //  mm.put(list.get(i).getKey(), list.get(i).getValue());
       }
       sb2.append("       "+"\n");
       saveFile(filename2,sb2.toString());
      
   }
   
  
    
   synchronized  public static void fenCi(String str2,String filename1,String filename2) throws IOException{
       
       char ch=0;
       HashMap<Character ,HashMap<String,Integer> > tallmap=new HashMap(26);
      
        Analyzer analyzer = new WhitespaceAnalyzer();      
        Reader r = new StringReader(str2);      
        StringReader reader = new StringReader(str2);  
        TokenStream ts = analyzer.tokenStream(str2, reader); 
        //ArrayList<HashMap<String,Integer>>  list=new ArrayList();
        TermAttribute termAttribute =ts.getAttribute(TermAttribute.class);   
        while (ts.incrementToken()) {  
               String word=termAttribute.term();
               ch=word.charAt(0);
               ch=change(ch);
               HashMap<String,Integer> map=tallmap.get(ch);
               if(map == null){
                   map=new HashMap();
               }
               if(map.containsKey(word)){
                   int value=map.get(word);
                   map.put(word, ++value);
               }else{
                   map.put(word, 1);
               }
              tallmap.put(ch, map);
         }
        Set key=tallmap.keySet();
        StringBuffer sb=new StringBuffer("");
        for(Object k:key){
            ArrayList<Map.Entry<String,Integer>>  list=new ArrayList(tallmap.get(k).entrySet());
            Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){

              @Override
              public int compare(Entry<java.lang.String, Integer> arg0,
                      Entry<java.lang.String, Integer> arg1) {
                     return arg0.getValue()-arg1.getValue();
                    }
 
               
        });
       
            
            sb.append(k+":   ");
            for(int i=0;i<10;i++){
                sb.append(list.get(i));
               // System.out.println(list.get(i).getKey()+list.get(i).getValue());
                mm.put(list.get(i).getKey(), list.get(i).getValue());
            }
            sb.append("       "+"\n");
        }    
        saveFile(filename1,sb.toString());
       
          //每个字符的前十：
         mm(filename2);
      
       
         
    }
 
public static void saveFile( String filename,String str){
       File file=new File(filename);
       System.out.println("999");
       if(!file.exists()){
           try {
            file.createNewFile();
        } catch (IOException e) { 
            e.printStackTrace();
        }
       }
       try {
        FileChannel fc=new RandomAccessFile(file, "rws").getChannel();
        ByteBuffer bb=ByteBuffer.allocateDirect(100);
        
        writeFileByLine(fc,str);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
      
   }
   private static void writeFileByLine(FileChannel fc, String line) {
       try {
           fc.write(ByteBuffer.wrap(line.getBytes()), fc.size());
           System.out.println("out");
       } catch (IOException e) {
           e.printStackTrace();
       }
    

}
   public static char change(char ch){

      String sb=ch+"";
      String s= sb.toLowerCase();
      
      return s.charAt(0);
       
   }
    public static void threadPool() throws IOException{
        ExecutorService fixedThread=Executors.newFixedThreadPool(10);
        
         fixedThread.execute(new Runnable() {
           
                 @Override
                 public void run(){
                     for(int i=0;i<10;i++){
                         StringBuffer sb=new StringBuffer("C:/Users/lingxiang/Desktop/"+i+".txt");
                         
                         StringBuffer sb1=new StringBuffer("D:/random1/"+i+"A"+".txt");
                        
                         StringBuffer sb2=new StringBuffer("D:/random1/"+i+"B"+".txt");
                        
                         inputDB(sb1.toString(),sb2.toString(),sb.toString());  
                        
                 }
             }
         });
            

       
         fixedThread.shutdown();
        
        
        
    }
    public static void main(String[] args) throws IOException {
        
     /*  long start=System.currentTimeMillis();
       
        long end=System.currentTimeMillis()-start;
        System.out.println(end);*/
      threadPool();
       // inputDB("","","C:/Users/lingxiang/Desktop/00.txt");
     
    }

}
