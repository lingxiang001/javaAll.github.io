package bigdata;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharArrayMap.EntrySet;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.WhitespaceAnalyzer;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;

/**
 * 数据分词，数据排序，查重处理 
 * @author lingxiang
 *
 */
public class DataUtil {
    static Map<String,Integer> _Map=new HashMap();
    static  Map<String,Integer> p=new HashMap();
    /**
     * flag为真：
     * 对字符串分词，并将相同首字母的数据存入相同文件
     * flag为假
     * 为字符统计词频
     * @param str
     */
    static private int index=0;
    public static void fenCi(String str,int flag){
         char ch=0;
         StringBuffer sb1=new StringBuffer("");
         StringBuffer sb2=new StringBuffer("");
         StringBuffer sb3=new StringBuffer("");
         StringBuffer sb4=new StringBuffer("");
         StringBuffer sb5=new StringBuffer("");
         StringBuffer sb6=new StringBuffer("");
         StringBuffer sb7=new StringBuffer("");
         StringBuffer sb8=new StringBuffer("");
         StringBuffer sb9=new StringBuffer("");
         StringBuffer sb10=new StringBuffer("");
         StringBuffer sb11=new StringBuffer("");
         StringBuffer sb12=new StringBuffer("");
         StringBuffer sb13=new StringBuffer("");
         StringBuffer sb14=new StringBuffer("");
         StringBuffer sb15=new StringBuffer("");
         StringBuffer sb16=new StringBuffer("");
         StringBuffer sb17=new StringBuffer("");
         StringBuffer sb18=new StringBuffer("");
         StringBuffer sb19=new StringBuffer("");
         StringBuffer sb20=new StringBuffer("");
         StringBuffer sb21=new StringBuffer("");
         StringBuffer sb22=new StringBuffer("");
         StringBuffer sb23=new StringBuffer("");
         StringBuffer sb24=new StringBuffer("");
         StringBuffer sb25=new StringBuffer("");
         StringBuffer sb26=new StringBuffer("");
         StringBuffer sb27=new StringBuffer("");
         StringBuffer sb28=new StringBuffer("");
         StringBuffer sb29=new StringBuffer("");
         StringBuffer sb30=new StringBuffer("");
         StringBuffer sb31=new StringBuffer("");
         StringBuffer sb32=new StringBuffer("");
         StringBuffer sb33=new StringBuffer("");
         StringBuffer sb34=new StringBuffer("");
         StringBuffer sb35=new StringBuffer("");
         StringBuffer sb36=new StringBuffer("");
         StringBuffer sb37=new StringBuffer("");
         StringBuffer sb38=new StringBuffer("");
         StringBuffer sb39=new StringBuffer("");
         StringBuffer sb40=new StringBuffer("");
         StringBuffer sb41=new StringBuffer("");
         StringBuffer sb42=new StringBuffer("");
         StringBuffer sb43=new StringBuffer("");
         StringBuffer sb44=new StringBuffer("");
         StringBuffer sb45=new StringBuffer("");
         StringBuffer sb46=new StringBuffer("");
         StringBuffer sb47=new StringBuffer("");
         StringBuffer sb48=new StringBuffer("");
         StringBuffer sb49=new StringBuffer("");
         StringBuffer sb50=new StringBuffer("");
         StringBuffer sb51=new StringBuffer("");
         StringBuffer sb52=new StringBuffer("");
         HashMap<Character ,HashMap<String,Integer> > _1map=new HashMap(52);
         Analyzer analyzer = new WhitespaceAnalyzer();      
         Reader r = new StringReader(str);      
         StringReader reader = new StringReader(str);  
         TokenStream ts = analyzer.tokenStream(str, reader); 
         TermAttribute termAttribute =ts.getAttribute(TermAttribute.class);   
         if(flag==1){
             try {
                 char c='a';
                 while (ts.incrementToken()) {  
                         String word=termAttribute.term();
                         c=word.charAt(0);
                         int index=word.hashCode()%5;//给字符串哈希,将一个文件分成5份
                         if(index==0){
                             sb1.append(word+" ");
                         }else if(index==1){
                             sb2.append(word+" ");
                         }else if(index==2){
                             sb3.append(word+" ");
                         }else if(index==3){
                             sb4.append(word+" ");
                         }else{
                             sb5.append(word+" ");
                         }
                    }
                 String filename1="";
                 String filename2="";
                 String filename3="";
                 String filename4="";
                 String filename5="";
                
                   if((int)c<97){
                       filename1="D:/random4/_"+c+"0.txt";
                       filename2="D:/random4/_"+c+"1.txt";
                       filename3="D:/random4/_"+c+"2.txt";
                       filename4="D:/random4/_"+c+"3.txt";
                       filename5="D:/random4/_"+c+"4.txt";
                   }else{
                       filename1="D:/random4/"+c+"0.txt";
                       filename2="D:/random4/"+c+"1.txt";
                       filename3="D:/random4/"+c+"2.txt";
                       filename4="D:/random4/"+c+"3.txt";
                       filename5="D:/random4/"+c+"4.txt";
                       
                   }
                    
                    
                    FileUtil.fileWriter(filename1, sb1.toString());
                    FileUtil.fileWriter(filename2, sb2.toString());
                    FileUtil.fileWriter(filename3, sb3.toString());
                    FileUtil.fileWriter(filename4, sb4.toString());
                    FileUtil.fileWriter(filename5, sb5.toString());
                    System.out.println("再分配");
             } catch (IOException e) {
                 
                 e.printStackTrace();
             }
         }else if(flag==0){
             try {
                 char c='a';
                 while (ts.incrementToken()) {  
                         String word=termAttribute.term();
                         ch=word.charAt(0);
                         
                         
                         switch(ch){
                         case 'a':
                             
                             sb1.append(word+" ");
                             break;
                         case 'b':
                             sb2.append(word+" ");
                             break;
                         case 'c':
                             sb3.append(word+" ");
                             break;
                         case 'd':
                             sb4.append(word+" ");
                             break;
                         case 'e':
                             sb5.append(word+" ");
                             break;
                         case 'f':
                             sb6.append(word+" ");
                             break;
                         case 'g':
                             sb7.append(word+" ");
                             break;
                         case 'h':
                             sb8.append(word+" ");
                             break;
                         case 'i':
                             sb9.append(word+" ");
                             break;
                         case 'j':
                             sb10.append(word+" ");
                             break;
                         case 'k':
                             sb11.append(word+" ");
                             break;
                         case 'l':
                             sb12.append(word+" ");
                             break;
                         case 'm':
                             sb13.append(word+" ");
                             break;
                         case 'n':
                             sb14.append(word+" ");
                             break;
                         case 'o':
                             sb15.append(word+" ");
                             break;
                         case 'p':
                             sb16.append(word+" ");
                             break;
                         case 'q':
                             sb17.append(word+" ");
                             break;
                         case 'r':
                             sb18.append(word+" ");
                             break;
                         case 's':
                             sb19.append(word+" ");
                             break;
                         case 't':
                             sb20.append(word+" ");
                             break;
                         case 'u':
                             sb21.append(word+" ");
                             break;
                         case 'v':
                             sb22.append(word+" ");
                             break;
                         case 'w':
                             sb23.append(word+" ");
                             break;
                         case 'x':
                             sb24.append(word+" ");
                             break;
                         case 'y':
                             sb25.append(word+" ");
                             break;
                         case 'z':
                             sb26.append(word+" ");
                             break;
                         case 'A':
                           //  System.out.println("this is big ");
                             sb27.append(word+" ");
                             break;
                         case 'B':
                             sb28.append(word+" ");
                             break;
                         case 'C':
                             sb29.append(word+" ");
                             break;
                         case 'D':
                             sb30.append(word+" ");
                             break;
                         case 'E':
                             sb31.append(word+" ");
                             break;
                         case 'F':
                             sb32.append(word+" ");
                             break;
                         case 'G':
                             sb33.append(word+" ");
                             break;
                         case 'H':
                             sb34.append(word+" ");
                             break;
                         case 'I':
                             sb35.append(word+" ");
                             break;
                         case 'J':
                             sb36.append(word+" ");
                             break;
                         case 'K':
                             sb37.append(word+" ");
                             break;
                         case 'L':
                             sb38.append(word+" ");
                             break;
                         case 'M':
                             sb39.append(word+" ");
                             break;
                         case 'N':
                             sb40.append(word+" ");
                             break;
                         case 'O':
                             sb41.append(word+" ");
                             break;
                         case 'P':
                             sb42.append(word+" ");
                             break;
                         case 'Q':
                             sb43.append(word+" ");
                             break;
                         case 'R':
                             sb44.append(word+" ");
                             break;
                         case 'S':
                             sb45.append(word+" ");
                             break;
                         case 'T':
                             sb46.append(word+" ");
                             break;
                         case 'U':
                             sb47.append(word+" ");
                             break;
                         case 'V':
                             sb48.append(word+" ");
                             break;
                         case 'W':
                             sb49.append(word+" ");
                             break;
                         case 'X':
                             sb50.append(word+" ");
                             break;
                         case 'Y':
                             sb51.append(word+" ");
                             break;
                         case 'Z':
                             sb52.append(word+" ");
                             break;
                          default:
                              break;
                         }
                             
                 }
                 String fileName1="D:/random1/a.txt";
                 String fileName2="D:/random1/b.txt";
                 String fileName3="D:/random1/c.txt";
                 String fileName4="D:/random1/d.txt";
                 String fileName5="D:/random1/e.txt";
                 String fileName6="D:/random1/f.txt";
                 String fileName7="D:/random1/g.txt";
                 String fileName8="D:/random1/h.txt";
                 String fileName9="D:/random1/i.txt";
                 String fileName10="D:/random1/"+'j'+".txt";
                 String fileName11="D:/random1/"+'k'+".txt";
                 String fileName12="D:/random1/"+'l'+".txt";
                 String fileName13="D:/random1/"+'m'+".txt";
                 String fileName14="D:/random1/"+'n'+".txt";
                 String fileName15="D:/random1/"+'o'+".txt";
                 String fileName16="D:/random1/"+'p'+".txt";
                 String fileName17="D:/random1/"+'q'+".txt";
                 String fileName18="D:/random1/"+'r'+".txt";
                 String fileName19="D:/random1/"+'s'+".txt";
                 String fileName20="D:/random1/"+'t'+".txt";
                 String fileName21="D:/random1/"+'u'+".txt";
                 String fileName22="D:/random1/"+'v'+".txt";
                 String fileName23="D:/random1/"+'w'+".txt";
                 String fileName24="D:/random1/"+'x'+".txt";
                 String fileName25="D:/random1/"+'y'+".txt";
                 String fileName26="D:/random1/"+'z'+".txt";
                 String fileName27="D:/random1/_A.txt";
                 String fileName28="D:/random1/_B.txt";
                 String fileName29="D:/random1/_C.txt";
                 String fileName30="D:/random1/_D.txt";
                 String fileName31="D:/random1/_E.txt";
                 String fileName32="D:/random1/_F.txt";
                 String fileName33="D:/random1/_G.txt";
                 String fileName34="D:/random1/_H.txt";
                 String fileName35="D:/random1/_I.txt";
                 String fileName36="D:/random1/_J.txt";
                 String fileName37="D:/random1/_K.txt";
                 String fileName38="D:/random1/_L.txt";
                 String fileName39="D:/random1/_M.txt";
                 String fileName40="D:/random1/_N.txt";
                 String fileName41="D:/random1/_O.txt";
                 String fileName42="D:/random1/_P.txt";
                 String fileName43="D:/random1/_Q.txt";
                 String fileName44="D:/random1/_R.txt";
                 String fileName45="D:/random1/_S.txt";
                 String fileName46="D:/random1/_T.txt";
                 String fileName47="D:/random1/_U.txt";
                 String fileName48="D:/random1/_V.txt";
                 String fileName49="D:/random1/_W.txt";
                 String fileName50="D:/random1/_X.txt";
                 String fileName51="D:/random1/_Y.txt";
                 String fileName52="D:/random1/_Z.txt";
                 FileUtil.fileWriter(fileName1, sb1.toString());
                 FileUtil.fileWriter(fileName2, sb2.toString());
                 FileUtil.fileWriter(fileName3, sb3.toString());
                 FileUtil.fileWriter(fileName4, sb4.toString());
                 FileUtil.fileWriter(fileName5, sb5.toString());
                 FileUtil.fileWriter(fileName6, sb6.toString());
                 FileUtil.fileWriter(fileName7, sb7.toString());
                 FileUtil.fileWriter(fileName8, sb8.toString());
                 FileUtil.fileWriter(fileName9, sb9.toString());
                 FileUtil.fileWriter(fileName10, sb10.toString());
                 FileUtil.fileWriter(fileName11, sb11.toString());
                 FileUtil.fileWriter(fileName12, sb12.toString());
                 FileUtil.fileWriter(fileName13, sb13.toString());
                 FileUtil.fileWriter(fileName14, sb14.toString());
                 FileUtil.fileWriter(fileName15, sb15.toString());
                 FileUtil.fileWriter(fileName16, sb16.toString());
                 FileUtil.fileWriter(fileName17, sb17.toString());
                 FileUtil.fileWriter(fileName18, sb18.toString());
                 FileUtil.fileWriter(fileName19, sb19.toString());
                 FileUtil.fileWriter(fileName20, sb20.toString());
                 FileUtil.fileWriter(fileName21, sb21.toString());
                 FileUtil.fileWriter(fileName22, sb22.toString());
                 FileUtil.fileWriter(fileName23, sb23.toString());
                 FileUtil.fileWriter(fileName24, sb24.toString());
                 FileUtil.fileWriter(fileName25, sb25.toString());
                 FileUtil.fileWriter(fileName26, sb26.toString());
                 FileUtil.fileWriter(fileName27, sb27.toString());
                 FileUtil.fileWriter(fileName28, sb28.toString());
                 FileUtil.fileWriter(fileName29, sb29.toString());
                 FileUtil.fileWriter(fileName30, sb30.toString());
                 FileUtil.fileWriter(fileName31, sb31.toString());
                 FileUtil.fileWriter(fileName32, sb32.toString());
                 FileUtil.fileWriter(fileName33, sb33.toString());
                 FileUtil.fileWriter(fileName34, sb34.toString());
                 FileUtil.fileWriter(fileName35, sb35.toString());
                 FileUtil.fileWriter(fileName36, sb36.toString());
                 FileUtil.fileWriter(fileName37, sb37.toString());
                 FileUtil.fileWriter(fileName38, sb38.toString());
                 FileUtil.fileWriter(fileName39, sb39.toString());
                 FileUtil.fileWriter(fileName40, sb40.toString());
                 FileUtil.fileWriter(fileName41, sb41.toString());
                 FileUtil.fileWriter(fileName42, sb42.toString());
                 FileUtil.fileWriter(fileName43, sb43.toString());
                 FileUtil.fileWriter(fileName44, sb44.toString());
                 FileUtil.fileWriter(fileName45, sb45.toString());
                 FileUtil.fileWriter(fileName46, sb46.toString());
                 FileUtil.fileWriter(fileName47, sb47.toString());
                 FileUtil.fileWriter(fileName48, sb48.toString());
                 FileUtil.fileWriter(fileName49, sb49.toString());
                 FileUtil.fileWriter(fileName50, sb50.toString());
                 FileUtil.fileWriter(fileName51, sb51.toString());
                 FileUtil.fileWriter(fileName52, sb52.toString());
                 System.out.println("分配10G");
                 }catch(IOException e){
                      e.printStackTrace();
                 }
         }       
           else{
             try {
                 while (ts.incrementToken()) {  
                      String word=termAttribute.term();
                      
                         if(p.containsKey(word)){
                             int value=p.get(word);
                             p.put(word, ++value);
                         }else{
                             p.put(word, 1);
                         }
                   }
                 System.out.println("map");
             } catch (IOException e) {
                
                 e.printStackTrace();
             }
             
         }
    }
    /**
     * 将大写转为小写
     * @param ch
     * @return
     */
    public static char change(char ch){

        String sb=ch+"";
        String s= sb.toLowerCase();
        
        return s.charAt(0);
         
     }
    /**
     * 堆排序，选出每个文件的前十个
     * @param map
     */
    public static EntryNode[] node(Map<String,Integer> map){
      
        int count=10;//构建10 个数的小顶堆
        int i=0;
        int count2=0;
        EntryNode[] node=new EntryNode[10];
      
       for( Map.Entry<String, Integer> entry : map.entrySet()){
           if(count2>=1){
               node[i]=new EntryNode(entry);
               i++;
               if(i==10){
                   break;
               }
           }
           count2++;
          
       }
      
        return node;
    }
    public  static EntryNode[] heapSort(EntryNode[] node){
       
       int count=node.length;
       for(int m=count/2-1;m>=0;m--){
           minHeap(node,m,count);
       }
       for(int m=node.length-1;m>=1;m--){
           swap(node,0,m);
           minHeap(node,0,m);
       }
      
       return node;
       
       }
    public static String comp(Map<String,Integer> p){
       
        EntryNode[] node1=node( p);
        EntryNode[] node=heapSort(node1);
        int i=0;
        for(Map.Entry<String, Integer> entry:p.entrySet()){
       
          if(i>=10){
                EntryNode en=new EntryNode(entry);
                if(node[node.length-1].getEntry().getValue()<en.getEntry().getValue()){
                    node[node.length-1]=en;
                    heapSort(node);
                    //en=null;
                }
            }
            i++;
          
        }
       
        //将排好序的数组转成map
       StringBuffer sb=new StringBuffer("");
       
       for(int m=0;m<node.length;m++){
           _Map.put(node[m].getEntry().getKey(), node[m].getEntry().getValue()); 
          sb.append(node[m].getEntry().getKey()+"  "  ).append(node[m].getEntry().getValue()+"  ");
       }
       p.clear();
       
       return sb.toString();
    }
          
  
   
    private static void swap(EntryNode[] node, int i, int m) {
       EntryNode temp=node[i];
       node[i]=node[m];
       node[m]=temp; 
    }
    private static void minHeap(EntryNode[] node, int m, int count) {
        int j=m*2+1;//指向左孩子
        EntryNode parent=node[m];
        
        while(j<count){
            if(j+1<count && node[j].getEntry().getValue()>node[j+1].getEntry().getValue()){//左右孩子比较
                j++;
            }
            if(parent.getEntry().getValue()>node[j].getEntry().getValue()){
               node[m]=node[j];
               m=j;
                j=m*2+1;
            }else{
                break;
            }
            node[m]=parent;
          
        }
        
    }
    public static void main(String[] args) {
     
    }

}
