package digui;

import java.util.ArrayList;

//求字符串中字符的所有排列组合
public class _1String {
    public static void main(String[] args) {
        System.out.println(getParam("ABCD"));
        
    }
    public static ArrayList<String> getParam(String str){
        ArrayList<String> list=new ArrayList<String>();
         ArrayList<String> help=new ArrayList<String>();
        if(str == null){
            return null;
        }
        if(str.length() == 0){
            list.add("");
            return list;
        }
       char first=str.charAt(0);//取得第一个字符；
       String remain=str.substring(1);//移出第一个字符
       help=getParam(remain);
       for(String s:help){
           for(int i=0;i<=s.length();i++){
               String ss=insert(s,first,i);
               list.add(ss);
           }
       }
       return list;
        
    }
    private static String insert(String s, char first, int i) {
        String start=s.substring(0,i);
        String end=s.substring(i);
        return s=start+first+end;
    }
   
}
