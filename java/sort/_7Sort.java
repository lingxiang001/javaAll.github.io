package sort;

import java.util.Arrays;

public class _7Sort {
    public static boolean countingSort(String str1,String str2){
        int max;
        int min;
        int len;
        char[] tmpArr=str1.toCharArray();
        int[] help=new int[str1.length()];
        for(int i=0;i<help.length;i++){
            help[i]=tmpArr[i];
        }
        max=help[0];
       min=help[0];
        for(int i=0;i<help.length;i++){
            max=Math.max(help[i], max);
            min=Math.min(help[i], min);
        }
        System.out.println("max: "+max+"min:"+min);
       len=max-min+1;
       int[] helpArr=new int[len];
       for(int i:help){
           helpArr[i-min]++;
       }
       System.out.println(Arrays.toString(tmpArr));
       System.out.println(Arrays.toString(help));
       System.out.println(Arrays.toString(helpArr));
       char[] tmp2Arr=str2.toCharArray();
       int[] help2=new int[str2.length()];
       
       for(int i=0;i<help2.length;i++){
           help2[i]=tmp2Arr[i];
       }
       System.out.println(Arrays.toString(help2));
       for(int i:help2){
           try{
               if(helpArr[i-min]==0){
                   System.out.println("原str1中不存在"+(char)i);
                   return false;
               }
               
           }catch(Exception e){
               System.out.println("不匹配");
               return false;
           }
         
       }
       System.out.println("成功");
        return false;
        
    }
    public static void main(String[] args) {
        String str1="acdefg";
        String str2="abc";
        countingSort(str1, str2);

    }

}
