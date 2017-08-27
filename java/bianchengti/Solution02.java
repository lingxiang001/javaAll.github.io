package bianchengti;

public class Solution02 {
      public static String replaceSpace(StringBuffer str) {
          String s=str.toString();
          String s1="";
          
          String[] ss=s.split(" ");
          for(int i=0;i<ss.length;i++){
             
              s1=s1+ss[i];
              if(i<ss.length-1){
                  s1=s1+"%20";
              }
          }
        return s1;
    }
      public static void main(String[] args){
          StringBuffer str=new StringBuffer(" d o n g");
          System.out.println(((Solution02)null).replaceSpace(str)); 
      }

}
